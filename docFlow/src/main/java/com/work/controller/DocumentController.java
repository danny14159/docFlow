
package com.work.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.work.MainController;
import com.work.bean.Document;
import com.work.bean.Review;
import com.work.bean.User;
import com.work.mapper.BasicDao;
import com.work.mapper.DepartmentDao;
import com.work.mapper.DocumentDao;
import com.work.mapper.FilesDao;
import com.work.mapper.ReviewDao;
import com.work.security.Coder;
import com.work.util.M;

@Controller
@RequestMapping("/document")
public class DocumentController extends BasicController<Document>{
	
	@Resource
	private DocumentDao DocumentDao;
	@Resource
	private DepartmentDao departmentDao;
	@Resource
	private ReviewDao reviewDao;
	@Resource
	private FilesDao filesDao;
	
	public static final String PREFIX="document/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Document> getDao() {
		return DocumentDao;
	}
	
	@Override
	public String query(Document obj, Model model) {
		User u = MainController.getCurrentUser(request);
		obj.setCreate_user(u.getId());
		List<Document> data = getDao().list(obj);
		
		for(Document item:data){
			List<Review> review = reviewDao.list(M.make("doc_id", item.getId()).asMap());
			boolean isFinished = true;
			for(Review r:review){
				if(r.getRemark() == null){
					isFinished = false;break;
				}
			}
			item.setResults(review);
			item.setState(isFinished?"会审完成":"传阅中");
		}
		model.addAttribute("data",data);
		return getPrefix()+"/list";
	}

	@RequestMapping(value="/insert_new",method=RequestMethod.POST)
	public String insert(
			Document obj,
			MultipartFile file) throws IOException {
		User u = MainController.getCurrentUser(request);
		
		
		obj.setState("传阅中");
		obj.setCreate_time(new Date());
		obj.setCreate_user(u.getId());
		obj.setCover(file.getOriginalFilename());
		
		if(file!=null && !file.isEmpty()){
			obj.setAppendix(file.getBytes());
		}
		
		//添加公文之后要添加相应的审核记录
		String[] sig_dept = request.getParameterValues("sig_dept");
		if(sig_dept!=null)
			for(String item:sig_dept){
				Review review = new Review();
				
				review.setDept_id(Integer.parseInt(item));
				review.setDoc_id(DocumentDao.latestId() + 1);	
				
				review.setState("未处理");
				
				reviewDao.insert(review);
			}
		
		super.insert(obj);
		
		return "redirect:/document/";
	}

	@Override
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		
		model.addAttribute("dept", departmentDao.list(null));
		return super.add(model);
	}
	
	@RequestMapping("/detail")
	public String detail(Integer id,Model model){
		model.addAttribute("data", DocumentDao.load(M.make("id", id).asMap()));
		model.addAttribute("list", reviewDao.list(M.make("doc_id", id).asMap()));
		return "document/detail";
	}
	
	@RequestMapping("/reviewResult/{docId}")
	public String reviewResult(@PathVariable String docId,Model model){
		List<Review> list = reviewDao.list(M.make("doc_id", docId).asMap());
		for(Review item:list){
			try {
				item.setVerified(Coder.verify(item.getRemark().getBytes(), item.getDigest(),item.getAuthor_publicKey()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("list", list);
		return "document/reviewResult";
	}
	
	@RequestMapping("/getAppendix/{id}")
	public void download(@PathVariable Integer id,HttpServletResponse response) throws IOException{
		
		Document doc = DocumentDao.load(M.make("id", id).asMap());
		response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + doc.getCover());
		
		OutputStream os = response.getOutputStream();
		os.write(doc.getAppendix());
		
		os.close();
	}
}
    