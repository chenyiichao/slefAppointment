package com.cyc.service;

import java.util.List;

import com.cyc.entity.Laboratory;

public interface LaboratoryService {

	List<Laboratory> findFreeClass(String date, String classTime);

	boolean addChecking(String lbId, String testName, String date, String type, String equipment, String id,String classTime);

	boolean updateState(String lbId, String date, String classTime);

	List<Laboratory> findAllLaboratory();

	boolean banLaboratory(String lbId,String classTime,String date);

	boolean deleteLaboratory(String lbId);

	boolean updateLaboratory(String lbId, String lbAddress, String type, String description, String volume,String name);

	boolean addLaboratory(String lbId, String lbAddress, String type, String description, String volume,String name);
	
	/**
	 * @author cyc 
	 * @desc 每天添加7天后那一天5个时段的空闲实验室
	 * @return
	 */
	boolean autoAddLabatory();



}
