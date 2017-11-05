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
@WebServlet("/RegisterAjaxServlet")
public class RegisterAjaxServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取提交表单数据
		String username = req.getParameter("username");
		System.out.println(username);
		StudentService service=new StudentService();
		try {
		 Student findByName = service.findByName(username);
			if(findByName!=null){
				resp.getWriter().print("0");
			}else{
				resp.getWriter().print("1");
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
