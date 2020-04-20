package com.cyc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyc.service.LaboratoryService;
import com.cyc.service.impl.LaboratoryServiceImpl;


@WebServlet("/applyServlet")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	private LaboratoryService laboratoryService = new LaboratoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") == null) {
			response.sendRedirect("/login.jsp");
		}
		String lbId = request.getParameter("lbId");
		String testName = request.getParameter("testName");
		//System.out.println("testName1:"+testName);
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		String equipment = request.getParameter("equipment");
		String id = (String)session.getAttribute("userId");
		String classTime = request.getParameter("classTime");
		System.out.println("session中的userId:"+id);
		laboratoryService.addChecking(lbId,testName,date,type,equipment,id,classTime);
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
