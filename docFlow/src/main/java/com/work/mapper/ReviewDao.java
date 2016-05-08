package com.work.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.work.bean.Review;
/**
 * @author 
 *
 */
@Repository
public interface ReviewDao extends BasicDao<Review> {


	public List<Review> myReview(int userid);
}