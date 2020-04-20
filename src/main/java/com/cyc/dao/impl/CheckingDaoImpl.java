package com.cyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyc.dao.CheckingDao;
import com.cyc.entity.Checking;
import com.cyc.util.DbUtil;

public class CheckingDaoImpl implements CheckingDao{
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean addChecking(String sql) {
		System.out.println("进入添加addChecking");
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
		}
		return true;
	}

	public boolean findChecking(String sql) {
		String id = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
            	id = rs.getString(1);
            }
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
		}
		System.out.println("该实验室是否被预约?"+id!=null);
		return id != null;
	}

	public List<Checking> findCheckingById(String sql) {
		List<Checking> checkings = new ArrayList<Checking>();
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
            	Checking checking = new Checking();
            	checking.setId(rs.getString(1));
            	checking.setName(rs.getString(2));
            	checking.setLbId(rs.getString(3));
            	checking.setType(rs.getString(4));
            	checking.setTestName(rs.getString(5));
            	checking.setLbAddress(rs.getString(6));
            	checking.setDate(rs.getDate(7));
            	checking.setClassTime(rs.getString(8));
            	checking.setEquipment(rs.getString(9));
            	checking.setClazz(rs.getString(10));
            	checking.setTestType(rs.getString(11));
            	checkings.add(checking);
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
		return checkings;
	}

	public boolean deleteChecking(String sql) {
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
		}
		return true;
	}

	public List<Checking> findAllCheckings(String sql) {
		return findCheckingById(sql);
	}

	public Checking findOneChecking(String sql) {
		Checking checking = new Checking();
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
            	checking.setId(rs.getString(1));
            	checking.setName(rs.getString(2));
            	checking.setLbId(rs.getString(3));
            	checking.setType(rs.getString(4));
            	checking.setTestName(rs.getString(5));
            	checking.setLbAddress(rs.getString(6));
            	checking.setDate(rs.getDate(7));
            	checking.setClassTime(rs.getString(8));
            	checking.setEquipment(rs.getString(9));
            	checking.setClazz(rs.getString(10));
            	checking.setTestType(rs.getString(11));
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
		return checking;
	}

}
