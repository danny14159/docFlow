
package com.work.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.bean.Urge;
import com.work.mapper.BasicDao;
import com.work.mapper.UrgeDao;

@Controller
@RequestMapping("/urge")
public class UrgeController extends BasicController<Urge>{
	
	@Resource
	private UrgeDao UrgeDao;
	
	public static final String PREFIX="Urge/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Urge> getDao() {
		return UrgeDao;
	}


}
    