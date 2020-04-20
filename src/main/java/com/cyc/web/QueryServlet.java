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

/**
 * @author cyc
 * @version 1.0
 * @date 2020.3.9
 * @des  查询控制器 返回前端查询空闲教室结果
 */

@WebServlet("/queryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private LaboratoryService laboratoryService = new LaboratoryServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String date = request.getParameter("date");
		String classTime = request.getParameter("classTime");
		List<Laboratory> laboratories = laboratoryService.findFreeClass(date,classTime); // 通过日期和结束查询空闲教室
		Gson gson = new GsonBuilder()
		        .setDateFormat("yyyy-MM-dd")
		        .create();
		String json = gson.toJson(laboratories);
		out.println(json);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
