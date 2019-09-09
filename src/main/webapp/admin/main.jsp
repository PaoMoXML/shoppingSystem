<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	margin: 0px auto;
	height: auto;
	width: 800px;
	border: 1px solid #006633;
}

#header {
	height: 90px;
	width: 800px;
	background-image: url(../images/admin/bb.jpg);
	margin: 0px 0px 3px 0px;
}

#header h1 {
	text-align: center;
	font-family: 华文彩云;
	color: #000000;
	font-size: 30px；
}

#navigator {
	height: 25px;
	width: 800px;
	font-size: 14px;
	background-image: url(images/admin/bb.jpg);
}
#navigator ul {
	list-style-type: none;
}
#navigator li {
	float: left;
	position: relative;
}
#navigator li a {
	color: #000000;
	text-decoration: none;
	padding-top: 4px;
	display: block;
	width: 98px;
	height: 22px;
	text-align: center;
	background-color: PaleGreen;
	margin-left: 2px;
}
#navigator li a:hover {
	background-color: #006633;
	color: #FFFFFF;
}
#navigator ul li ul {
   visibility: hidden;
   position: absolute;
}

#navigator ul li:hover ul,
#navigator ul a:hover ul{
   visibility: visible;
}

#content {
	height: auto;
	width: 780px;
	padding: 10px;
}

#content iframe {
	height: 300px;
	width: 780px;
}

#footer {
	height: 30px;
	width: 780px;
	line-height: 2em;
	text-align: center;
	background-color: PaleGreen;
	padding: 10px;
}
</style>
</head>

<body>
	<div id="header">
		<br>
		<br>
		<h1>欢迎张三进入后台管理系统！</h1>
	</div>
	<div id="navigator">
		<ul>
			<li><a>商品管理</a>
				<ul>
					<li><a href="addGoods.html" target="center">添加商品</a></li>
					<li><a href="deleteSelectGoods.html" target="center">删除商品</a></li>
					<li><a href="updateSelectGoods.html" target="center">修改商品</a></li>
					<li><a href="selectGoods.html" target="center">查询商品</a></li>
				</ul>
			</li>
			<li><a>类型管理</a>
				<ul>
					<li><a href="addType.html" target="center">添加类型</a></li>
					<li><a href="deleteType.html" target="center">删除类型</a></li>
				</ul>
			</li>
			<li><a>用户管理</a>
				<ul>
					<li><a href="userManager.html" target="center">删除用户</a></li>
				</ul>
			</li>
			<li><a>订单管理</a>
				<ul>
					<li><a href="orderManager.html" target="center">删除订单</a></li>
				</ul>
			</li>
			<li><a>公告管理</a>
				<ul>
					<li><a href="addNotice.html" target="center">添加公告</a></li>
					<li><a href="deleteNoticeSelect.html" target="center">删除公告</a></li>
				</ul>
			</li>
			<li><a href="login.html">安全退出</a></li>
		</ul>
		
	</div>
	<div id="content">
		<iframe src="selectGoods.html"  name="center" frameborder="0"></iframe>
	</div>
	<div id="footer">Copyright ©清华大学出版社</div>
</body>

</html>