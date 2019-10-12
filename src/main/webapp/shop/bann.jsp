<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="../css/admin/common.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/font-awesome.css" />
<link rel="stylesheet" type="text/css"
	href="../css/font-awesome.min.css" />
<link href="../css/fileinput.min.css" rel="stylesheet" />
<%--js部分--%>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-table.js"></script>
<script src="../js/bootstrap-table-zh-CN.js"></script>
<script src="../js/fileinput.min.js"></script>
<script src="../js/echarts.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="banntab"
		class="table table-hover table-striped table-bordered"></table>
<script type="text/javascript">
$('#banntab')
.bootstrapTable(
		{
			method : 'get',
			url : "${pageContext.request.contextPath}/bann/bannList",//请求路径
			striped : true, //是否显示行间隔色
			pageNumber : 1, //初始化加载第一页
			pagination : true,//是否分页
			sidePagination : 'client',//server:服务器端分页|client：前端分页
			pageSize : 4,//单页记录数
			pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
			//clickToSelect : true, // 是否启用点击选中行
			showRefresh : true,//刷新按钮
			sortable : true, //启用排序

			queryParams : function(params) {//上传服务器的参数
				var temp = {
					limit : params.limit, // 每页显示数量
					offset : params.offset, // SQL语句起始索引
					page : (params.offset / params.limit) + 1,
				
				};
				return temp;
			},
			columns : [
					{
						field : 'number',
						title : '序号',
						width : '25%',
						align : 'center',
						switchable : false,
						formatter : function(value, row, index) {
							//return index+1; //序号正序排序从1开始
							var pageSize = $('#banntab')
									.bootstrapTable(
											'getOptions').pageSize;//通过表的#id 可以得到每页多少条
							var pageNumber = $('#banntab')
									.bootstrapTable(
											'getOptions').pageNumber;//通过表的#id 可以得到当前第几页
							return pageSize * (pageNumber - 1)
									+ index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
						}
					},
					{
						field : 'state',
						checkbox : true,
					},
					{
						title : '公告标题',
						field : 'bTitle',
						
						
					}, {
						title : '公告内容',
						field : 'bContent',

					}, {
						title : '时间',
						field : 'bData',

					} ]
		})

</script>


</body>
</html>