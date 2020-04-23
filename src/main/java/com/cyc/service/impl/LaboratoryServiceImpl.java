package com.cyc.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.cyc.dao.CheckingDao;
import com.cyc.dao.LaboratoryDao;
import com.cyc.dao.StudentDao;
import com.cyc.dao.impl.CheckingDaoImpl;
import com.cyc.dao.impl.LaboratoryDaoImpl;
import com.cyc.dao.impl.StudentDaoImpl;
import com.cyc.entity.Laboratory;
import com.cyc.entity.Student;
import com.cyc.service.LaboratoryService;

public class LaboratoryServiceImpl implements LaboratoryService{

	private LaboratoryDao laboratoryDao = new LaboratoryDaoImpl();
	private StudentDao studentDao = new StudentDaoImpl();
	private CheckingDao checkingDao = new CheckingDaoImpl();
	
	public List<Laboratory> findFreeClass(String date, String classTime) {
		date = "\'" + date +"\'";
		String sql = "";
		sql = "select  lb_id,lb_address,volume,state,class_time,date,name,description "
				+ "from laboratory "
				+ "where date = " + date  + " and state = \'未预约\' ";
		if(classTime != null && classTime != "") {
			classTime = "\'" + classTime +"\'";
			sql += " and  class_time = " + classTime;
		}
//		System.out.println("classTime:"+classTime);
		System.out.println(sql);
		return laboratoryDao.findFree(sql) ;
	}


	public boolean addChecking(String lbId, String testName, String date, String type, String equipment, String id,String classTime) {
		lbId = "\'" + lbId +"\'";
		date = "\'" + date +"\'";
		classTime = "\'" + classTime + "\'";
		testName = "\'" + testName +"\'";
		equipment = "\'" + equipment +"\'";
		id = "\'" + id +"\'";
		type = "\'" + type + "\'";  // 这个是实验类型，千万别搞混
		//1.获取学生信息
		String sql = "select * from student where id = " +id;
		Student student = studentDao.findStudentById(sql);
		String name =  "\'" +student.getName()+ "\'";
		String clazz =  "\'" +student.getClazz()+ "\'";
		
		//2. 获取实验室信息
		String sql2 = "select * from laboratory "
				+ " where lb_id = " + lbId 
				+ " and class_time = " + classTime 
				+ " and date = " + date;
		Laboratory laboratory = laboratoryDao.findLaboratoryById(sql2);
		System.out.println("获取实验室信息："+sql2);
		String lbAddress = "\'" + laboratory.getLbAddress() + "\'";
		String lb_type = "\'" + laboratory.getType() + "\'"; // 这个是实验室类型
		

		//3.判断审核表是否存在
		String sql3 = "select id from checking "
				+ " where date = " + date
				+ " and class_time = " + classTime
				+ " and lb_id =  " + lbId; 
		boolean isExist = checkingDao.findChecking(sql3);
		
		//4.判断该实验室是否空闲
		String sql4 = "select count(lb_id) from laboratory" 
				+ " where date = " + date
				+ " and class_time = " + classTime
				+ " and lb_id =  " + lbId 
				+ " and state = '未预约' "; 
		int countFree  = laboratoryDao.isFree(sql4); //没有查询到该实验室 -1为未查询，0表示未查询到，1表示查询到
		// 5.添加审核表之后,实验室的某天某节数变为预约状态
		String sql5 = "update laboratory SET state = \'已预约\' "
				+ " where class_time = " + classTime 
				+ " and date = " + date 
				+ " and lb_id = " + lbId;
		
		// 6.将申请表信息插入checking表单
		String sql6 = "insert into checking values("
						+  id  + "," + name + ","  + lbId + "," 
						+ lb_type + "," + testName + "," + lbAddress + ","
						+ date + "," + classTime + "," + equipment + ","
						+ clazz +  "," + type + ")";
		System.out.println("countFree:"+ countFree);  
		System.out.println("isExist:"+isExist);
		System.out.println(sql);
		System.out.println(sql2);  
		System.out.println(sql3);  
		System.out.println(sql4);  
		System.out.println(sql5);  
		System.out.println(sql6);
		if( isExist || (countFree < 1) ) {
			laboratoryDao.updateState(sql5);
			checkingDao.addChecking(sql6);
			return true;
		}
		return  false;
	}


	public boolean updateState(String lbId, String date, String classTime) {
		lbId = "\'" + lbId +"\'";
		date = "\'" + date +"\'";
		classTime = "\'" + classTime + "\'";
		String sql = "update laboratory SET state = \'未预约\' "
				+ " where class_time = " + classTime 
				+ " and date = " + date 
				+ " and lb_id = " + lbId;
		return laboratoryDao.updateState(sql);
	}


	public List<Laboratory> findAllLaboratory() {
		String sql = "select lb_id,lb_address,volume,name,description,type from laboratory group by lb_id";
		List<Laboratory> laboratories = laboratoryDao.findAllLaboratory(sql);
		return laboratories;
	}


	public boolean banLaboratory(String lbId ,String classTime ,String date) {
		lbId = "\'" + lbId +"\'";
		date = "\'" + date +"\'";
		classTime = "\'" + classTime + "\'";
		String sql = "update  laboratory set state = \'禁用\'   "
				+ " where lb_id = " + lbId 
				+ " and class_time = " +classTime
				+ " and date = " + date;
		//update laboratory set state = '禁用'  where lb_id = '1' and class_time = '1,2节' and date = '2020-3-16'
		System.out.println("禁用laboratory的sql:"+sql);
		return laboratoryDao.banLaboratory(sql);
	}


	public boolean deleteLaboratory(String lbId) {
		String sql = "delete from laboratory where lb_id = " + lbId;
		System.out.println("删除laboratory的sql:"+sql);
		return laboratoryDao.deleteLaboratory(sql);
	}


	public boolean updateLaboratory(String lbId, String lbAddress, String type, String description, String volume,String name) {
		lbId = "\'" + lbId +"\'";
		lbAddress = "\'" + lbAddress +"\'";
		type = "\'" + type + "\'";
		description = "\'" + description +"\'";
		volume = "\'" + volume +"\'";
		String sql = "update laboratory "
				+ "set lb_address = " + lbAddress +","
				+ "type = " + type +","
				+ "description = " + description +","
				+ "name = " + name +","
				+ "volume = " + volume  
				+ "  where lb_id = " + lbId;
		System.out.println("更新laboratory的sql:"+sql);
		return laboratoryDao.updateLaboratory(sql);
	}


	public boolean addLaboratory(String lbId, String lbAddress, String type, String description, String volume,String name) {
		lbId = "\'" + lbId +"\'";
		lbAddress = "\'" + lbAddress +"\'";
		type = "\'" + type + "\'";
		description = "\'" + description +"\'";
		volume = "\'" + volume +"\'";
		name = "\'" + name +"\'";
		String sql = "insert into laboratory(lb_id,lb_address,volume,type,description,name) values("
				+  lbId  + ","
				+ lbAddress + "," 
				+ volume + ","
				+ type + "," 
				+ description + "," 
				+ name +  ")"; 
		System.out.println("添加laboratory的sql:"+sql);
		return laboratoryDao.addLaboratory(sql);
	}

	
	public boolean autoAddLabatory() {	
		List<Laboratory> laboratories = findAllLaboratory();
		for (Laboratory laboratory : laboratories) {
			String lbId =  "\'" + laboratory.getLbId() +"\'";
			String lbAddress =  "\'" + laboratory.getLbAddress() +"\'";
			String volume =  "\'" + laboratory.getVolume() +"\'";
			String state = "\'未预约\'";
			String name =  "\'" + laboratory.getName() +"\'";
			String description =  "\'" + laboratory.getDescription() +"\'";
			String type =  "\'" + laboratory.getType()+"\'";
			String[] classTimes = {"'1,2节'","'3,4节'","'5,6节'","'7,8节'","'9,10节'","'11,12,13节'"};
			for (String classTime : classTimes) {	
				String dateStr =  "\'" + getFetureDate(7) +  "\'" ; //  当前日期加上7天之后的日期str
				String sql = "insert into laboratory(lb_id,lb_address,volume,type,description,name,class_time,date,state) values("
						+  lbId  + ","
						+ lbAddress + "," 
						+ volume + ","
						+ type + "," 
						+ description + "," 
						+ name + ","  
						+ classTime + ","
						+ dateStr + ","
						+ state + ")"; 
				System.out.println("sql:"+sql);
				laboratoryDao.autoAddLabatory(sql);
			}
		}
		return true;
	}
	
	/**
	 * @desc 获取第future天的日期
	 * @param past
	 * @return
	 * @throws ParseException 
	 */
	 public  String getFetureDate(int past) {  
	       Calendar calendar = Calendar.getInstance();  
	       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);  
	       Date today = calendar.getTime();  
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	       String result = format.format(today);  
//	       Date resultDate = format.parse(result);
	       return result;  
	   }  
	
}
