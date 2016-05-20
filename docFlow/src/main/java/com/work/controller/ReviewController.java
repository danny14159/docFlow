
package com.work.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.MainController;
import com.work.bean.Review;
import com.work.bean.User;
import com.work.mapper.BasicDao;
import com.work.mapper.ReviewDao;
import com.work.security.Coder;

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
	
	@RequestMapping(value = "/update_new", method = RequestMethod.POST)
	@ResponseBody
	public Object update1(Review obj) throws Exception {
		User u = MainController.getCurrentUser(request);
		obj.setDigest(Coder.sign(obj.getRemark().getBytes(),u.getPrivateKey()));
		return getDao().update(obj);
	}

	@Override
	public String query(Review obj, Model model) {
		User u = MainController.getCurrentUser(request);
		List<Review> data = ReviewDao.myReview(u.getId());
		
		for(Review item:data){
			try {
				item.setVerified(Coder.verify(item.getRemark().getBytes(), item.getDigest(),item.getAuthor_publicKey()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("data", data);
		return getPrefix()+"/list";
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Object update(Review obj){
		
		obj.setTime(new Date());

		return ReviewDao.update(obj);
	}

}
    