package com.cyc.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyc.service.AdminService;
import com.cyc.service.impl.AdminServiceImpl;

@WebServlet("/checkingToCheckedServlet")
public class CheckingToCheckedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private AdminService adminService = new AdminServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		String lbId = request.getParameter("lbId");
		String classTime = request.getParameter("classTime");
		String date = request.getParameter("date");
		String result = request.getParameter("result");
		String description = request.getParameter("description");
		adminService.checkingToChecked(lbId,classTime,date,result,description);
//		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
