<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传测试</title>

<link href="../css/admin/common.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css"
	href="../css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/sweetalert.css" />



<%--js部分--%>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-table.js"></script>
<script src="../js/bootstrap-table-zh-CN.js"></script>
<script src="../js/sweetalert.js"></script>
<script src="../js/board.js"></script>
<script src="../js/board2.js"></script>
<script src="../js/cos-js-sdk-v5.js"></script>

</head>
<body>

	<input id="file-selector" type="file" name="filename">
	<input id="submitBtn" type="button" οnclick="test()" value="提交">
	<img src="" id="img0" class="img-thumbnail">


	<script type="text/javascript">
	var Bucket = 'xml-1256638142';
	var Region = 'ap-shanghai';
	
	
		var selectedFile;
		var filename;

		
		var cos = new COS({
			SecretId:'AKIDCYqkVVVkbm0BFISTp8WG0eCmFkEduzsg',
			SecretKey:'mS1PadVCXBwtNsDQWRXcwJoI7nJmbrws',
		})
		
		document.getElementById('file-selector').onchange = function () {
		    var file = this.files[0];
		    if (!file) return;
		    cos.putObject({
		    	dataType: 'jsonp',  
		    	crossDomain: true,  
		        Bucket: Bucket,
		        Region: Region,
		        Key: '目标路径/' + file.name,
		        Body: file,
		    }, function (err, data) {
		        console.log(err || data);
		    });
		};
		
	</script>



</body>
</html>