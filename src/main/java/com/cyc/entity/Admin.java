package com.cyc.entity;

/**
 * 
 * @author cyc
 * @version 1.0
 * @date 2020.3.9
 * @des 管理员表
 */
public class Admin {
	private String adId; //管理员账号
	private String password; //密码
	private String name; //姓名
	private String phone;  //联系方式
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
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
}
