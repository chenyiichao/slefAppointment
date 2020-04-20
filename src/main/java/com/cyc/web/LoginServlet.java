package com.cyc.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyc.entity.Admin;
import com.cyc.entity.Student;
import com.cyc.service.AdminService;
import com.cyc.service.StudentService;
import com.cyc.service.impl.AdminServiceImpl;
import com.cyc.service.impl.StudentServiceImpl;

/**
 * 
 * @author cyc
 * @version 1.0
 * @date 2020.3.9
 * @des 登录控制器 实现学生和管理员登录功能
 */

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String label = request.getParameter("label");
		
		// lable为1表示为学生 
		if(label.equals("1")) {
			boolean flag = false;
			StudentService studentService = new StudentServiceImpl();
			List<Student> studentList = studentService.findAll();
			Student curStudent = null;
			for (Student student : studentList) {
				if(student.getId().equals(userId) && student.getPassword().equals(password)) {
					curStudent = student;
					flag = true;
				}
			}
			System.out.println("userId:"+userId);
			System.out.println("flag:"+flag);
			
			if(!flag) {
				request.setAttribute("message", "账号或者密码有误,请重新登录");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("identity", label);
				session.setAttribute("name", curStudent.getName());
			}
			String page = flag?"index.jsp":"login.jsp";
			request.getRequestDispatcher(page).forward(request, response); 
		}
		
		//label 为2 表示管理员
		if(label.equals("2")) {	
			boolean flag = false;
			AdminService adminService = new AdminServiceImpl();
			List<Admin> adminList = adminService.findAll();
			Admin curAdmin = null;
			for (Admin admin : adminList) {
				if(admin.getAdId().equals(userId) && admin.getPassword().equals(password)) {
					curAdmin = admin;
					flag = true;
				}
			}
			if(!flag) {
				request.setAttribute("message", "账号或者密码有误,请重新登录");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("identity", label);
				session.setAttribute("name", curAdmin.getName());
			}
			String page = flag?"admin.jsp":"login.jsp";
			request.getRequestDispatcher(page).forward(request, response); 
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
