<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/upload/uploadImage" method="post" enctype="multipart/form-data">
        选择图片：<input type="file" name="image" accept="image/*" id = "a"/><br>
        <input type="submit" value="上传" onclick="imgUrl()">
    </form>

    
    
      <input name="file" id="FileUpload" type="file" />
 
      <input type="button" onclick="Submit()" value="提交" />

<script src="../js/jquery-3.4.1.min.js"></script>
    
    
    
<script type="text/javascript">
    var xhrOnProgress=function(fun) {
      xhrOnProgress.onprogress = fun; //绑定监听
      //使用闭包实现监听绑
      return function() {
        //通过$.ajaxSettings.xhr();获得XMLHttpRequest对象
        var xhr = $.ajaxSettings.xhr();
        //判断监听函数是否为函数
        if (typeof xhrOnProgress.onprogress !== 'function')
          return xhr;
        //如果有监听函数并且xhr对象支持绑定时就把监听函数绑定上去
        if (xhrOnProgress.onprogress && xhr.upload) {
          xhr.upload.onprogress = xhrOnProgress.onprogress;
        }
        return xhr;
      }
    }
     
    function Submit(){
 
         var fileObj = document.getElementById("FileUpload").files[0]; // js 获取文件对象
         var formFile = new FormData();
         
         formFile.append("file",$("#FileUpload")[0].files[0]); //加入文件对象
         
          var data = formFile;
          $.ajax({
                   url: "${pageContext.request.contextPath}/upload/uploadImage",
                   data: data,
                   type: "Post",
                   dataType: "json",
                   mimeType:"multipart/form-data",
                   cache: false,//上传文件无需缓存
                   processData: false,//用于对data参数进行序列化处理 这里必须false
                   contentType: false, //必须
                   xhr:xhrOnProgress(function(e){
                      var percent=e.loaded/e.total;
                      console.log(percent);
                   }),
                   success: function (result) {
                       console.log(result);
                   },
               })
    }
     
</script>
    
    
</body>
</html>