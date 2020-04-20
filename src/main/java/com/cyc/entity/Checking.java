package com.cyc.entity;

import java.util.Date;
/**
 * 
 * @author cyc
 * @version 1.0
 * @date 2020.3.9
 * @des 待审核表
 */
public class Checking {
	private String id; //申请人学号或者工号
	private String name; // 申请人姓名
	private String lbId; //实验室号
	private String type; //实验室类型
	private String testName; // 实验名称
	private String lbAddress; // 实验室地址
	private Date date;// 申请时间
	private String classTime; // 申请的节次
	private String equipment; // 实验形式
	private String clazz; // 申请人班级
	private String testType ; // 实验类型
	
	
	public Checking() {}
	

	public Checking(String id, String name, String lbId, String type, String testName, String lbAddress, Date date,
			String classTime, String equipment, String clazz) {
		this.id = id;
		this.name = name;
		this.lbId = lbId;
		this.type = type;
		this.testName = testName;
		this.lbAddress = lbAddress;
		this.date = date;
		this.classTime = classTime;
		this.equipment = equipment;
		this.clazz = clazz;
	}

	
	public String getTestType() {
		return testType;
	}


	public void setTestType(String testType) {
		this.testType = testType;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLbId() {
		return lbId;
	}


	public void setLbId(String lbId) {
		this.lbId = lbId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTestName() {
		return testName;
	}


	public void setTestName(String testName) {
		this.testName = testName;
	}


	public String getLbAddress() {
		return lbAddress;
	}


	public void setLbAddress(String lbAddress) {
		this.lbAddress = lbAddress;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getClassTime() {
		return classTime;
	}


	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}


	public String getEquipment() {
		return equipment;
	}


	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}


	public String getClazz() {
		return clazz;
	}


	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	
}
