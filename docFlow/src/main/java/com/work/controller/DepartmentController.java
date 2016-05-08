
package com.work.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.work.bean.Department;
import com.work.mapper.BasicDao;
import com.work.mapper.DepartmentDao;
import com.work.mapper.UserDao;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BasicController<Department>{
	
	@Resource
	private DepartmentDao DepartmentDao;
	@Resource
	private UserDao userDao;
	
	public static final String PREFIX="department/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Department> getDao() {
		return DepartmentDao;
	}

	@RequestMapping(value="/add",method=RequestMethod.GET)
	@Override
	public String add(Model model){
		
		model.addAttribute("user", userDao.list(null));
		return super.add(model);
	}
	
}
    