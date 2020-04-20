package com.cyc.entity;

import java.util.Date;

public class Laboratory {
	private String lbId;// 实验室编号
	private String lbAddress;//实验室地址
	private Integer volume; // 容纳人数
	private String state; // 实验室预约状态
	private String classTime;// 节数
	private Date date; //  日期
	private String name; // 实验室名称
	private String description; // 实验室描述 
	private String type;//实验室类型
	public String getLbId() {
		return lbId;
	}
	public void setLbId(String lbId) {
		this.lbId = lbId;
	}
	public String getLbAddress() {
		return lbAddress;
	}
	public void setLbAddress(String lbAddress) {
		this.lbAddress = lbAddress;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
