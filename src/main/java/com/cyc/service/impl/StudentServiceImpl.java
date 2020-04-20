package com.cyc.service.impl;

import java.util.List;

import com.cyc.dao.CheckedDao;
import com.cyc.dao.CheckingDao;
import com.cyc.dao.StudentDao;
import com.cyc.dao.impl.CheckedDaoImpl;
import com.cyc.dao.impl.CheckingDaoImpl;
import com.cyc.dao.impl.StudentDaoImpl;
import com.cyc.entity.Checked;
import com.cyc.entity.Checking;
import com.cyc.entity.Student;
import com.cyc.service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	StudentDao studentDao = new StudentDaoImpl();
	CheckingDao checkingDao = new CheckingDaoImpl();
	CheckedDao checkedDao = new CheckedDaoImpl();
	public List<Student> findAll() {
		return studentDao.findAll();
	}
	
	public List<Checking> findCheckingsById(String userId) {	
		userId = "\'"+userId+"\'";
		String sql = "select id,name,lb_id,type,test_name,lb_address,date,class_time,equipment,clazz"
				+ " from checking where id = " + userId;
		return checkingDao.findCheckingById(sql);
	}

	public List<Checked> findCheckedsById(String userId) {
		userId = "\'"+userId+"\'";
		String sql = "select id,name,clazz,lb_id,type,test_name,date,class_time,lb_address,result,description "
				+ " from checked where id = " + userId;
		return checkedDao.findCheckedById(sql);
	}

	public boolean deleteChecking(String lbId, String date, String classTime) {
		lbId = "\'"+lbId+"\'";
		date = "\'"+date+"\'";
		classTime = "\'"+classTime+"\'";
		String sql = "delete from checking  " + 
				"where lb_id = " + lbId +  
				"and class_time = " +  classTime +
				"and date = "  + date;
		return checkingDao.deleteChecking(sql);
	}

	public boolean deleteChecked(String lbId, String date, String classTime) {
		lbId = "\'"+lbId+"\'";
		date = "\'"+date+"\'";
		classTime = "\'"+classTime+"\'";
		String sql = "delete from checked  " + 
				"where lb_id = " + lbId +  
				"and class_time = " +  classTime +
				"and date = "  + date;
		return checkedDao.deleteChecked(sql);
	}
	
	
}
