package com.work.bean;
/**
 * @author 
 *
 */
public class Review  {

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 审阅时间
	 */
	@org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date time;

	/**
	 * 审阅意见
	 */
	private String remark;

	/**
	 * 公文编号
	 */
	private Integer doc_id;

	/**
	 * 部门编号
	 */
	private Integer dept_id;
	
	private String dept_name;

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	/**
	 * 审阅状态
	 */
	private String state;

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setTime(java.util.Date time){
		this.time=time;
	}

	public java.util.Date getTime(){
		return this.time;
	}

	public void setRemark(String remark){
		this.remark=remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setDoc_id(Integer doc_id){
		this.doc_id=doc_id;
	}

	public Integer getDoc_id(){
		return this.doc_id;
	}

	public void setDept_id(Integer dept_id){
		this.dept_id=dept_id;
	}

	public Integer getDept_id(){
		return this.dept_id;
	}

	public void setState(String state){
		this.state=state;
	}

	public String getState(){
		return this.state;
	}

}