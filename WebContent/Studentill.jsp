<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息请假表</title>
</head>
<body>
	<form action="/StudentManagementSystem/AddStudentLeavingServlet" method="get">
  <table>
  <tr>
  <td>编号：</td><td><input type="text" name="id"></td>
  
  </tr>
  <tr>
	<td>学生姓名：</td><td><input type="text"  name="name"></td>
	</tr>
	<tr>
	<td>学生年龄：</td><td><input type="text" name="age"></td>
	</tr>
	<tr>
	<td>请假时间:</td><td><input type="text" name="date"></td>
	</tr>
	<tr>
	<td>请假理由：</td><td><textarea rows="5" cols="45" name="reason" id="reason" ></textarea></td>
	
	</tr>
	
	<tr>
	<select name="xxx">
	${bean}
						<c:forEach items="${bean.list}" var="i">
						
						<option value="${i.id}">${i.username}</option>
						</c:forEach>
					</select>
	</tr>
	
	
	<tr>
	<td><input type="submit" value="提交"></td>
	</tr>
	</table>
	</form>
</body>
</html>