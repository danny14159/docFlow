package com.work.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.mapper.BasicDao;
import com.work.util.AjaxReturn;
import com.work.util.M;

public abstract class BasicController<BeanType> {
	@Resource
	protected HttpServletRequest request;
	
	protected abstract String getPrefix();
	protected abstract BasicDao<BeanType> getDao();

	@RequestMapping(value="/")
	public String query(BeanType obj,Model model){
		
		model.addAttribute("data", getDao().list(obj));
		return getPrefix()+"/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		
		return getPrefix()+"/insert";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable String id,Model model) {
		model.addAttribute("data", getDao().load(M.make("id", id).asMap()));
		return getPrefix() + "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(BeanType obj) {
		return getDao().update(obj);
	}
	
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public Object insert(BeanType obj){
		
		return new AjaxReturn(getDao().insert(obj) > 0);
	}
	
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	public Object delete(String id){
		
		return new AjaxReturn(getDao().delete(M.make("id", id).asMap()) > 0);
	}
}
