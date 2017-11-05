package com.itqf.service;

import java.sql.SQLException;
import java.util.List;



import com.itqf.bean.PageBean;
import com.itqf.bean.PageillBean;
import com.itqf.bean.Student;
import com.itqf.bean.Studentill;
import com.itqf.dao.StudentDao;

public class StudentService {

	public void add(Student stu) throws SQLException {
		StudentDao dao=new StudentDao();
		dao.add(stu);
	}

	public Student findLogin(String username, String password) throws SQLException {
		StudentDao dao=new StudentDao();
	return	dao.findLogin(username,password);
		
	}

	public Student findByName(String username) throws SQLException {
		StudentDao dao=new StudentDao();
	    return	dao.findByName(username);
		
		
	}

	public PageBean<Student>  findPageBeanByPage(int currentPage, int pageSize) throws SQLException {
		StudentDao dao=new StudentDao();
		List<Student> list = dao.findPageBeanByPage(currentPage,pageSize);
		int totalCount = dao.findCount();
		return new PageBean<Student>(list,currentPage,pageSize,totalCount);
		
	}

	public void addStudentill(Studentill studentill) throws SQLException {
		StudentDao dao=new StudentDao();
		dao.addStudentill(studentill);
		
	}

	public PageillBean<Studentill> findPageStuillByPage(int currentPage, int pageSize) throws SQLException {
		StudentDao dao=new StudentDao();
		List<Studentill> list = dao.findPageStuillByPage(currentPage,pageSize);
		int totalCount = dao.findStuillCount();
		return new PageillBean<Studentill>(list,currentPage,pageSize,totalCount);
	}

	public void examine(String sid) throws SQLException {
		StudentDao dao=new StudentDao();
		dao.examine(sid);
		
	}

	public Student findById(String id) throws SQLException {
		StudentDao dao=new StudentDao();
		return dao.findById(id);
	}

	public void update(Student student) throws SQLException {
		StudentDao dao=new StudentDao();
		dao.update(student);
		
	}

	public void delete(String id) throws SQLException {
		StudentDao dao=new StudentDao();
		dao.delete(id);
		
	}

}
