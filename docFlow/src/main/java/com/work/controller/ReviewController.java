
package com.work.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.MainController;
import com.work.bean.Review;
import com.work.bean.User;
import com.work.mapper.BasicDao;
import com.work.mapper.ReviewDao;

@Controller
@RequestMapping("/review")
public class ReviewController extends BasicController<Review>{
	
	@Resource
	private ReviewDao ReviewDao;
	
	public static final String PREFIX="review/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<Review> getDao() {
		return ReviewDao;
	}

	@Override
	public String query(Review obj, Model model) {
		User u = MainController.getCurrentUser(request);
		
		model.addAttribute("data", ReviewDao.myReview(u.getId()));
		return getPrefix()+"/list";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Review obj){
		
		obj.setTime(new Date());

		return ReviewDao.update(obj);
	}

}
    