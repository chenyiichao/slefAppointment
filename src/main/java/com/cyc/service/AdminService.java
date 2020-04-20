package com.cyc.service;

import java.util.List;

import com.cyc.entity.Admin;
import com.cyc.entity.Checked;
import com.cyc.entity.Checking;

public interface AdminService {
	List<Admin> findAll();

	List<Checking> findAllCheckings();

	List<Checked> findAllCheckeds();

	boolean checkingToChecked(String lbId, String classTime, String date, String result, String description);

	boolean checkedToChecking(String lbId, String classTime, String date);

	List<Checked> selectCheckedsByType(String type);

	
}
