package com.cyc.dao;

import java.util.List;

import com.cyc.entity.Laboratory;

public interface LaboratoryDao {

	List<Laboratory> findFree(String sql);

	boolean updateState(String sql);

	String findLbAddressByLbId(String sql);

	List<Laboratory> findAllLaboratory(String sql);

	boolean banLaboratory(String sql);

	boolean deleteLaboratory(String sql);

	boolean updateLaboratory(String sql);

	boolean addLaboratory(String sql);

	boolean autoAddLabatory(String sql);

	Laboratory findLaboratoryById(String string);


}
