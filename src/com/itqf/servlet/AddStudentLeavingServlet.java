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

import com.itqf.bean.Studentill;
import com.itqf.service.StudentService;
@WebServlet("/AddStudentLeavingServlet")
public class AddStudentLeavingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//获取提交学生请假表中的所有数据
		Studentill studentill = new Studentill();
		try {
			BeanUtils.populate(studentill, req.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//调用数据库的添加
		StudentService service=new StudentService();
		try {
			service.addStudentill(studentill);
		
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "学生请假表提交失败");
			req.getRequestDispatcher("/msg.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
