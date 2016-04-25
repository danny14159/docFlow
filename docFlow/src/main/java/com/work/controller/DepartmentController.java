
package com.work.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.bean.Department;
import com.work.mapper.BasicDao;
import com.work.mapper.DepartmentDao;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BasicController<Department>{
	
	@Resource
	private DepartmentDao DepartmentDao;
	
	public static final String PREFIX="department/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Department> getDao() {
		return DepartmentDao;
	}


}
    