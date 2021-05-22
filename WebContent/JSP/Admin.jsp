<%@page import="bean.AccessList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
<%ArrayList<AccessList> userlist =(ArrayList<AccessList>) request.getAttribute("userlist");
%>

</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>

<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->

	<!-- Table Header -->
	<thead>
		<tr>
			<th>IP Address</th>
			<th>Time(dd/mm/yyyy hh:mm:ss)</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
<%for(int i=0;i<userlist.size();i++){ %>
		<tr>
			<td><%=userlist.get(i).getIpaddress() %></td>
			<td><%=userlist.get(i).getTime()%></td>
		</tr><!-- Table Row -->

	<%} %>

	</tbody>
</body>
</html>