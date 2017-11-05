package com.itqf.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.itqf.bean.Student;
import com.itqf.service.StudentService;
@WebServlet("/RegisterStudentServlet")
public class RegisterStudentServlet extends HttpServlet{
	private String username;
	private String password;
	private String sex;
	private String age;
	private String mobile;
	private String address;
	private String ismanager;
	private String path;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//1 判断是否是multipart形式上传
				boolean  isMulti =  ServletFileUpload.isMultipartContent(req);
				//2.创建磁盘解析工厂
				DiskFileItemFactory  factory = new DiskFileItemFactory();
				//3,创建核心解析类
				ServletFileUpload upload = new  ServletFileUpload(factory);
				//避免上传中文名乱码
				upload.setHeaderEncoding("UTF-8");
				//设置上传文件大小
			//	upload.setFileSizeMax(1024*1024*10); //设置单个上传大小  byte	
				try {
					List<FileItem> list= upload.parseRequest(req);
					for (FileItem fileItem : list) {
						//遍历每个item的类型，是普通表单还是文件表单
						if(fileItem.isFormField()){
							 //fileItem.isFormField() 普通表单数据返回的true
							  dealInput(fileItem);
							//  String fieldName = fileItem.getFieldName(); //获取input name属性的值
								// String value     = fileItem.getString("UTF-8");//获取input value值
						}else{
							 dealFile(fileItem);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	/* 1.使用upfileload的方法进行文件保存  fileitem.write()
	 * 2.每天的内容创建一个文件夹
	 * @param fileItem
	 * 
	 */
	private void dealFile(FileItem fileItem) {
		//创建文件即可									  
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				
				String time = format.format(new Date());
				
				//在当前程序下创建文件夹
				String dirpath = getServletContext().getRealPath("/WEB-INF/upfile/"+time);
				//System.out.println(dirpath);
				
				//创建文件夹文件
				File  dir = new File(dirpath);
				
				if (!dir.exists()) {
					//不存在
					dir.mkdirs();
				}else{
					//存在   文件  文件夹
					if(dir.isFile()){
						dir.delete();
						dir.mkdirs();
					}
				}
				//获取文件名
				String name = fileItem.getName();
				name = FilenameUtils.getName(name);
				path=dirpath+"/"+name;
			    System.out.println(path);
				//具体的文件
				File file=  new File(dir,/*UUITutil.getUUID()+*/name);
				
				//参数1;指定的文件, write方法会把 fileitem的文件直接写入到 指定的文件中
				try {
					fileItem.write(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	private void dealInput(FileItem fileItem) throws UnsupportedEncodingException {
		 String fieldName = fileItem.getFieldName();
		 if("username".equals(fieldName)){
			username= fileItem.getString("UTF-8");
			//System.out.println(username);
		 }
		 else if("password".equals(fieldName)){
			 password=fileItem.getString("UTF-8");
		 }
		 else if("sex".equals(fieldName)){
			 sex=fileItem.getString("UTF-8");
			 System.out.println(sex);
		 }
		 else if("age".equals(fieldName)){
			 age=fileItem.getString("UTF-8");
		 }
		 else if("mobile".equals(fieldName)){
			 mobile=fileItem.getString("UTF-8");
		 }else if("ismanager".equals(fieldName)){
			 ismanager=fileItem.getString("UTF-8");
		 }
		 else{
			 address=fileItem.getString("UTF-8");
		 }
	}
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		if(age!=null || !age.equals("")){
			Integer.parseInt(age);
		}
		Student stu=new Student(username, password, sex, Integer.parseInt(age), mobile, address, ismanager, path);
		
		//调用数据库添加
		StudentService service=new StudentService();
		try {
			service.add(stu);
			req.getRequestDispatcher("/login.html").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("msg", "注册失败，请重新注册");
			req.getRequestDispatcher("/msg.jsp").forward(req, resp);
		}
	}
}
