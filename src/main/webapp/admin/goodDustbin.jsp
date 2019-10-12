<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>垃圾箱管理</title>
<link href="../css/admin/common.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />

<%--js部分--%>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-table.js"></script>
<script src="../js/bootstrap-table-zh-CN.js"></script>

</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<label>垃圾车</label>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;

			<button class="btn btn-primary " id="back">返回</button>
		</div>
		<div class="panel-body form-group" style="margin-bottom: 0px;">
			<label class="col-sm-1 control-label"
				style="text-align: right; margin-top: 5px">商品ID：</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" name="gId" id="search_gid" />
			</div>
			<label class="col-sm-1 control-label"
				style="text-align: right; margin-top: 5px">商品名称：</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" name="gName"
					id="search_gName" />
			</div>
			<label class="col-sm-1 control-label"
				style="text-align: right; margin-top: 5px">类别：</label>
			<div class="col-sm-2">
				<select name="gType" size="1" id="search_gType" class="form-control">
					<option value="" selected>所有类</option>
				</select>

			</div>
			<div class="col-sm-2">
				<button class="btn btn-primary" id="search_btn">查询</button>
				&emsp;&emsp;
			</div>
		</div>
	</div>
	<table id="goodDustbinstab"
		class="table table-hover table-striped table-bordered"></table>
	<button class="btn btn-danger" id="several_delete">批量彻底删除</button>
	<button class="btn btn-info" id="several_add">批量恢复</button>





	<!--  初始化 表格 -->
	<script type="text/javascript">
		//查询数据库生成下拉列表
		$(document)
				.ready(
						function() {
							$
									.ajax({
										contentType : "application/json;charset=utf-8",
										type : "POST",
										url : "${pageContext.request.contextPath}/type/typeList",
										dataType : "json",
										success : function(data) {
											$
													.each(
															data,
															function(i, type) {
																$('select')
																		.append(
																				$(
																						'<option>')
																						.text(
																								type.tName)
																						.attr(
																								'value',
																								type.tId));
															});
										}
									});
						});

		/* 显示表格 */
		$('#goodDustbinstab').bootstrapTable({
			method : 'get',
			url : "${pageContext.request.contextPath}/good/goodDustbinList",//请求路径
			striped : true, //是否显示行间隔色
			pageNumber : 1, //初始化加载第一页
			pagination : true,//是否分页
			sidePagination : 'server',//server:服务器端分页|client：前端分页
			pageSize : 4,//单页记录数
			pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
			showRefresh : true,//刷新按钮
			sortable : true, //启用排序
			sortOrder : "asc",

			queryParams : function(params) {//上传服务器的参数
				var temp = {
					limit : params.limit, // 每页显示数量
					offset : params.offset, // SQL语句起始索引
					page : (params.offset / params.limit) + 1,
					gId : $('#search_gid').val(),
					gName : $('#search_gName').val(),
					gType : $('#search_gType').val(),
				};
				return temp;
			},
			columns : [ {
				field : 'state',
				checkbox : true,
			}, {
				title : '图片',
				field : 'gMag',
			}, {
				title : '商品ID',
				field : 'gId',
				sortable : true
			}, {
				title : '商品名称',
				field : 'gName',

			}, {
				title : '原价',
				field : 'gPrecost',
			}, {
				title : '现价',
				field : 'gCost',

			}, {
				title : '库存',
				field : 'gQuantity',

			}, {
				title : '类型',
				field : 'gType',
			}, {
				title : '操作',
				field : 'gId',
				formatter : operation,//对资源进行操作
			} ]
		})

		//删除、编辑操作
		function operation(value, row, index) {
			var htm = "<button class='btn btn-sm btn-danger'onclick='deleteDustbinGood(&apos;"
					+ row.gId
					+ "&apos;)'>彻底删除</button><button class='btn btn-sm btn-info'onclick='renewGood(&apos;"
					+ row.gId + "&apos;)'>恢复</button>"
			return htm;
		}

		//查询按钮事件
		$('#search_btn').click(function() {
			$('#goodDustbinstab').bootstrapTable('refresh', {
				url : '${pageContext.request.contextPath}/good/goodDustbinList'
			});

		})

		//跳转原商品事件
		$('#back')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath}/good/goodPage"

						})

		//批量彻底删除
		$("#several_delete").on("click", function() {
			if (!confirm("是否确认删除，无法恢复？"))
				return;
			var rows = $("#goodDustbinstab").bootstrapTable('getSelections');// 获得要删除的数据
			if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
				alert("请先选择要永久删除的商品!");
				return;
			} else {
				var ids = new Array();// 声明一个数组
				$(rows).each(function() {// 通过获得别选中的来进行遍历
					ids.push(this.gId);// cid为获得到的整条数据中的一列
				});
				deleteMs(ids);
				console.log(ids);
			}
		})
		function deleteMs(ids) {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/good/deleteSeveralDustbinGood",
						data : "gId=" + ids,
						type : "post",
						dataType : "json",
						success : function(data) {
							$('#goodDustbinstab')
									.bootstrapTable(
											'refresh',
											{
												url : '${pageContext.request.contextPath}/good/goodDustbinList'
											});
						}
					});
		}

		//批量恢复
		$("#several_add").on("click", function() {
			if (!confirm("是否确认恢复？"))
				return;
			var rows = $("#goodDustbinstab").bootstrapTable('getSelections');// 获得要删除的数据
			if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
				alert("请先选择要恢复的商品！!");
				return;
			} else {
				var ids = new Array();// 声明一个数组
				$(rows).each(function() {// 通过获得别选中的来进行遍历
					ids.push(this.gId);// cid为获得到的整条数据中的一列
				});
				deleteMs(ids);
				console.log(ids);
			}
		})
		function deleteMs(ids) {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/good/renewSeveralDustbinGood",
						data : "gId=" + ids,
						type : "post",
						dataType : "json",
						success : function(data) {
							$('#goodDustbinstab')
									.bootstrapTable(
											'refresh',
											{
												url : '${pageContext.request.contextPath}/good/goodDustbinList'
											});
						}
					});
		}

		/* 彻底删除方法 */
		function deleteDustbinGood(gId) {
			if (!confirm("是否确认删除，无法恢复？"))
				return;
			$
					.ajax({
						async : true, //表示请求是否异步处理
						type : "post", //请求类型
						url : "${pageContext.request.contextPath}/good/deleteDustbinGood",//请求的 URL地址
						data : {
							gId : gId,
						},
						success : function(data) {
							$('#goodDustbinstab').bootstrapTable('refresh');
						},
						error : function(data) {
							alert("删除失败！");
						}
					});

		}

		/* 恢复商品方法 */
		function renewGood(gId) {
			if (!confirm("是否确认恢复？"))
				return;
			$
					.ajax({
						async : true, //表示请求是否异步处理
						type : "post", //请求类型
						url : "${pageContext.request.contextPath}/good/renewDustbinGood",//请求的 URL地址
						data : {
							gId : gId,
						},
						success : function(data) {
							$('#goodDustbinstab').bootstrapTable('refresh');
						},
						error : function(data) {
							alert("删除失败！");
						}
					});

		}
	</script>
</body>

</html>