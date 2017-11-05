package com.itqf.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itqf.bean.Student;
import com.itqf.service.StudentService;
@WebServlet("/loginAjaxServlet")
public class loginAjaxServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		StudentService service=new StudentService();
		try {
			 Student findLogin = service.findLogin(username,password);
			// System.out.println(findLogin);
			 req.getSession().setAttribute("findLogin", findLogin);
			if(findLogin!=null){
				resp.getWriter().print("1");
			}else{
				resp.getWriter().print("0");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
