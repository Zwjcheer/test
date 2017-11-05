package com.itqf.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itqf.bean.PageBean;
import com.itqf.bean.Student;
import com.itqf.service.StudentService;
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String currentpage = req.getParameter("currentPage");
		int currentPage = Integer.parseInt(currentpage);
		int pageSize=5;
		
		//调用实体类
		StudentService service =new StudentService();
		PageBean<Student> bean=null;
	    try {
		bean=	service.findPageBeanByPage(currentPage,pageSize);
		req.getSession().getServletContext().setAttribute("bean", bean);
		req.getRequestDispatcher("/Student_page.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "分页查询学生信息失败");
			req.getRequestDispatcher("/msg.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
