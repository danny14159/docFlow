package com.work.mapper;
import org.springframework.stereotype.Repository;
import com.work.bean.Document;
/**
 * @author 
 *
 */
@Repository
public interface DocumentDao extends BasicDao<Document> {

	public int latestId();
}