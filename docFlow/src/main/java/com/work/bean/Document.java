package com.work.bean;

import java.util.Date;

/**
 * @author 
 *
 */
public class Document  {

	/**
	 * 
	 */
	private Integer id;

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	/**
	 * 公文状态
	 */
	private String state;

	/**
	 * 公文作者
	 */
	private String author;

	/**
	 * 公文内容
	 */
	private String content;

	/**
	 * 公文标题
	 */
	private String title;
	
	private Date create_time;

	private Date update_time;
	
	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setState(String state){
		this.state=state;
	}

	public String getState(){
		return this.state;
	}

	public void setAuthor(String author){
		this.author=author;
	}

	public String getAuthor(){
		return this.author;
	}

	public void setContent(String content){
		this.content=content;
	}

	public String getContent(){
		return this.content;
	}

	public void setTitle(String title){
		this.title=title;
	}

	public String getTitle(){
		return this.title;
	}

}