<%@page import="bean.FileBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%ArrayList<FileBean> filelist= (ArrayList<FileBean>)request.getAttribute("filelist"); %>
<%String emailid=(String)session.getAttribute("emailid");
String username=(String)session.getAttribute("username");
String msg=(String)request.getAttribute("message");
%>

<title>Download Portal</title>
</head>
<body>
<%if("Admin".equalsIgnoreCase(emailid)){ %>
<jsp:include page="AdminHeader.jsp"></jsp:include>
<%} else{%>
<jsp:include page="Afterloginheader.jsp"></jsp:include>
<%} %>
<label>Welcome <%=username %> <%=emailid %></label>
<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->

	<!-- Table Header -->
	<thead>
		<tr>
			<th>File Name</th>
			<th>File Size</th>
			<th>Download</th>
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>
<%for(int i=0;i<filelist.size();i++){ %>
		<tr>
			<td><%=filelist.get(i).getFilename() %></td>
			<td><%=filelist.get(i).getFilesize()%>MB</td>
			<td><a href="<%=request.getContextPath()%>/FileDownloader?filename=<%=filelist.get(i).getFilename()%>" class="button button-reversed">Download</a></td>
		</tr><!-- Table Row -->

	<%} %>

	</tbody>
	<!-- Table Body -->

</table>

</body>
</html>