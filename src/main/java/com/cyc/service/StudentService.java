package com.cyc.service;

import java.util.List;

import com.cyc.entity.Checked;
import com.cyc.entity.Checking;
import com.cyc.entity.Student;

public interface StudentService {

	List<Student> findAll();

	List<Checking> findCheckingsById(String userId);

	List<Checked> findCheckedsById(String userId);

	boolean deleteChecking(String lbId, String date, String classTime);

	boolean deleteChecked(String lbId, String date, String classTime);
}
