package com.cyc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.service.LaboratoryService;
import com.cyc.service.StudentService;
import com.cyc.service.impl.LaboratoryServiceImpl;
import com.cyc.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class CancelServlet
 */
@WebServlet("/cancelServlet")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private StudentService studentService = new StudentServiceImpl();
	private LaboratoryService laboratoryService = new LaboratoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		String lbId = request.getParameter("lbId");
		String date = request.getParameter("date");
		String classTime = request.getParameter("classTime");
		String option = request.getParameter("option");
		if(option.equals("1")) {
			studentService.deleteChecking(lbId,date,classTime);
		}else {
			studentService.deleteChecked(lbId,date,classTime);
		}
		laboratoryService.updateState(lbId,date,classTime);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
