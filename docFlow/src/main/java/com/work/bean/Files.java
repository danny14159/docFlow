package com.work.bean;
/**
 * @author 
 *
 */
public class Files  {

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	@org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date create_time;

	/**
	 * 
	 */
	private Integer doc_id;

	/**
	 * 
	 */
	private byte[] content;

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}

	public void setCreate_time(java.util.Date create_time){
		this.create_time=create_time;
	}

	public java.util.Date getCreate_time(){
		return this.create_time;
	}

	public void setDoc_id(Integer doc_id){
		this.doc_id=doc_id;
	}

	public Integer getDoc_id(){
		return this.doc_id;
	}

	public void setContent(byte[] content){
		this.content=content;
	}

	public byte[] getContent(){
		return this.content;
	}

}