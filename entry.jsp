
<%@ page language="java" contentType="text/html"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Entry</title>
</head>
<body>

<form name="myForm" action="/entry" align="center" method="post">
method type with url:<br>
<input type="text" name="method" >
<h4>Request<h4><br>
header:<br>
<input type="text" name="req_head"><br>
content-type:<br>
<input type="text" name="content"><br>
<h4>Response<h4> <br>
header:<br>
<input type="text" name="res_head"><br>
body:<br>
<textarea rows="15",cols="50" name="body"></textarea><br>
<input type="submit" value="Submit">
</form>
</body>
</html>