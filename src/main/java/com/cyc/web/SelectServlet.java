package com.cyc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.entity.Checked;
import com.cyc.service.AdminService;
import com.cyc.service.impl.AdminServiceImpl;
import com.google.gson.Gson;

/**
 * 	
 * @author cyc
 * @desc 筛选实验室类型servlet
 */
@WebServlet("/selectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AdminService adminService = new AdminServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		String type = request.getParameter("type");
		PrintWriter out = response.getWriter();
		System.out.println("type:"+type);
		List<Checked> checkeds = new ArrayList<Checked>();
		if(type.equals("全部")) {
			checkeds = adminService.findAllCheckeds();
		}else {
			checkeds = adminService.selectCheckedsByType(type);
		}
		Gson json = new Gson();
		out.print(json.toJson(checkeds));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
