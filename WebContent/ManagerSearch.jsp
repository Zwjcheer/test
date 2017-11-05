<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员分页审批请假单</title>
</head>
<body>
	<center>
		<table border="1px" width="85%">
		<tr>
		
			<th>Sid</th>
			<th >姓名</th>
			<th>年龄</th>
			<th>请假时间</th>
			<th>请假原因</th>
			<th>审批状态</th>
		
		</tr>
	
		<c:forEach items="${bean.list }" var="it">
		    
		<tr>
			<th width="8%">${it.id }</th>
			<th width="8%">${it.name }</th>
			<th width="8%">${it.age }</th>
			<th width="8%">${it.date }</th>
			<th width="8%">${it.reason }</th>
		    <th><a href="javascript:void(0)" onclick="deleteS('${it.id}')">待审批</a></th>
			
						<%-- <th width="8%"><a href="${pageContext.request.contextPath }/FindPByIdServlet?pid=${it.pid}">修改</a><a href="javascript:void(0)" onclick="deleteP('${it.pid}')">|删除</a></th> --%>
		</tr>
	</c:forEach>
	
		</form>
		</table>
		<c:if test="${bean.currentPage!=1 }">
		<a href="${pageContext.request.contextPath }/PageillServlet?currentPage=1">[首页]</a>
		<a href="${pageContext.request.contextPath }/PageillServlet?currentPage=${bean.currentPage-1}">[上一页]</a>
		</c:if>
		
		<c:forEach begin="1" end="${bean.totalPage }" var="i">
		<c:if test="${currentPage!=i }">
		   <a href="${pageContext.request.contextPath }/PageillServlet?currentPage=${i }">${i }</a>
		</c:if>
		<c:if test="${currentPage==i }">
		${i }
		</c:if>
		</c:forEach>
		
		
		
		<c:if test="${bean.currentPage!=bean.totalPage }">
		<a href="${pageContext.request.contextPath }/PageillServlet?currentPage=${bean.currentPage+1}">[下一页]</a>
		<a href="${pageContext.request.contextPath }/PageillServlet?currentPage=${bean.totalPage}">[尾页]</a>
		</c:if>
		当前第${bean.currentPage}页/总${bean.totalPage }页数
	<!-- 	[首页][上一页][下一页][尾页] -->
	
	</center>
</body>
	<script type="text/javascript">
	   function deleteS(Sid){
		  
		   if(confirm("是否确认进行审批")){
			  // alter(Sid)
			 
			   window.location.href="/StudentManagementSystem/ExamineServlet?Sid="+Sid;
		   }
	   }
	
	
	</script>
</html>