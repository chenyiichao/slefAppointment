package com.cyc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.entity.Laboratory;
import com.cyc.service.LaboratoryService;
import com.cyc.service.impl.LaboratoryServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/queryLaboratoryServlet")
public class QueryLaboratoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LaboratoryService laboratoryService = new LaboratoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Laboratory> laboratories = laboratoryService.findAllLaboratory(); // 查询所有教室
		Gson gson = new GsonBuilder()
		        .setDateFormat("yyyy-MM-dd")
		        .create();
		String json = gson.toJson(laboratories);
		out.println(json);
		out.flush();
		out.close();
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
