
package com.work.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.work.bean.Document;
import com.work.mapper.BasicDao;
import com.work.mapper.DepartmentDao;
import com.work.mapper.DocumentDao;

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

	@Override
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Object insert(Document obj) {
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
}
    