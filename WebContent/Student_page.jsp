<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页展示学生信息</title>
</head>
<body>
	<center>
		<table border="1px" width="85%">
		<tr>
		
			<th >id</th>
			<th >姓名</th>
			<th >性别</th>
			<th>年龄</th>
			<th>手机号</th>
			<th>地址</th>
			<th>职位</th>
			<th>头像</th>
		</tr>
	
		<c:forEach items="${bean.list }" var="it">
		    
		<tr>
		
			<th width="8%">${it.id }</th>
			<th width="8%">${it.username }</th>
			<th width="8%">${(it.sex==1)?"男":"女" }</th>
			<th width="8%">${it.age }</th>
			<th >${it.mobile }</th>
			<th >${it.address }</th>
			<th width="8%">${(it.ismanager==1)?"经理":"普通员工" }</th>
			<th width="8%"><img alt="img" src="${it.path }"></th>
			 <th width="8%"><a href="${pageContext.request.contextPath }/FindPByIdServlet?id=${it.id}">修改</a><a href="javascript:void(0)" onclick="deleteP('${it.id}')">|删除</a></th>
		</tr>
	</c:forEach>
	
		</form>
		</table>
		<c:if test="${bean.currentPage!=1 }">
		<a href="${pageContext.request.contextPath }/PageServlet?currentPage=1">[首页]</a>
		<a href="${pageContext.request.contextPath }/PageServlet?currentPage=${bean.currentPage-1}">[上一页]</a>
		</c:if>
		
		<c:forEach begin="1" end="${bean.totalPage }" var="i">
		<c:if test="${currentPage!=i }">
		   <a href="${pageContext.request.contextPath }/PageServlet?currentPage=${i }">${i }</a>
		</c:if>
		<c:if test="${currentPage==i }">
		${i }
		</c:if>
		</c:forEach>
		
		
		
		<c:if test="${bean.currentPage!=bean.totalPage }">
		<a href="${pageContext.request.contextPath }/PageServlet?currentPage=${bean.currentPage+1}">[下一页]</a>
		<a href="${pageContext.request.contextPath }/PageServlet?currentPage=${bean.totalPage}">[尾页]</a>
		</c:if>
		当前第${bean.currentPage}页/总${bean.totalPage }页数
	<!-- 	[首页][上一页][下一页][尾页] -->
	
	</center>
	<script type="text/javascript">
	
	
   function deleteP(id){
	   //弹出确认框
	  if( confirm("是否确认删除？")){
		   //再去删除 跳转到制定的servlet  并把id带过去
		 //  alert(pid)
		   window.location.href="${pageContext.request.contextPath}/DeletePByIdServlet?id="+id;
		   
	   }
   }
	
	</script>
	
	
</body>
</html>