<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src = "../js/jquery-3.4.1.min.js"></script>
</head>

<body>
  <input name="file" id="FileUpload" type="file" />
 
      <input type="button" onclick="Submit()" value="提交" />
      
      <script type="text/javascript">
      var formData = new FormData();
      var files=document.getElementsById("FileUpload");
      for(var i=0;i<files.length;i++){
	    	console.log(files[i]);
		    formData.append('img',files[i].files[0]);
	    }
      
      function Submit(){
       $.ajax({
    	           type:'POST',
    	           url:"${pageContext.request.contextPath}/ajaxUpload/upload",
    	           data:formData,
    	           contentType:false,
    	           processData:false,//这个很有必要，不然不行
    	           success:function(data){
    		  console.log(data)
    	              }
    	       });
    	  
      }
      
      </script>
</body>
</html>