package com.cyc.service.impl;

import java.util.List;

import com.cyc.dao.AdminDao;
import com.cyc.dao.CheckedDao;
import com.cyc.dao.CheckingDao;
import com.cyc.dao.impl.AdminDaoImpl;
import com.cyc.dao.impl.CheckedDaoImpl;
import com.cyc.dao.impl.CheckingDaoImpl;
import com.cyc.entity.Admin;
import com.cyc.entity.Checked;
import com.cyc.entity.Checking;
import com.cyc.service.AdminService;

public class AdminServiceImpl implements AdminService{

	private AdminDao adminDao = new AdminDaoImpl();
	private CheckedDao checkedDao = new CheckedDaoImpl();
	private CheckingDao checkingDao = new CheckingDaoImpl();
//	private LaboratoryDao laboratoryDao = new LaboratoryDaoImpl();
	public List<Admin> findAll() {
		return adminDao.findAll();
	}
	public List<Checking> findAllCheckings() {
		String sql = " select id,name,lb_id,type,test_name,lb_address,date,class_time,equipment,clazz,test_type "
				+ "from checking ";
		return checkingDao.findAllCheckings(sql);
	}
	
	public List<Checked> findAllCheckeds() {
		String sql = "select id,name,clazz,lb_id,type,test_name,date,class_time,lb_address,result,description,test_type "
				+ "from checked ";
		return checkedDao.findAllCheckeds(sql);
	}
	
	public boolean checkingToChecked(String lbId, String classTime,String date, String result, String description) {
		lbId = "\'" + lbId + "\'";
		classTime =  "\'" + classTime + "\'";
		date =  "\'" + date + "\'";
		description = "\'" + description + "\'";
		result =  "\'" + result + "\'";
		//1、获取checking的数据
		String sql = "select id,name,lb_id,type,test_name,lb_address,date,class_time,equipment,clazz,test_type"
				+ " from checking where lb_id = " + lbId 
				+ " and class_time = " + classTime 
				+ " and date = " + date;
		Checking  checking = checkingDao.findOneChecking(sql);
		String id = "\'" +checking.getId() + "\'";
		String name = "\'" +checking.getName() + "\'";
		String type = "\'" +checking.getType() + "\'";
		String testName = "\'" +checking.getTestName() + "\'";
		String lbAddress = "\'" +checking.getLbAddress() + "\'";
		String equipment = "\'" +checking.getEquipment() + "\'";
		String clazz = "\'" +checking.getClazz() + "\'";
		String testType = "\'" +checking.getTestType() + "\'";
		System.out.println("checkedtoChecking:"+testType);
		//2、删除checking数据
		String sql2 = " delete from checking where lb_id = " + lbId 
				+ " and class_time = " + classTime 
				+ " and date = " + date;
		checkingDao.deleteChecking(sql2);
		//3、通过id获取实验室
//		String sql4 = "select * from laboratory"
//				+ " where id = " + id 
//				+ " and lb_id = " + lbId
//				+ " and class_time = " + classTime;
//		Laboratory laboratory = laboratoryDao.findLaboratoryById(sql4);
//		String testType =  "\'" + laboratory.getType()+ "\'";
		//4、添加checked数据
		String sql3 = "insert into checked values("
					+ id + "," 
					+ name + ","
					+ clazz + ","
					+ lbId + ","
					+ type + ","
					+ testName + ","
					+ date + ","
					+ classTime + ","
					+ lbAddress + ","
					+ result + ","
					+ description + ","
					+ equipment + "," 
					+ testType + ")";
		System.out.println("sql:"+sql);
		System.out.println("删除checking数据："+sql2);
		System.out.println("sql3:"+sql3);
		return checkedDao.addChecked(sql3);
	}
	
	public boolean checkedToChecking(String lbId, String classTime, String date) {
		lbId = "\'" + lbId + "\'";
		classTime =  "\'" + classTime + "\'";
		date =  "\'" + date + "\'";
		//1、获取checked的数据
		String sql = "select id,name,clazz,lb_id,type,test_name,date,class_time,lb_address,result,description,equipment,test_type  "
				+ " from checked where lb_id = " + lbId 
				+ " and date = "+ date
				+ " and class_time = "+ classTime;
		Checked checked = checkedDao.findOneChecked(sql); // 获取单条数据
		String id = "\'" + checked.getId() + "\'";
		String name = "\'" + checked.getName() + "\'";
		String clazz = "\'" + checked.getClazz() + "\'";
		String testName = "\'" + checked.getTestName() + "\'";
		String type = "\'" + checked.getType() + "\'";
		String lbAddress = "\'" + checked.getLbAddress() + "\'";
		String equipment = "\'" + checked.getEquipment() + "\'";
		String testType =  "\'" + checked.getTestType() + "\'";
		
		//2、删除checked的数据
		String sql2 = "delete from checked "
				+ " where lb_id = " + lbId 
				+ " and date = "+ date
				+ " and class_time = "+ classTime;
		checkedDao.deleteChecked(sql2);
		//3、将从checked获取的数据放入checking
		String sql3 = "insert into checking values("
				+ id + "," 
				+ name + ","
				+ lbId + ","
				+ type + ","
				+ testName + ","
				+ lbAddress + ","
				+ date + ","
				+ classTime + ","
				+ equipment + ","
				+ clazz +  ","
				+ testType + ")";
		System.out.println(sql);
		System.out.println(sql2);
		System.out.println(sql3);
		return checkingDao.addChecking(sql3);
	}
	
	public List<Checked> selectCheckedsByType(String type) {
		type = "\'" + type + "\'";
		String sql = "select id,name,clazz,lb_id,type,test_name,date,class_time,lb_address,result,description"
				+ " from checked where type = " + type;
		System.out.println(sql);
		return checkedDao.selectCheckedsByType(sql);
	}
}
 
