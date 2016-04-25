package com.work.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.work.mapper.BasicDao;
import com.work.util.AjaxReturn;
import com.work.util.M;

public abstract class BasicController<BeanType> {
	
	protected abstract String getPrefix();
	protected abstract BasicDao<BeanType> getDao();

	@RequestMapping(value="/")
	public String query(BeanType obj,Model model){
		
		model.addAttribute("data", getDao().list(obj));
		return getPrefix()+"/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		
		return getPrefix()+"/insert";
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public Object insert(BeanType obj){
		
		return new AjaxReturn(getDao().insert(obj) > 0);
	}
	
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public Object delete(String id){
		
		return new AjaxReturn(getDao().delete(M.make("id", id).asMap()) > 0);
	}
}
