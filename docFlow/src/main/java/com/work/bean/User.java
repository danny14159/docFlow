package com.work.bean;
/**
 * @author 
 *
 */
public class User  {

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 登录名
	 */
	private String loginname;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 显示名
	 */
	private String name;
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setLoginname(String loginname){
		this.loginname=loginname;
	}

	public String getLoginname(){
		return this.loginname;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}

}