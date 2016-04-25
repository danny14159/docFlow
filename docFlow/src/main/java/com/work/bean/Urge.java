package com.work.bean;
/**
 * @author 
 *
 */
public class Urge  {

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 催办人
	 */
	private Integer userid;

	/**
	 * 被催办人
	 */
	private Integer target_id;

	/**
	 * 催办内容
	 */
	private String content;

	/**
	 * 截止日期
	 */
	@org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date deadline;

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setUserid(Integer userid){
		this.userid=userid;
	}

	public Integer getUserid(){
		return this.userid;
	}

	public void setTarget_id(Integer target_id){
		this.target_id=target_id;
	}

	public Integer getTarget_id(){
		return this.target_id;
	}

	public void setContent(String content){
		this.content=content;
	}

	public String getContent(){
		return this.content;
	}

	public void setDeadline(java.util.Date deadline){
		this.deadline=deadline;
	}

	public java.util.Date getDeadline(){
		return this.deadline;
	}

}