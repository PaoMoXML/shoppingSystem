<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link href="../css/admin/common.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/sweetalert.css" />



<%--js部分--%>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-table.js"></script>
<script src="../js/bootstrap-table-zh-CN.js"></script>
<script src="../js/sweetalert.js"></script>
<script src="../js/bootstrap-show-password.js"></script>
<script src="../js/board.js"></script>
<script src="../js/board2.js"></script>


<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">

</head>
<body>
<div class="container" id="box">


	<div class="panel panel-default">
		<div class="panel-heading">查询条件</div>
		<div class="panel-body form-group" style="margin-bottom: 0px;">
			<label class="col-sm-1 control-label"
				style="text-align: right; margin-top: 5px">用户ID：</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" name="uId" id="search_uid" />
			</div>
			<label class="col-sm-1 control-label"
				style="text-align: right; margin-top: 5px">Email：</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" name="uEmail"
					id="search_uemail" />
			</div>
			<label class="col-sm-1 control-label"
				style="text-align: right; margin-top: 5px">用户是否被删除</label>
			<div class="col-sm-2">
				<select name="uStatus" id="search_ustatus" class="form-control">
					<option value="1">正常状态</option>
					<option value="2">删除状态</option>
				</select>
			</div>


			<div class="col-sm-1 col-sm-offset-4">
				<button class="btn btn-primary" id="search_btn">查询</button>
			</div>
		</div>
	</div>
	<table id="usertab"
		class="table table-striped table-bordered table-hover"></table>



	<!-- 模态框 -->
	<div id="modalChange" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Modal table</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					账号： <input type="text" id="uid" readonly class="form-control">
					密码：<input type="password" id="pwd" readonly class="form-control">
					邮箱：<input type="text" id="email" class="form-control">

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>



	<script type="text/javascript">
		$('#usertab').bootstrapTable({
			method : 'get',
			url : '${pageContext.request.contextPath}/user/userList',//请求路径
			striped : true, //是否显示行间隔色
			pageNumber : 1, //初始化加载第一页
			pagination : true,//是否分页
			sidePagination : 'client',//server:服务器端分页|client：前端分页
			pageSize : 4,//单页记录数
			pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
			showRefresh : true,//刷新按钮
			queryParams : function(params) {//上传服务器的参数
				var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
					limit : params.limit, // 每页显示数量
					offset : params.offset, // SQL语句起始索引
					//page : (params.offset / params.limit) + 1, //当前页码 

					uId : $('#search_uid').val(),
					uEmail : $('#search_uemail').val(),
					uStatus : $('#search_ustatus').val()
				};
				return temp;
			},
			columns : [ {
				checkbox : true,
			}, {
				title : 'uID',
				field : 'uId',
				sortable : true,
				width : 50,
			}, {
				title : 'Email',
				field : 'uEmail',
				sortable : true,
			}, {
				title : 'pwd',
				field : 'uPwd',
			},{
				title : '状态',
				field : 'uStatus',
				formatter : formatStatus,
				width : 60,
			}, {
				title : '操作',
				field : 'uId',
				width : 158,
				formatter : operation,//对资源进行操作
			} ]
		})
		
		
		//状态处理
			function formatStatus(value, row, index) {
				if (value == 1) {
					return "正常"
				}
				;
				if (value == 2) {
					return "已删除"
				}
				;
				if (value == 3) {
					return "未知"
				}
				;
			}		

		//删除、编辑操作
		function operation(value, row, index) {
			var htm = "<button class='btn btn-sm btn-danger' onclick = 'del(&apos;"
					+ row.uId
					+ "&apos;)'>删除</button><button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modalChange' onclick='showChange(&apos;"
					+ row.uId
					+ "&apos;,&apos;"
					+ row.uEmail
					+ "&apos;,&apos;"
					+ row.uPwd + "&apos;)'>修改</button>"
			return htm;
		}

		//查询按钮事件
		$('#search_btn').click(function() {
			$('#usertab').bootstrapTable('refresh', {
				url : '${pageContext.request.contextPath}/user/userList'
			});
		})

		function showChange(uId, uEmail, uPwd) {
			console.log(uId, uEmail, uPwd)
			document.getElementById('uid').value = uId;
			document.getElementById('pwd').value = uPwd;
			document.getElementById('email').value = uEmail;
		}

		function del(uId) {
			console.log(uId);
			if (uId != null) {
				swal(
						{
							title : "确定操作吗？",
							text : "是否删除id为\"" + uId + "\"的用户吗？",
							type : "warning",
							showCancelButton : true,
							confirmButtonText : '确定'
						}, //用来弹出 提示框
						function() {
							$.ajax({
										url : "${pageContext.request.contextPath}/user/del?uId="
												+ uId, // 数据发送方式
										type : "post", // 接受数据格式           
										dataType : "json", // 要传递的数据
										success : function(data) {
											if (data.key == 1) {
												swal('提示', "删除成功", 'success');
												console.log(123)
											} else {
												swal('提示', "删除失败", 'error');
											}
											/* setTimeOut(function(){},2000) */
											$('#usertab').bootstrapTable(
													'refresh');
										}

									});
						});
			} else {
				swal('提示', '请选择一行数据！');
			}

		}
	</script>
	
	
<!--  	<input
  id="passwordtest"
  class="form-control"
  type="password"
  maxlength="10"
  placeholder="Enter the password">

<script>
  $(function() {
    $('#passwordtest').password()
  })
</script>  -->
	

</div>
</body>
</html>