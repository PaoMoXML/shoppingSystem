<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table id="my_table_id"
    data-url="data/url.json"
    data-id-field="id"
    data-editable-emptytext="Default empty text."
    data-editable-url="/my/editable/update/path">
    <thead>
      <tr>
        <th class="col-md-1" data-field="id" data-sortable="true" data-align="center">#</th>
        <th class="col-md-4" data-field="name" data-editable="true">Name</th>
        <th class="col-md-7" data-field="description" data-editable="true" data-editable-emptytext="Custom empty text.">Description</th>
      </tr>
    </thead>
  </table>
  
</body>
</html>