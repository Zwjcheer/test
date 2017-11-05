package com.itqf.dao;

import java.sql.SQLException;
import java.util.List;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itqf.bean.Student;
import com.itqf.bean.Studentill;
import com.itqf.utils.DataSourceUtils;

public class StudentDao {

	public void add(Student stu) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="insert into classroom (username,password,sex,age,mobile,address,ismanager,path)"
				+ "values(?,?,?,?,?,?,?,?)";
		//执行查询语句
		qr.update(DataSourceUtils.getConnection(), sql, stu.getUsername(),stu.getPassword(),stu.getSex(),stu.getAge(),stu.getMobile(),stu.getAddress(),stu.getIsmanager(),stu.getPath());
		DataSourceUtils.closeConn(DataSourceUtils.getConnection());
	}

	public Student findLogin(String username, String password) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="select * from classroom where username=? and password=?";
		Student student = qr.query(DataSourceUtils.getConnection(), sql, new BeanHandler<Student>(Student.class), username,password);
		DataSourceUtils.closeConn(DataSourceUtils.getConnection());
		return student;
	}

	public Student findByName(String username) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="select * from classroom where username=?";
	Student student =  qr.query(DataSourceUtils.getConnection(), sql, new BeanHandler<Student>(Student.class), username);
		DataSourceUtils.closeConn(DataSourceUtils.getConnection());
		return student;
	}

	public List<Student> findPageBeanByPage(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="select * from classroom limit ?,?";
		List<Student> list = qr.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<Student>(Student.class), (currentPage-1)*pageSize,pageSize);
		DataSourceUtils.closeConn(DataSourceUtils.getConnection());
		return list;
	}

	public int findCount() throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="select count(*) from classroom";
		int count = ((Long) qr.query(DataSourceUtils.getConnection(), sql, new ScalarHandler())).intValue();
		return count;
	}

	public void addStudentill(Studentill studentill) throws SQLException {
	QueryRunner qr=new QueryRunner();
	String sql="insert into stuill (name,age,date,reason,id) values(?,?,?,?,?)";
	
	 qr.update(DataSourceUtils.getConnection(), sql, studentill.getName(),studentill.getAge(),studentill.getDate(),studentill.getReason(),studentill.getId());
	
	// 返回到池子中,并且线程本地变量的Connection移除
	 DataSourceUtils.closeConn(DataSourceUtils.getConnection());	
	}

	public List<Studentill> findPageStuillByPage(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="select * from stuill limit ?,?";
		List<Studentill> list = qr.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<Studentill>(Studentill.class), (currentPage-1)*pageSize,pageSize);
		DataSourceUtils.closeConn(DataSourceUtils.getConnection());
		return list;
	}

	public int findStuillCount() throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="select count(*) from stuill";
		int count = ((Long) qr.query(DataSourceUtils.getConnection(), sql, new ScalarHandler())).intValue();
		return count;
	}

	public void examine(String sid) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="delete from stuill where id=?";
		qr.update(DataSourceUtils.getConnection(), sql, sid);
		DataSourceUtils.closeConn(DataSourceUtils.getConnection());
		
	}

	public Student findById(String id) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="select * from classroom where id=?";
		Student student = qr.query(DataSourceUtils.getConnection(), sql, new BeanHandler<Student>(Student.class), id);
		DataSourceUtils.closeConn(DataSourceUtils.getConnection());
		return student;
	}

	public void update(Student student) throws SQLException {
	QueryRunner qr=new QueryRunner();
	String sql = "update classroom set username=?,age=?,mobile=?,address=?" + "where id=?";
		qr.update(DataSourceUtils.getConnection(), sql, student.getUsername(),student.getAge(),student.getMobile(),student.getAddress(),student.getId());
	DataSourceUtils.closeConn(DataSourceUtils.getConnection());
	}

	public void delete(String id) throws SQLException {
		QueryRunner qr=new QueryRunner();
		String sql="delete from classroom where id=?";
		qr.update(DataSourceUtils.getConnection(), sql, id);
		DataSourceUtils.closeConn(DataSourceUtils.getConnection());
		
	}

}
