<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deleteNoticeSelect.jsp</title>
<link href="../css/admin/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse;
		}
		.bgcolor{
		  	background-color: #F08080;
		}
	</style>
	<script type="text/javascript">
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
	</script>
	<script type="text/javascript">
  		function checkDel(id){
  			if(window.confirm("真的删除？")){
  				window.location.href = "/ch20/adminNotice/deleteNotice?id="+id;
  			}
  		}
  </script>
</head>
<body>
<table border="1" bordercolor="PaleGreen">
			<tr>
				<th width="200px">ID</th>
				<th width="200px">标题</th>
				<th width="200px">时间</th>
				<th width="100px">详情</th>
				<th width="100px">删除</th>
			</tr>
				<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
					<td>1</td>
					<td>aaaaa</td>
					<td>2019-09-09</td>
					<td><a href="noticeDetail.html" target="_blank">详情</a></td>
					<td>
						<a href="javascript:checkDel('1')">删除</a>
					</td>
				</tr>
				<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
					<td>2</td>
					<td>bbbbb</td>
					<td>2019-09-08</td>
					<td><a href="noticeDetail.html" target="_blank">详情</a></td>
					<td>
						<a href="javascript:checkDel('2')">鍒犻櫎</a>
					</td>
				</tr>
		</table>
</body>
</html>