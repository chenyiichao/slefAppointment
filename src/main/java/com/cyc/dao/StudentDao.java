package com.cyc.dao;

import java.util.List;

import com.cyc.entity.Student;

public interface StudentDao {

	List<Student> findAll();

	Student findStudentById(String sql);

}
