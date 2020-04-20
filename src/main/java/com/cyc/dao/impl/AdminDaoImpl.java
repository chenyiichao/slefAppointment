package com.cyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyc.dao.AdminDao;
import com.cyc.entity.Admin;
import com.cyc.util.DbUtil;

public class AdminDaoImpl implements AdminDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<Admin> findAll() {
		List<Admin> adminList = new ArrayList<Admin>();
		String sql = "select Ad_id,password,name,phone from admin";
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs =  ps.executeQuery();
			while(rs.next()) {
				Admin admin = new Admin();
				admin.setAdId(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setName(rs.getString(3));
				admin.setPhone(rs.getString(4));
				adminList.add(admin);
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
		return adminList;
	}
	
}
