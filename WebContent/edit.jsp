<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/UpdateStudentServlet" method="post">
  <input  type="hidden"  name="id"  value="${s.id }"/>
<table border="1px" align="center" width="45%">
	<tr>
	<td>学生姓名</td>
	<td><input type="text" name="username" value="${s.username }"/></td>
	</tr>
    
    <tr>
	<td>学生年龄</td>
	<td><input type="text" name="age" value="${s.age }"/></td>
	</tr>
	
	<tr>
	<td>学生手机</td>
	<td><input type="text" name="mobile" value="${s.mobile }"/></td>
	</tr>
	
	<tr>
	<td>学生地址</td>
	<td><input type="text" name="address" value="${s.address }"/></td>
	</tr>
	
	<tr>
	
	<td colspan="2"><input type="submit" value="保存"/></td>
	</tr>

</table>


</form>
</body>
</html>