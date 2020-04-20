package com.cyc.entity;

/** 
 * @author cyc
 * @version 1.0
 * @date 2020.3.9
 * @des 学生表
 */
public class Student {
	private String id;  // 学号
	private String password; //密码
	private String name; //学生姓名
	private String phone;  //联系方式
	private String clazz;  //所属班级
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

}	
