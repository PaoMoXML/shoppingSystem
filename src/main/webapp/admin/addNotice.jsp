<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addNotice.jsp</title>
<link href="../css/admin/common.css" type="text/css" rel="stylesheet">

</head>
<body>
<table border=1 style="border-collapse: collapse">
		<caption>
			<font size=4 face=华文新魏>添加公告</font>
		</caption>
		<tr>
			<td>标题<font color="red">*</font></td>
			<td>
				<input type="text" name="ntitle"/>
			</td>
		</tr>
		<tr>
			<td>内容<font color="red">*</font></td>
			<td>
				<textarea name="ncontent"></textarea>
			</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="提交"/>
			</td>
			<td align="left">
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>

</body>
</html>