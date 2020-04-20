package com.cyc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyc.entity.Checking;
import com.cyc.service.StudentService;
import com.cyc.service.impl.StudentServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class StudentAppointServlet
 */
@WebServlet("/studentAppointServlet")
public class StudentAppointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentService studentService = new StudentServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		List<Checking> checkings = studentService.findCheckingsById(userId);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		out.print(gson.toJson(checkings));
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
