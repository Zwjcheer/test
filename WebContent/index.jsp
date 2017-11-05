<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style type="text/css">
li{
	list-style-type: none;
}




</style>
</head>
<body bgcolor="aliceblue">

	<ul>
	 <c:if test="${findLogin.ismanager==0}"> 
			<li style="line-height: 60px;"><a href="${pageContext.request.contextPath }/PageServlet?currentPage=1" target="mainFrame">学生信息展示</a></li>
			<li style="line-height: 60px;"><a href="${pageContext.request.contextPath }/Studentill.jsp" target="mainFrame">学生请假申请表</a></li>
			</c:if> 
			<li style="line-height: 60px;"><a href="${pageContext.request.contextPath }/PageillServlet?currentPage=1" target="mainFrame">管理员审批</a></li>
			
			<li style="line-height: 60px;"><a href="${pageContext.request.contextPath }/ExitServlet" target="_parent">退出系统</a></li>
			
		</ul>
			

 
	
</body>
</html>