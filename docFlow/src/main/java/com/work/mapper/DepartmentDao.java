package com.work.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.work.bean.Department;
/**
 * @author 
 *
 */
@Repository
public interface DepartmentDao extends BasicDao<Department> {


	public List<Department> queryOtherDeptsByReview(int reviewId);
}