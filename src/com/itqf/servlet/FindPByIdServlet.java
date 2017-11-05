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
@WebServlet("/FindPByIdServlet")
public class FindPByIdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
        StudentService service=new StudentService();
        Student stu=null;
      try {
		stu=  service.findById(id);
		req.setAttribute("s", stu);
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
	} catch (SQLException e) {
		
		e.printStackTrace();
		req.setAttribute("msg", "修改学生信息失败");
		req.getRequestDispatcher("/msg.jsp").forward(req, resp);
	}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
