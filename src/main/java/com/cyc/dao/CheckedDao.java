package com.cyc.dao;

import java.util.List;

import com.cyc.entity.Checked;

public interface CheckedDao {
	
	List<Checked> findCheckedById(String sql);

	boolean deleteChecked(String sql);

	List<Checked> findAllCheckeds(String sql);

	boolean addChecked(String sql);

	Checked findOneChecked(String sql);

	List<Checked> selectCheckedsByType(String sql);
}
