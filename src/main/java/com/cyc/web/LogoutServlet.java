package com.cyc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Cache-Control","no-store"); //和上面的参数不一样
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma","no-cache");
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("identity");
		session.invalidate();
//        Cookie[] cookies = request.getCookies();
        // 重定向到首页
        response.sendRedirect(request.getContextPath() + "/index.jsp");
 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
