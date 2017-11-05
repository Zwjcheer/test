package com.itqf.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itqf.bean.Student;
import com.itqf.service.StudentService;
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	Student student=new Student();
	try {
		BeanUtils.populate(student,req.getParameterMap());
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	   StudentService  service=new StudentService();
	   try {
		service.update(student);
		req.getRequestDispatcher("/PageServlet?currentPage=1").forward(req, resp);
	} catch (SQLException e) {
	
		e.printStackTrace();
		req.setAttribute("msg", "修改数据失败！！");
		req.getRequestDispatcher("/msg.jsp").forward(req, resp);
	}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
