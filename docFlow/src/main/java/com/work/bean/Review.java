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
	
	/**
	 * 部门名称
	 */
	private String dept_name;
	
	/**
	 * 作者的公钥
	 */
	private String author_publicKey;
	
	public String getAuthor_publicKey() {
		return author_publicKey;
	}

	public void setAuthor_publicKey(String author_publicKey) {
		this.author_publicKey = author_publicKey;
	}

	/**
	 * 数字签名是否 
	 */
	private Boolean verified;
	
	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	/**
	 * 消息摘要，用于验证审阅意见
	 */
	private String digest;

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	/**
	 * 审阅状态
	 * 未处理
	 * 通过
	 * 不通过
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