<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    
    <%String message=(String)request.getAttribute("message");%>
    
<title>Registration Result</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

	<div id="body" class="width">

		<table>
		<tr>
		</tr>
		<tr>
			<p ><label style="color:red;font-size: medium;"><%=message %></label></p>
		</tr>
		
		</table>
		</div>
		</body>
</html>