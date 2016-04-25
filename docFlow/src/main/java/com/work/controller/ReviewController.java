
package com.work.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.bean.Review;
import com.work.mapper.BasicDao;
import com.work.mapper.ReviewDao;

@Controller
@RequestMapping("/review")
public class ReviewController extends BasicController<Review>{
	
	@Resource
	private ReviewDao ReviewDao;
	
	public static final String PREFIX="Review/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Review> getDao() {
		return ReviewDao;
	}


}
    