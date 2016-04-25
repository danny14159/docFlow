
package com.work.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.bean.Document;
import com.work.mapper.BasicDao;
import com.work.mapper.DocumentDao;

@Controller
@RequestMapping("/document")
public class DocumentController extends BasicController<Document>{
	
	@Resource
	private DocumentDao DocumentDao;
	
	public static final String PREFIX="Document/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Document> getDao() {
		return DocumentDao;
	}


}
    