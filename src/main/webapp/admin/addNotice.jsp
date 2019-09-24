<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addNotice.jsp</title>
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
<!-- 导出excel -->
<script src="../js/tableExport.js"></script>
<script src="../js/xlsx.core.min.js"></script>
<script src="../js/bootstrap-table-export.js"></script>

</head>
<body>

	<div class="container" id="box">

		<div class="panel panel-default">
			<div class="panel-heading">查询条件</div>
			<div class="panel-body form-group" style="margin-bottom: 0px;">
				<label class="col-sm-1 control-label"
					style="text-align: right; margin-top: 5px">公告ID：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="bId" id="search_bId" />
				</div>
				<label class="col-sm-1 control-label"
					style="text-align: right; margin-top: 5px">标题：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="BTitle"
						id="search_bTitle" />
				</div>
				<label class="col-sm-1 control-label"
					style="text-align: right; margin-top: 5px">时间：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="bData"
						id="search_bData" />
				</div>
				<label class="col-sm-1 control-label"
					style="text-align: right; margin-top: 5px">用户是否被删除</label>
				<div class="col-sm-2">
					<select name="bStatus" id="search_bstatus" class="form-control">
						<option value="1">未发布状态</option>
						<option value="3">发布状态</option>
						<option value="2">删除状态</option>
					</select>
				</div>


				<div class="col-sm-1 col-sm-offset-4">
					<button class="btn btn-primary" id="search_btn"style="float:right"><i class="fa fa-search" aria-hidden="true"></i> 查询</button>
				</div>
			</div>
		</div>
		
		<div class="btn-group" role="group" aria-label="...">
		<button  type="button" class="btn btn-default" id="checkAll"><i class="fa fa-check" aria-hidden="true"></i>全选</button>

		<button type="button" class="btn btn-default" id="uncheckAll"><i class="fa fa-check-circle-o" aria-hidden="true"></i> 取消选择</button>

		<button type="button" class="btn btn-default" id="checkInvert" ><i class="fa fa-check-circle" aria-hidden="true"></i> 反选</button>
		</div>

		<div class="btn-group" role="group" aria-label="..." style="float:right">
		<button type="button" class="btn btn-default" id="restore"><i class="fa fa-repeat" aria-hidden="true"></i> 批量恢复</button>
		
		<button type="button" class="btn btn-default" id="remove"><i class="fa fa-trash" aria-hidden="true"></i> 批量删除</button>
		</div>

		

		<table id="banntab"
			class="table table-striped table-bordered table-hover">

		</table>
		
			<!-- 修改公告模态框 -->
	<div id="modalChange" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document"style="width: 60%">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">修改</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				<input type = "hidden" value="" id = "bid">
					<div class="form-group">
							<label for="title"> 标 题： </label> <input v-model="title" 
								type="text" id="btitle" placeholder="请输入标题" class="form-control"
								style="width: 15%">
						</div>
						<div class="form-group">
							<label for="content"> 内 容： </label>
							<textarea v-model="content" type="text" id="bcontent"
								placeholder="请输入内容" class="form-control" style="height: 120px"></textarea>
						</div>
						<div class="head-txt">
							<span class="title-txt"></span>
						</div>
<!-- 						<div class="form-group">
							<label for="status"> 状态： </label> 
							<select name="bStatus" id="bstatus" class="form-control"style="width: 15%">
								<option value="1">未发布状态</option>
								<option value="3">发布状态</option>
								<option value="2">删除状态</option>
							</select>
						</div> -->


				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="change()">修改</button>
				</div>
			</div>
		</div>
	</div>


		<script type="text/javascript">
		//修改function
		function change(){
			var bId = document.getElementById('bid').value;
			var bTitle = document.getElementById('btitle').value;
			var bContent = document.getElementById('bcontent').value;
/* 			var bStatus = document.getElementById('bstatus').value; */
			/* console.log(bTitle,bContent,bStatus) */
			var url = "${pageContext.request.contextPath}/bann/changeBann"
			var changes = {
				"bId" : bId,
				"bContent" : bContent,
				"bTitle" : bTitle,
				/* "bStatus" : bStatus, */
			};
			var jsonData = JSON.stringify(changes);
			$.ajax({
				url : url, // 数据发送方式
				type : "post", // 接受数据格式           
				data : jsonData,
				dataType : "json", // 要传递的数据
				contentType : "application/json;charset=UTF-8",
				success : function(data) {
					if (data.key == "success") {
						swal('提示', "添加成功", 'success');
						//清空input内容
						$("#content").val("");
						$("#title").val("");
					} else {
						swal('提示', "添加失败", 'error');
					}
					/* setTimeOut(function(){},2000) */
					$('#banntab').bootstrapTable('refresh');
				}
			})
			
			
			
		}

		//查询function
			function a() {

				$('#banntab').bootstrapTable('destroy').bootstrapTable({
					method : 'get',
					url : '${pageContext.request.contextPath}/bann/showBann',//请求路径
					sortable: true,      //是否启用排序
		            sortOrder: "ID desc",     //排序方式
					striped : true, //是否显示行间隔色
					pageNumber : 1, //初始化加载第一页
					showExport: true, //是否显示导出
			        exportDataType: "basic",//'basic':当前页的数据, 'all':全部的数据, 'selected':选中的数据
			        exportTypes:['xlsx'],  //导出文件类型，[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf']
					cache : true,//是否缓存数据
		            sortable: true,//是否启用排序
		            sortOrder: "desc",//排序方式
					toolbar : '#toolbar', //工具按钮用哪个容器
					buttonsAlign : "right", //按钮位置
					pagination : true,//是否分页
					sidePagination : 'server',//server:服务器端分页|client：前端分页
					pageSize : 5,//单页记录数
					pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
					showRefresh : true,//刷新按钮
					clickToSelect : true,//点击选中
					mobileResponsive : true,
					queryParams : function(params) {//上传服务器的参数
						var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
							limit : params.limit, // 每页显示数量
							offset : params.offset, // SQL语句起始索引
							page : (params.offset / params.limit) + 1,

							bId : $('#search_bId').val(),
							bTitle : $('#search_bTitle').val(),
							bData : $('#search_bData').val(),
							bStatus : $('#search_bstatus').val(),
						};
						return temp;
					},
					columns : [ {
						checkbox : true,
					}, {
						title : 'bID',
						field : 'bId',
						width : 50,
						sortable:true
					}, {
						title : '标题',
						field : 'bTitle',
						width : 100,
					}, {
						title : '日期',
						field : 'bData',
						width : 150,
					}, {
						title : '内容',
						field : 'bContent',
					}, {
						title : '状态',
						field : 'bStatus',
						formatter : formatStatus,
						width : 60,
					}, {
						title : '操作',
						width : 158,
						formatter : operation,//对资源进行操作
					} ]
				})
			}

			window.a()

			//处理状态 1：未发布 2：已删除 3：已发布
			function formatStatus(value, row, index) {
				
				
				
				if (value == 1) {
					return "未发布"
				}
				;
				if (value == 2) {
					return "已删除"
				}
				;
				if (value == 3) {
					return "已发布"
				}
				;
			}

			//删除、编辑操作
			function operation(value, row, index) {
				var htm = "<button class='btn btn-sm btn-danger' onclick = 'del(&apos;"
						+ row.bId
						+ "&apos;)'>删除</button><button class='btn btn-sm btn-warning' data-toggle='modal' data-target='#modalChange' onclick='showChange(&apos;"
						+ row.bId
						+ "&apos;,&apos;"
						+ row.bTitle
						+ "&apos;,&apos;"
						+ row.bStatus
						+ "&apos;,&apos;"
						+ row.bContent
						+ "&apos;)'>修改</button><button class='btn btn-sm btn-success' onclick = 'release(&apos;"
						+ row.bId
						+ "&apos;)'>发布</button>"
				return htm;
			}
			
			//发布function
			function release(bId){
				var url = '${pageContext.request.contextPath}/bann/del';
				var bId = bId;
				var bStatus = 3;
				var changes = {
					"bId" : bId,
					"bStatus" : bStatus,
				};
				var jsonData = JSON.stringify(changes);
				$.ajax({
					url : url, // 数据发送方式
					type : "post", // 接受数据格式           
					data : jsonData,
					dataType : "json", // 要传递的数据
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						if (data.key == "success") {
							swal('提示', "发布成功！", 'success');
							//清空input内容
						} else {
							swal('提示', "发布失败！", 'error');
						}
						$('#banntab').bootstrapTable('refresh');
					}

				});
			}
			
			//单独删除function
			function del(bId){
				var url = '${pageContext.request.contextPath}/bann/del';
				var bId = bId;
				var bStatus = 2;
				var changes = {
					"bId" : bId,
					"bStatus" : bStatus,
				};
				var jsonData = JSON.stringify(changes);
				$.ajax({
					url : url, // 数据发送方式
					type : "post", // 接受数据格式           
					data : jsonData,
					dataType : "json", // 要传递的数据
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						if (data.key == "success") {
							swal('提示', "删除成功！", 'success');
							//清空input内容
						} else {
							swal('提示', "删除失败！", 'error');
						}
						$('#banntab').bootstrapTable('refresh');
					}

				});
			}
			
			

			//查询按钮事件 function
			$('#search_btn').click(function() {
				var status = document.getElementById('search_bstatus').value;
				console.log(status);
				if (status == 1 || status == 3) {
					console.log("未发布状态或者发布状态")
					window.a()
				} else if (status == 2) {
					console.log("删除状态")
				}
				$('#banntab').bootstrapTable('refresh', {
					url : '${pageContext.request.contextPath}/bann/showBann',
				});
			})
		</script>



		<script type="text/javascript">

			//批量删除
			$("#remove").on("click", function() {
				if (!confirm("是否确认删除？"))
					return;
				var rows = $("#banntab").bootstrapTable('getSelections');// 获得要删除的数据
				if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
					swal('提示', "请选择需要删除的id", 'error');
					return;
				}else{
					
				if(rows[0].bStatus == 2){
					swal('提示', "已删除，请不要重复删除", 'error');
				} else {
					var ids = new Array();// 声明一个数组
					$(rows).each(function() {// 通过获得别选中的来进行遍历
						ids.push(this.bId);// cid为获得到的整条数据中的一列
					});
					deleteMs(ids)
				}
				}
			})
			function deleteMs(ids) {
				console.log(ids);
				$.ajax({
							url : "${pageContext.request.contextPath}/bann/delList",
							data : "bId=" + ids,
							type : "post",
							dataType : "json",
							success : function(data) {
								swal('提示', "删除成功", 'success');
								$('#banntab')
										.bootstrapTable(
												'refresh',
												{
													url : '${pageContext.request.contextPath}/bann/showBann'
												});
							}
						});
			}
			
			
			//批量恢复
			$("#restore").on("click", function() {
				if (!confirm("是否确认恢复？"))
					return;
				var rows = $("#banntab").bootstrapTable('getSelections');// 获得要删除的数据
					
				if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
					swal('提示', "请选择需要恢复的id", 'error');
					return;
				} else {
				if(rows[0].bStatus == 3 ||rows[0].bStatus == 1){
					swal('提示', "无需恢复", 'error');
				}else{
					var bStatus = 1;
					var ids = new Array();// 声明一个数组
					$(rows).each(function() {// 通过获得别选中的来进行遍历
						ids.push(this.bId);// cid为获得到的整条数据中的一列
					});
					deleteMs2(ids,bStatus)
						};
				}
				});

			function deleteMs2(ids,bStatus) {
				console.log(ids);
				$.ajax({
							url : "${pageContext.request.contextPath}/bann/restoreList?bStatus="+bStatus,
							data : "bId=" + ids,
							type : "post",
							dataType : "json",
							success : function(data) {
								swal('提示', "恢复成功", 'success');
								$('#banntab')
										.bootstrapTable(
												'refresh',
												{
													url : '${pageContext.request.contextPath}/bann/showBann'
												});
							}
						});
			}
			
			//修改公告(显示内容)
			function showChange(bId, bTitle, bStauts, bContent) {
				console.log(bId, bTitle, bStauts, bContent)
				document.getElementById('bid').value = bId;
				document.getElementById('btitle').value = bTitle;
				/* document.getElementById('bstatus').value = bStauts; */
				document.getElementById('bcontent').value = bContent;
			}
			
			
		</script>


		<button type="button" class="btn btn-primary btn-lg"
			onclick="beDeleted" id="beDeleted"> <i class="fa fa-cogs" aria-hidden="true"></i> 恢复被删除公告</button>




		<script type="text/javascript">
			//全选
			$('#checkAll').click(function() {
				$('#banntab').bootstrapTable('checkAll');
			})
			//取消全选
			$('#uncheckAll').click(function() {
				$('#banntab').bootstrapTable('uncheckAll');
			})
			//反选
			$('#checkInvert').click(function() {
				$('#banntab').bootstrapTable('checkInvert');
			})

			$('#beDeleted').click(function() {
				document.getElementById('search_bstatus').value = 2;
				$('#banntab').bootstrapTable('destroy').bootstrapTable({
					url : '${pageContext.request.contextPath}/bann/showBann',
					method : 'get',
					striped : true, //是否显示行间隔色
					pageNumber : 1, //初始化加载第一页
					cache : true,//是否缓存数据
					toolbar : '#toolbar', //工具按钮用哪个容器
					buttonsAlign : "right", //按钮位置
					pagination : true,//是否分页
					sidePagination : 'server',//server:服务器端分页|client：前端分页
					pageSize : 5,//单页记录数
					pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
					showRefresh : true,//刷新按钮
					clickToSelect : true,//点击选中
					queryParams : function(params) {//上传服务器的参数
						var temp = {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
							limit : params.limit, // 每页显示数量
							offset : params.offset, // SQL语句起始索引
							page : (params.offset / params.limit) + 1,

							bId : $('#search_bId').val(),
							bTitle : $('#search_bTitle').val(),
							bData : $('#search_bData').val(),
							bStatus : $('#search_bstatus').val(),
						};
						return temp;
					},
					columns : [  {
						checkbox : true,
					}, {
						title : 'bID',
						field : 'bId',
						sortable : true,
						width : 50,
					}, {
						title : '标题',
						field : 'bTitle',
						sortable : true,
						width : 100,
					}, {
						title : '日期',
						field : 'bData',
						width : 150,
					}, {
						title : '内容',
						field : 'bContent',
					}, {
						title : '操作',
						width : 65,
						formatter : beDeleted,//对资源进行操作
					} ]
				});
			})

			function beDeleted(value, row, index) {
				var htm = "<button class='btn btn-sm btn-success' onclick = 'bedel(&apos;"
						+ row.bId + "&apos;)'>恢复</button>"
				return htm;
			}
			
			
			//单个恢复function
			function bedel(bId){
				var url = '${pageContext.request.contextPath}/bann/del';
				var bId = bId;
				var bStatus = 1;
				var changes = {
					"bId" : bId,
					"bStatus" : bStatus,
				};
				var jsonData = JSON.stringify(changes);
				$.ajax({
					url : url, // 数据发送方式
					type : "post", // 接受数据格式           
					data : jsonData,
					dataType : "json", // 要传递的数据
					contentType : "application/json;charset=UTF-8",
					success : function(data) {
						if (data.key == "success") {
							swal('提示', "恢复成功！", 'success');
							//清空input内容
						} else {
							swal('提示', "恢复失败！", 'error');
						}
						$('#banntab').bootstrapTable('refresh');
					}

				});
			}
			
			
		</script>

		<!--添加公告 模态框 -->
		<button type="button" class="btn btn-primary btn-lg"
			data-toggle="modal" data-target="#modalTable"><i class="fa fa-plus" aria-hidden="true"></i> 添加公告</button>
		<div id="modalTable" class="modal fade" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document" style="width: 60%">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">添加公告</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="title"> 标 题： </label> <input v-model="title"
								type="text" id="title" placeholder="请输入标题" class="form-control"
								style="width: 15%">
						</div>
						<div class="form-group">
							<label for="content"> 内 容： </label>
							<textarea v-model="content" type="text" id="content"
								placeholder="请输入内容" class="form-control" style="height: 120px"></textarea>
						</div>

						<div class="head-txt">
							<span class="title-txt"></span>
						</div>
						<div class="form-group">
							<input onclick="add()" type="button" name="" value="添加"
								class="btn btn-primary"> <input type="reset" name=""
								value="重置" class="btn btn-danger">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>

	</div>

	<script type="text/javascript">
	//添加公告
		function add() {
			var bContent = document.getElementById('content').value;
			var bTitle = document.getElementById('title').value;
			var adds = {
				"bContent" : bContent,
				"bTitle" : bTitle
			};
			var jsonData = JSON.stringify(adds);
			$.ajax({
				url : "${pageContext.request.contextPath}/bann/add", // 数据发送方式
				type : "post", // 接受数据格式           
				data : jsonData,
				dataType : "json", // 要传递的数据
				contentType : "application/json;charset=UTF-8",
				success : function(data) {
					if (data.key == "success") {
						swal('提示', "添加成功", 'success');
						//清空input内容
						$("#content").val("");
						$("#title").val("");
					} else {
						swal('提示', "添加失败", 'error');
					}
					/* setTimeOut(function(){},2000) */
					$('#banntab').bootstrapTable('refresh');
				}

			});
		}
	</script>

    <script type="text/javascript">
    
    
 var myChart = echarts.init(document.getElementById('main'));
 // 显示标题，图例和空的坐标轴
 myChart.setOption({
     title: {
         text: '公告添加时间统计'
     },
     tooltip: {},
     legend: {
         data:['数量']
     },
     xAxis: {
         data: []
     },
     yAxis: {},
     series: [{
         name: '销量',
         type: 'line',
         data: []
     }]
 });
	 //加载动画
	 myChart.showLoading();
 // 异步加载数据
 $.get('${pageContext.request.contextPath}/bann/statistics').done(function (data) {
	 //隐藏加载动画
	 myChart.hideLoading();
	 //数据处理
	 var bDates = new Array();
	 var dateCounts = new Array();
	 console.log(data);
		for(var i = 0;i <data.length;i++){
			var bDate = data[i].bData;
			var dateCount = data[i].dateCount;
			bDates.push(bDate);
			dateCounts.push(dateCount);
		}
		
		console.log(bDates)
		console.log(dateCounts)
     // 填入数据
     myChart.setOption({
         xAxis: {
             data:bDates
         },
         series: [{
             // 根据名字对应到相应的系列
             name: '数量',
             data: dateCounts
         }]
     });
 });
    </script>
</body>
</html>