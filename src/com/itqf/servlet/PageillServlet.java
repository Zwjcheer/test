package com.itqf.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itqf.bean.PageillBean;
import com.itqf.bean.Studentill;
import com.itqf.service.StudentService;
@WebServlet("/PageillServlet")
public class PageillServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String currentpage = req.getParameter("currentPage");
		int currentPage = Integer.parseInt(currentpage);
		int pageSize=5;
		//调用实体类
		StudentService service=new StudentService();
		PageillBean<Studentill> bean=null;
		try {
		bean=	service.findPageStuillByPage(currentPage, pageSize);
		req.setAttribute("bean", bean);	
		req.getRequestDispatcher("/ManagerSearch.jsp").forward(req, resp);
	/*	resp.sendRedirect("/StudentManagementSystem/ManagerSearch.jsp");*/
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "管理员审批失败");
			req.getRequestDispatcher("/msg.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	}
}
