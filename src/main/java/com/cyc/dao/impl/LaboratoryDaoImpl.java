package com.cyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyc.dao.LaboratoryDao;
import com.cyc.entity.Laboratory;
import com.cyc.util.DbUtil;

public class LaboratoryDaoImpl implements LaboratoryDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<Laboratory> findFree(String sql) {
		List<Laboratory> laboratories = new ArrayList<Laboratory>();
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs =  ps.executeQuery();
			while(rs.next()) {
				Laboratory laboratory = new Laboratory();
				laboratory.setLbId(rs.getString(1));
				laboratory.setLbAddress(rs.getString(2));
				laboratory.setVolume(rs.getInt(3));
				laboratory.setState(rs.getString(4));
				laboratory.setClassTime(rs.getString(5));
				laboratory.setDate(rs.getDate(6));
				laboratory.setName(rs.getString(7));
				laboratory.setDescription(rs.getString(8));
				laboratories.add(laboratory);
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
		return laboratories;
	}

	
	public boolean updateState(String sql) {
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


	public String findLbAddressByLbId(String sql) {
		String lbAddress = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs =  ps.executeQuery();
			if(rs.next()) {
				lbAddress = rs.getString(1);
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
		return lbAddress;
	}


	public List<Laboratory> findAllLaboratory(String sql) {
		List<Laboratory> laboratories = new ArrayList<Laboratory>();
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs =  ps.executeQuery();
			while(rs.next()) {
				Laboratory laboratory = new Laboratory();
				laboratory.setLbId(rs.getString(1));
				laboratory.setLbAddress(rs.getString(2));
				laboratory.setVolume(rs.getInt(3));
				laboratory.setName(rs.getString(4));
				laboratory.setDescription(rs.getString(5));
				laboratory.setType(rs.getString(6));
				laboratories.add(laboratory);
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
		return laboratories;
	}


	public boolean banLaboratory(String sql) {
		return updateState(sql);
	}


	public boolean deleteLaboratory(String sql) {
		 
		return updateState(sql);
	}


	public boolean updateLaboratory(String sql) {
		// TODO Auto-generated method stub
		return updateState(sql);
	}


	public boolean addLaboratory(String sql) {
		return updateState(sql);
	}


	public boolean autoAddLabatory(String sql) {
		return addLaboratory(sql);
	}


	public Laboratory findLaboratoryById(String sql) {
		Laboratory laboratory = new Laboratory();
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs =  ps.executeQuery();
			if(rs.next()) {
				laboratory.setLbId(rs.getString(1));
				laboratory.setLbAddress(rs.getString(2));
				laboratory.setVolume(rs.getInt(3));
				laboratory.setState(rs.getString(4));
				laboratory.setClassTime(rs.getString(5));
				laboratory.setDate(rs.getDate(6));
				laboratory.setName(rs.getString(7));
				laboratory.setDescription(rs.getString(8));
				laboratory.setType(rs.getString(9));
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
		return laboratory;
	}
	

}
