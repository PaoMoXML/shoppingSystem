<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
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


</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">查询条件</div>
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
				<select name="gType" size="1" id="search_gType"
					class="form-control typeselect">
					<option value="" selected>所有类</option>
				</select>
			</div>
			<div class="col-sm-2">
				<button class="btn btn-primary" id="search_btn">查询</button>
				&emsp;&emsp;

				<button class="btn btn-primary" id="add_btn" data-toggle="modal"
					data-target='#addGood'>添加</button>
			</div>
		</div>
	</div>
	<table id="goodstab"
		class="table table-hover table-striped table-bordered"></table>
	<button class="btn btn-danger" id="several_delete">批量删除</button>
	<button class="btn btn-info" id="lookDustbin">查看已删除</button>
	<button class="btn btn-info" data-toggle="modal"
		data-target="#QuantitymodalTable">库存管理</button>

	<div id="main" style="width: 600px; height: 400px;"></div>




	<!-- 修改商品模态框 -->
	<div id="modalChange" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">修改商品</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					ID： <input type="text" id="gId" readonly class="form-control">
					名称：<input type="text" id="gName" class="form-control"> 原价：<input
						type="text" id="gPrecost" class="form-control"> 现价：<input
						type="text" id="gCost" class="form-control"> 库存：<input
						type="text" id="gQuantity" class="form-control"> 图片：
					<button data-toggle="modal" data-target="#ImgChange">
						<img width="165" height="60" id="gMsg" />
						<div class="modal fade" id="myModal">
							<img alt="加载中..." src="../img/loading.gif" />
						</div>
					</button>
					<br> 类型：<select name="gType" size="1" id="selectType"
						class="form-control typeselect">
					</select> 折扣：<select id="choose_discount" onchange="makeDiscount()">
						<option value="1" selected>无折扣</option>
						<option value="0.9">九折</option>
						<option value="0.85">八五折</option>
						<option value="0.75">七五折</option>
						<option value="0.7">七折</option>
						<option value="0.65">六五折</option>
						<option value="0.6">六折</option>
						<option value="0.65">六五折</option>
						<option value="0.6">六折</option>
					</select>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						onclick='updateGood()' data-dismiss="modal">确定修改</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 修改图片拟态框 -->
	<div id="ImgChange" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">商品图片</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<input type="file" name="changeImgFile" id="gMsg_change"
						class="myfile" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						onclick='changeImg()' data-dismiss="modal">确定修改</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>



	<!-- 添加商品模态框 -->
	<div id="addGood" class="modal fade" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">添加商品</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					名称：<input type="text" id="gName_add" class="form-control" required>
					原价：<input type="text" id="gPrecost_add" class="form-control"
						onkeyup="checkInputNum(this)" placeholder="请输入数字类型"> 现价：<input
						type="text" id="gCost_add" class="form-control"
						onkeyup="checkInputNum(this)" placeholder="请输入数字类型"> 库存：<input
						type="text" id="gQuantity_add" class="form-control"
						oninput="value=value.replace(/[^\d]/g,'')" placeholder="请输入整数类型"
						required> 图片： <input type="file" name="uploadImgFile"
						id="gMag_add" class="myfile" /> 类型：<select name="gType" size="1"
						id="add_gType" class="form-control typeselect">
					</select>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" onclick='addGood()'
						data-dismiss="modal">确定添加</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>


	<!-- 库存管理模拟框 -->

	<div id="QuantitymodalTable" class="modal fade" tabindex="-1"
		role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">库存管理</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<table id="goodsForQuantity"
						class="table table-hover table-striped table-bordered"></table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" id="saveChange">保存并退出</button>
				</div>
			</div>
		</div>
	</div>



	<!--  初始化 表格 -->
	<script type="text/javascript">
	function hideModal(){  
	    $('#myModal').modal('hide');  
	}  ;

	function showModal(){  
	    $('#myModal').modal({backdrop:'static',keyboard:false});  
	}  ;
	
		//文件上传
		$(".myfile")
				.fileinput(
						{
							//初始化上传文件框
							language : "zh",//配置语言
							showRemove : true,//显示整体删除的按钮
							uploadAsync : true,//默认异步上传
							showUpload : false,
							//uploadLabel: "上传",//设置整体上传按钮的汉字
							removeLabel : "移除",//设置整体删除按钮的汉字
							uploadClass : "btn btn-primary",//设置上传按钮样式
							showCaption : true,//是否显示标题
							dropZoneEnabled : false,//是否显示拖拽区域  
							uploadUrl : "${pageContext.request.contextPath}/uploadImgFile",//这个是配置上传调取的后台地址，本项目是SSM搭建的
							maxFileSize : 9999,//文件大小限制
							maxFileCount : 9999,//允许最大上传数，可以多个，
							enctype : 'multipart/form-data',
							allowedFileExtensions : [ "jpg", "png", "gif",
									"docx", "zip", "xlsx", "txt" ],/*上传文件格式限制*/
							msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
							showBrowse : true,
							browseOnZoneClick : true,
							slugCallback : function(filename) {
								return filename.replace('(', '_').replace(']',
										'_');
							}
						})

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
																$('.typeselect')
																		.append(
																				$(
																						'<option>')
																						.text(
																								type.tName)
																						.attr(
																								'value',
																								type.tName));
															});
										}
									});
						});

		/* 检查输入的浮点数函数*/
		function checkInputNum(obj) {
			//先把非数字的都替换掉，除了数字和.
			obj.value = obj.value.replace(/[^\d.]/g, "");

			//必须保证第一个为数字而不是.
			obj.value = obj.value.replace(/^\./g, "");

			//保证只有出现一个.而没有多个.
			obj.value = obj.value.replace(/\.{2,}/g, ".");

			//保证.只出现一次，而不能出现两次以上
			obj.value = obj.value.replace(".", "$#$").replace(/\./g, "")
					.replace("$#$", ".");

			//保证 数字整数位不大于8位  可以根据自己的需求进行更改
			if (100000000 <= parseFloat(obj.value))
				obj.value = "";
		}

		/* 显示表格 */
		$('#goodstab')
				.bootstrapTable(
						{
							method : 'get',
							url : "${pageContext.request.contextPath}/good/goodList",//请求路径
							striped : true, //是否显示行间隔色
							pageNumber : 1, //初始化加载第一页
							pagination : true,//是否分页
							sidePagination : 'server',//server:服务器端分页|client：前端分页
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
									gId : $('#search_gid').val(),
									gName : $('#search_gName').val(),
									gType : $('#search_gType').val(),
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
											var pageSize = $('#goodstab')
													.bootstrapTable(
															'getOptions').pageSize;//通过表的#id 可以得到每页多少条
											var pageNumber = $('#goodstab')
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
										title : '图片',
										field : 'gMsg',
										title : '头像',
										align : 'center',
										formatter : function(value, row, index) {
											console.log(value);
											return '<img  src='+value+' width="100" height="100" class="img-rounded" >';
										}
									}, {
										title : '商品ID',
										field : 'gId',

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
										sortable : true,

									}, {
										title : '类型',
										field : 'gType',

									}, {
										title : '操作',
										field : 'gId',
										formatter : operation,//对资源进行操作
									} ]
						})

		//库存管理
		/* 显示表格 */
		$('#goodsForQuantity').bootstrapTable({
			method : 'get',
			url : "${pageContext.request.contextPath}/good/goodList",//请求路径
			striped : true, //是否显示行间隔色
			pageNumber : 1, //初始化加载第一页
			pagination : true,//是否分页
			sidePagination : 'server',//server:服务器端分页|client：前端分页
			pageSize : 4,//单页记录数
			pageList : [ 5, 10, 20, 30 ],//可选择单页记录数
			clickToSelect : true, // 是否启用点击选中行
			showRefresh : true,//刷新按钮
			sortable : true, //启用排序

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

			}, {
				title : '商品名称',
				field : 'gName',

			}, {
				title : '库存',
				field : 'gQuantity',

				sortable : true,

			}, {
				title : '类型',
				field : 'gType',
			}, {
				title : '操作',
				field : 'gId',
				formatter : operationQuantity,//对资源进行操作
			} ]
		})

		//删除、编辑操作
		function operation(value, row, index) {
			var htm = "<button class='btn btn-sm btn-danger'onclick='deleteGood(&apos;"
					+ row.gId
					+ "&apos;)'>删除</button><button class='btn btn-sm btn-info' data-toggle='modal' data-target='#modalChange' onclick='showChange(&apos;"
					+ row.gId
					+ "&apos;,&apos;"
					+ row.gName
					+ "&apos;,&apos;"
					+ row.gPrecost
					+ "&apos;,&apos;"
					+ row.gCost
					+ "&apos;,&apos;"
					+ row.gQuantity
					+ "&apos;,&apos;"
					+ row.gMsg
					+ "&apos;,&apos;"
					+ row.gType
					+ "&apos;)'>修改</button>"
			return htm;
		}

		//库存管理操作
		function operationQuantity(value, row, index) {
			var htm = "<button onclick='changeOneGood(&apos;"
					+ row.gId
					+ "&apos;,type=1,&apos;"
					+ row.gQuantity
					+ "&apos;,index="
					+ index
					+ ")'><i class='fa fa-minus'></i></button><input type='text'  id='MgQuantity' value="
					+ row.gQuantity
					+ "  style='width:50px;' onchange='changeQuantity(Quantity=this.value,index="
					+ index + ")' /><button onclick='changeOneGood(&apos;"
					+ row.gId + "&apos;,type=2,&apos;" + row.gQuantity
					+ "&apos;,index=" + index
					+ ")'><i class='fa fa-plus'></i></button>"
			return htm;
		}
		//改变库存
		function changeQuantity(Quantity) {
			if (isNaN(Quantity) || Quantity < 0) {
				alert("请输入正整数");
				$('#goodsForQuantity').bootstrapTable('refresh');
				return;
			}

			$('#goodsForQuantity').bootstrapTable("updateRow", {
				index : index,
				row : {
					gQuantity : Quantity
				}
			})
		}

		//库存修改,并上传

		$("#saveChange")
				.on(
						"click",
						function() {
							var data = $("#goodsForQuantity").bootstrapTable(
									'getData');// 获得要删除的数据
							var save = JSON.stringify(data);
							console.log(data);
							$
									.ajax({
										contentType : "application/json;charset=UTF-8",
										url : "${pageContext.request.contextPath}/good/updateQuantity",
										data : save,
										type : "post",
										dataType : "json",
										success : function(data) {
											$('#goodstab')
													.bootstrapTable(
															'refresh',
															{
																url : '${pageContext.request.contextPath}/good/goodList'
															});

										}
									});
						})

		//查询按钮事件
		$('#search_btn').click(function() {
			$('#goodstab').bootstrapTable('refresh', {
				url : '${pageContext.request.contextPath}/good/goodList'
			});

		})

		//跳转垃圾车事件
		$('#lookDustbin')
				.click(
						function() {
							window.location.href = "${pageContext.request.contextPath}/good/dusbinPage"

						})

		//批量删除
		$("#several_delete").on("click", function() {
			if (!confirm("是否确认删除？"))
				return;
			var rows = $("#goodstab").bootstrapTable('getSelections');// 获得要删除的数据
			if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
				alert("请先选择要删除的记录!");
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
						url : "${pageContext.request.contextPath}/good/deleteSeveralGood",
						data : "gId=" + ids,
						type : "post",
						dataType : "json",
						success : function(data) {
							$('#goodstab')
									.bootstrapTable(
											'refresh',
											{
												url : '${pageContext.request.contextPath}/good/goodList'
											});
						}
					});
		}
		//修改图片
		function changeImg() {
			var formData = new FormData();
			//采用上传文件对象的方式
			var files = document.getElementsByName("changeImgFile");
			for (var i = 0; i < files.length; i++) {
				console.log(files[i]);
				formData.append("gId", $("#gId").val());
				formData.append('changeimg', files[i].files[0]);
			}

			$.ajax({
				contentType : false,
				//取消帮我们格式化数据，是什么就是什么
				processData : false,
				async : true, //表示请求是否异步处理
				beforeSend:function (){  
			          showModal();  
			      },
				type : "post", //请求类型
				url : "${pageContext.request.contextPath}/good/changeImg",//请求的 URL地址
				data : formData,
				success : function(data) {
					hideModal();
					window.localStorage.setItem("fileName", data.name);
					document.getElementById('gMsg').src = data.url;
				},
				error : function(data) {
					alert("修改失败！");
				}
			});
		}

		//添加商品
		function addGood() {
			var formData = new FormData();
			formData.append("gName", $("#gName_add").val());
			formData.append("gPrecost", $("#gPrecost_add").val());
			formData.append("gCost", $("#gCost_add").val());
			formData.append("gQuantity", $("#gQuantity_add").val());
			formData.append("gType", $("#add_gType").val());

			//采用上传文件对象的方式
			var files = document.getElementsByName("uploadImgFile");

			for (var i = 0; i < files.length; i++) {
				console.log(files[i]);
				formData.append('img', files[i].files[0]);
			}

			$.ajax({
				contentType : false,
				//取消帮我们格式化数据，是什么就是什么
				processData : false,
				async : true, //表示请求是否异步处理
				type : "post", //请求类型
				url : "${pageContext.request.contextPath}/good/addGood",//请求的 URL地址
				data : formData,
				success : function(data) {
					alert("添加成功！");
					$('#goodstab').bootstrapTable('refresh');
				},
				error : function(data) {
					alert("添加失败！");
				}
			});
		}

		function showChange(gId, gName, gPrecost, gCost, gQuantity, gMsg, gType) {
			/* console.log(gId, gName, gPrecost, gCost, gQuantity, gMsg, gType) */
			document.getElementById('gId').value = gId;
			document.getElementById('gName').value = gName;
			document.getElementById('gPrecost').value = gPrecost;
			document.getElementById('gCost').value = gCost;
			document.getElementById('gQuantity').value = gQuantity;
			document.getElementById('gMsg').src = gMsg;
			document.getElementById("selectType").value = gType;
		}

		//修改一个商品
		function changeOneGood(gId, type, gQuantity, index) {

			if (type == 1) {
				if (gQuantity > 0) {

					$('#goodsForQuantity').bootstrapTable("updateRow", {
						index : index,
						row : {
							gQuantity : gQuantity - 1
						}
					})
				} else {

					return;
				}
			} else {

				$('#goodsForQuantity').bootstrapTable("updateRow", {
					index : index,
					row : {
						gQuantity : gQuantity - (-1)
					}
				})
			}
		}

		/* 修改商品 */
		function updateGood() {
			$.ajax({
				async : true, //表示请求是否异步处理
				type : "post", //请求类型
				url : "${pageContext.request.contextPath}/good/updateGood",//请求的 URL地址
				dataType : "json",//返回的数据类型
				data : {
					gId : document.getElementById('gId').value,
					gName : document.getElementById('gName').value,
					gPrecost : document.getElementById('gPrecost').value,
					gCost : document.getElementById('gCost').value,
					gQuantity : document.getElementById('gQuantity').value,
					gMsg : window.localStorage.getItem("fileName"),

					gType : document.getElementById('selectType').value,
				},
				success : function(data) {
					alert("修改成功！");
					$('#goodstab').bootstrapTable('refresh');
				},
				error : function(data) {
					alert("修改失败");
				}
			});
		}

		/* 删除方法 */
		function deleteGood(gId) {

			$.ajax({
				async : true, //表示请求是否异步处理
				type : "post", //请求类型
				url : "${pageContext.request.contextPath}/good/deleteGood",//请求的 URL地址
				data : {
					gId : gId,
				},
				success : function(data) {
					$('#goodstab').bootstrapTable('refresh');
				},
				error : function(data) {
					alert("删除失败！");
				}
			});

		}
		var p = 0;
		/* 折扣方法 */
		function makeDiscount() {
			var dis = document.getElementById('choose_discount').value;
			var cost = document.getElementById('gCost').value;
			if (p == 0) {
				p = cost;
			}
			var num = dis * p;
			var n = num.toFixed(2)
			document.getElementById("gCost").value = n;
		}
		
		var myChart = echarts.init(document.getElementById('main'));
		$.get('${pageContext.request.contextPath}/good/getGoodList').done(function (data) {
			 var cons = new Array(); 
			  for(var i = 0;i<data.name.length;i++){
			    var con = {};
			    con["name"] = data.name[i];
			    con["value"] =data.quantity[i];
			    cons[i] = con;
			  }
			  var json = JSON.stringify(cons);
			  alert("json数组为："+json); 
			console.log(data);
			console.log(1111111111111);
		    myChart.setOption({
		        title : {
		            text: '商品库存数统计',
		            
		            x:'center'
		        },
		        tooltip : {
		            trigger: 'item',
		            formatter: "{a} <br/>{b} : {c} ({d}%)"
		        },
		        legend: {
		            orient: 'vertical',
		            left: 'left',
		            data: data.name
		        },
		        series : [
		            {
		                name: '访问来源',
		                type: 'pie',
		                radius : '55%',
		                center: ['50%', '60%'],
		                data:cons,
		                itemStyle: {
		                    emphasis: {
		                        shadowBlur: 10,
		                        shadowOffsetX: 0,
		                        shadowColor: 'rgba(0, 0, 0, 0.5)'
		                    }
		                }
		            }
		        ]
		    });
		});
       

	</script>
</body>

</html>