
package com.work.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.bean.Document;
import com.work.mapper.BasicDao;
import com.work.mapper.DepartmentDao;
import com.work.mapper.DocumentDao;
import com.work.util.M;

@Controller
@RequestMapping("/document")
public class DocumentController extends BasicController<Document>{
	
	@Resource
	private DocumentDao DocumentDao;
	@Resource
	private DepartmentDao departmentDao;
	
	public static final String PREFIX="document/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Document> getDao() {
		return DocumentDao;
	}

	@RequestMapping(value="/insert_new",method=RequestMethod.POST)
	@ResponseBody
	public Object insert(@RequestParam(value="sig_dept[]",required=false) Integer[] sig_dept,Document obj) {
		obj.setState("传阅中");
		obj.setCreate_time(new Date());
		
		return super.insert(obj);
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
		return "document/detail";
	}
}
    