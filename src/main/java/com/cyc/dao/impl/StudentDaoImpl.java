package com.cyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyc.dao.StudentDao;
import com.cyc.entity.Student;
import com.cyc.util.DbUtil;

public class StudentDaoImpl implements StudentDao{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<Student> findAll() {
		List<Student> studentList = new ArrayList<Student>();
		String sql = "select id,password,name,phone,clazz from student";
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs =  ps.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setPassword(rs.getString(2));
				student.setName(rs.getString(3));
				student.setPhone(rs.getString(4));
				student.setClazz(rs.getString(5));
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return studentList;
	}


	public Student findStudentById(String sql) {
		Student student = new Student();
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs =  ps.executeQuery();
			if(rs.next()) {
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setPassword(rs.getString(3));
				student.setPhone(rs.getString(4));
				student.setClazz(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return student;
	}

}
