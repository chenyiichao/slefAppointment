package com.cyc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.service.LaboratoryService;
import com.cyc.service.impl.LaboratoryServiceImpl;

@WebServlet("/laboratoryServlet")
public class LaboratoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LaboratoryService laboratoryService = new LaboratoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String operation = request.getParameter("operation");
		 String lbId = request.getParameter("lbId");
		 String lbAddress = request.getParameter("lbAddress");
		 String type = request.getParameter("type");
		 String description = request.getParameter("description");
		 String volume = request.getParameter("volume");
		 String classTime = request.getParameter("classTime");
		 String date = request.getParameter("date");
		 String name = request.getParameter("name");
		 if(operation.equals("ban")) {
			 laboratoryService.banLaboratory(lbId,classTime,date);
		 }else if(operation.equals("delete")) {
			 laboratoryService.deleteLaboratory(lbId);
		 }else if(operation.equals("update")) {
			 laboratoryService.updateLaboratory(lbId,lbAddress,type,description,volume,name);
		 }else if(operation.equals("add")) {
			 laboratoryService.addLaboratory(lbId,lbAddress,type,description,volume,name);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
