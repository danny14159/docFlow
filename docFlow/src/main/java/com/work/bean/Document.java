package com.work.bean;
/**
 * @author 
 *
 */
public class Document  {

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 公文状态
	 */
	private String state;

	/**
	 * 公文作者
	 */
	private Integer author;

	/**
	 * 公文内容
	 */
	private String content;

	/**
	 * 公文标题
	 */
	private String title;

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

	public void setAuthor(Integer author){
		this.author=author;
	}

	public Integer getAuthor(){
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