<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
			/* div{
				/*//margin:0 auto*/
				position: relative;
				height: 680px;
				width: 1400px;
				background-color: gray;
			    text-align: center;
			   /*  line-height: 680px; */
			    font-size: 50px;
			} */
			
				#max{
			
				position: relative;
			}
			#top{
				position: absolute;
				left: 600px;
				font-size: 50px;
				
			}
			#show{
				
				position: absolute;
				left: 1100px;
				top: 50px;
			}
		</style>
	</head>
	<body bgcolor="aquamarine">
		<div id="max">
			<div id="top">学生管理系统</div>
			
			<div  id="show"></div>
			
			
			
			
		</div>
		
<!-- 		<div id="show" ></div>
 -->	
 
 </body>
		<script type="text/javascript">
		/* function getdate(){
			var w_array=new Array("星期天","星期一","星期二","星期三","星期四","星期五","星期六");
			var d=new Date();
			var year=d.getFullYear();
			var month=d.getMonth()+1;
			var day=d.getDate();
			var week=d.getDay();
			var h=d.getHours();
			var mins=d.getMinutes();
			var s=d.getSeconds();
			if(month<10){
				
				month="0" + month
			}
			if(day<10){
				
				day="0" + day
			}
			if(h<10){
				
				h="0" + h
			} 
			if(mins<10){
				mins="0" + mins
		    } 
				
			if(s<10) {
				
				s="0" + s
			}
			var shows="现在时间是： <span>" + year + "-" + month + "-" + day + " " + h + ":" + mins +  ":" + s + " " + w_array[week] + "</span>";
			document.getElementById("time").innerHTML=shows;
			setTimeout("getdate()",1000);
			}
			getdate();
		
		
		 */
		
		 window.onload = function() {
			  var show = document.getElementById("show");
			  setInterval(function() {
			   var time = new Date();
			   // 程序计时的月从0开始取值后+1
			   var m = time.getMonth() + 1;
			   var t = time.getFullYear() + "-" + m + "-"
			     + time.getDate() + " " + time.getHours() + ":"
			     + time.getMinutes() + ":" + time.getSeconds();
			   show.innerHTML = t;
			  }, 1000);
			 };
		
		</script>
</html>