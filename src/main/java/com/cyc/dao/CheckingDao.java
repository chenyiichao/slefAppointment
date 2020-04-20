package com.cyc.dao;

import java.util.List;

import com.cyc.entity.Checking;

public interface CheckingDao {

	boolean addChecking(String sql);

	boolean findChecking(String sql);

	List<Checking> findCheckingById(String sql);

	boolean deleteChecking(String sql);

	List<Checking> findAllCheckings(String sql);

	Checking findOneChecking(String sql);
	
}
