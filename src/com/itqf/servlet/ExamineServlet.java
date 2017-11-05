package com.itqf.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itqf.service.StudentService;

@WebServlet("/ExamineServlet")
public class ExamineServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取审批传递过来的数据id
		String sid = req.getParameter("Sid");
		//System.out.println(sid);
		//创建studentservice方法对象
		StudentService service=new StudentService();
		
		try {
			service.examine(sid);
			req.getRequestDispatcher("/PageillServlet?currentPage=1").forward(req, resp);
		} catch (SQLException e) {
			req.setAttribute("msg", "审批不合格");
			req.getRequestDispatcher("/msg.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
