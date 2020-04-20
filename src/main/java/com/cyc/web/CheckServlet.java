package com.cyc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.entity.Checked;
import com.cyc.entity.Checking;
import com.cyc.service.AdminService;
import com.cyc.service.impl.AdminServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/checkServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private AdminService adminService = new AdminServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String option = request.getParameter("option");
		Gson gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		if(option.equals("1")) {
			List<Checking> checkings =  adminService.findAllCheckings();
			out.println(gson.toJson(checkings));
		}
		if(option.equals("2")) {
			List<Checked> checkeds = adminService.findAllCheckeds();
			out.println(gson.toJson(checkeds));
		}
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
