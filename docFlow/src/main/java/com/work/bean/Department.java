package com.work.bean;
/**
 * @author 
 *
 */
public class Department  {

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 部门名称
	 */
	private String name;

	/**
	 * 部门领导
	 */
	private Integer leader_id;

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

	public void setLeader_id(Integer leader_id){
		this.leader_id=leader_id;
	}

	public Integer getLeader_id(){
		return this.leader_id;
	}

}