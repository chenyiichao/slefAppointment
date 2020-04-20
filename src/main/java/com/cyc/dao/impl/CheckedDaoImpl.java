package com.cyc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cyc.dao.CheckedDao;
import com.cyc.entity.Checked;
import com.cyc.util.DbUtil;

public class CheckedDaoImpl implements CheckedDao{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<Checked> findCheckedById(String sql) {
		List<Checked> checkeds = new ArrayList<Checked>();
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
            	Checked checked = new Checked();
            	checked.setId(rs.getString(1));
            	checked.setName(rs.getString(2));
            	checked.setClazz(rs.getString(3));
            	checked.setLbId(rs.getString(4));
            	checked.setType(rs.getString(5));
            	checked.setTestName(rs.getString(6));
            	checked.setDate(rs.getDate(7));
            	checked.setClassTime(rs.getString(8));
            	checked.setLbAddress(rs.getString(9));
            	checked.setResult(rs.getString(10));
            	checked.setDescription(rs.getString(11));
            	checked.setTestType(rs.getString(12));
            	checkeds.add(checked);
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
		return checkeds;
	}

	public boolean deleteChecked(String sql) {
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

	public List<Checked> findAllCheckeds(String sql) {
		return findCheckedById(sql);
	}

	public boolean addChecked(String sql) {
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
//		return deleteChecked(sql);
	}

	public Checked findOneChecked(String sql) {
		Checked checked = new Checked();
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()) {
            	checked.setId(rs.getString(1));
            	checked.setName(rs.getString(2));
            	checked.setClazz(rs.getString(3));
            	checked.setLbId(rs.getString(4));
            	checked.setType(rs.getString(5));
            	checked.setTestName(rs.getString(6));
            	checked.setDate(rs.getDate(7));
            	checked.setClassTime(rs.getString(8));
            	checked.setLbAddress(rs.getString(9));
            	checked.setResult(rs.getString(10));
            	checked.setDescription(rs.getString(11));
            	checked.setEquipment(rs.getString(12));
            	checked.setTestType(rs.getString(13));
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
		return checked;
	}

	public List<Checked> selectCheckedsByType(String sql) {
		return findCheckedById(sql);
	}
}
