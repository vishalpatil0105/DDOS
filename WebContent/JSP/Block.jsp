<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Block Ip Address</title>
<%ArrayList<String> userlist= (ArrayList<String>)request.getAttribute("userlist"); %>
</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>

<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->

	<!-- Table Header -->
	<thead>
		<tr>
			<th>IP Address</th>
			<th>Status</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
<%for(int i=0;i<userlist.size();i++){ %>
		<form action="<%=request.getContextPath()%>/Servlet" method="post">
		<tr>

			<td><input type="hidden" name="ip" value="<%=userlist.get(i)%>"></label><%=userlist.get(i)%></td>
			<td><input type="Submit" value="Unblock"></td>
			<input type="hidden" name="action" value="block">
			
		</tr><!-- Table Row -->
</form>
	<%} %>

	</tbody>
</body>
</html>