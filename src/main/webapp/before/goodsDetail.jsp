<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情</title>
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

<link href="../css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="../css/before/common.css" rel="stylesheet" type="text/css" />
<link href="../css/before/style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<iframe src="head.jsp" width="100%"> </iframe>

		<div class="blank"></div>
		<div class="block clearfix">
			<ol class="breadcrumb">
			  <li><a href="#">首页</a></li>
			  <li class="active">商品详情</li>
			</ol>

			<div class="blank"></div>
			<div id="goodsInfo">
				<div class="imgInfo">
					<input type="hidden" name="id"
						value="1"/><img
						src="../images/before/103.jpg"
						width="230px" height="230px" />
				</div>
			</div>
			<!--商品表述-->	
			<div class="goods_desc">
				<div class="bt">
					水果1
				</div>
				<div class="goods_show">
					<ul>
						<li><span>价格:</span> <strong class="yj">12元</strong></li>
						<li><span>折扣价:</span><strong
							class="xj">10元</strong>
						</li>
						<li><span>类型:</span>水果</li>
						<li><span>购买数量:</span><input type="text" name="shoppingnum"
							class="good_txt" value="1" /> (库存200件)</li>
					</ul>
				</div>
				<p class="bottom10 top5">
					<img src="../images/before/goods_ann2.gif" style="cursor: pointer"
						onclick="goCart()" />&nbsp;&nbsp;<input type="button"
						style="cursor: pointer" class="sh_bnt2"
						onclick="gofocus('1')"
						value="关注" />
				</p>
			</div>
			<!--end-->
			</div>  
</body>
</html>