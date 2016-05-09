
package com.work.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.bean.Urge;
import com.work.mapper.BasicDao;
import com.work.mapper.UrgeDao;
import com.work.mapper.UserDao;

@Controller
@RequestMapping("/urge")
public class UrgeController extends BasicController<Urge>{
	
	@Resource
	private UrgeDao UrgeDao;
	@Resource
	private UserDao userDao;
	
	public static final String PREFIX="urge/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Urge> getDao() {
		return UrgeDao;
	}


	@Override
	public String add(Model model) {
		model.addAttribute("users", userDao.list(null));
		return super.add(model);
	}
}
    