
<%@ page language="java" contentType="text/html"
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>welcome</title>
</head>
<body onload="access()">

 <%  String method = request.getAttribute("method").toString();
     String reqh = request.getAttribute("request_header").toString();
     String content = request.getAttribute("content-type").toString();
     String resh = request.getAttribute("response_header").toString();
     String body = request.getAttribute("body").toString();%>
<script>function access(){
document.forms["myForm"]["method"].value="<%=method%>";
document.forms["myForm"]["req_head"].value="<%=reqh%>";
document.forms["myForm"]["content"].value="<%=content%>"
document.forms["myForm"]["res_head"].value="<%=resh%>"
document.forms["myForm"]["body"].value="<%=body%>"}
</script><form name="myForm" action="/signout" align="center" method="post" readonly>
method type with url:<br>
<input type="text" name="method" readonly>
<h4>Request<h4><br>
header:<br>
<input type="text" name="req_head" readonly><br>
content-type:<br>
<input type="text" name="content"  readonly><br>
<h4>Response<h4> <br>
header:<br>
<input type="text" name="res_head" readonly><br>
body:<br>
<textarea rows="15",cols="50" name="body" readonly></textarea><br>
<input type="submit" value="Signout">
</form>
</body></html>