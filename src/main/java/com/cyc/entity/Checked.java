package com.cyc.entity;

import java.util.Date;
/**
 * 
 * @author cyc
 * @version 1.0
 * @date 2020.3.9
 * @des 已审核表
 */
public class Checked {
	private String id; // 申请人学号或者工号
	private String name; //申请人姓名
	private String clazz;// 申请人班级
	private String lbId; // 实验编号
	private String type;// 实验室类型
	private String testName; // 实验名称
	private Date date;  // 申请日期
	private String classTime; // 申请节次
	private String lbAddress; // 实验室地址
	private String result; // 审核结果
	private String description; // 批复
	private String equipment; // 实验形式
	private String  testType; //实验类型
	
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
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
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
	public String getLbAddress() {
		return lbAddress;
	}
	public void setLbAddress(String lbAddress) {
		this.lbAddress = lbAddress;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}

	
	
}
	
