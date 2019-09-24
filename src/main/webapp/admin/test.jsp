<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="../css/admin/common.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/sweetalert.css" />

<link rel="stylesheet" type="text/css" href="../css/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="../css/font-awesome.min.css" />




<%--js部分--%>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-table.js"></script>
<script src="../js/bootstrap-table-zh-CN.js"></script>
<script src="../js/sweetalert.js"></script>
<script src="../js/board.js"></script>
<script src="../js/board2.js"></script>
<script src="../js/echarts.min.js"></script>
<script src="../js/bootstrap-table-editable.js"></script>
</head>
<body>
<table
  id="table"
  data-toggle="table"
  data-sortable="true"
  data-height="460"
  data-url="${pageContext.request.contextPath}/bann/showBann">
  <thead>
    <tr>
      <th data-field="bId" data-sortable="true">bId</th>
      <th data-field="bTitle" data-sortable="true">bTitle</th>
      <th data-field="bData" data-sortable="true">bData</th>
      <th data-field="bStatus" data-sortable="true">bStatus</th>
    </tr>
  </thead>
</table>
  
</body>
</html>