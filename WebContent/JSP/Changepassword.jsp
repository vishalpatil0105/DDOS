<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%String emailid=(String)session.getAttribute("emailid");
String message=(String)request.getAttribute("message");
%>
</head>
<body>
<jsp:include page="Afterloginheader.jsp"></jsp:include>
<div id="body" class="width">

<form method="post" class="searchform" action="<%=request.getContextPath()%>/Servlet">
		<table>
		
		<tr>
		<td><label for="password">Current Password</label></td>
		<td><input id="pwd" name="CPWD"
					value="" type="password" width="200%"/></td>
		
		</tr>
		
		<tr>
		<td><label for="new password">New Password</label></td>
		<td><input  id="password" name="NPWD"
					value="" type="password" width="200%"/></td>
					
		</tr>
		
		<tr>
		<td><label for="new password">Confirm New Password</label></td>
		<td><input name="PASSWORD" id="password" 
					value="" type="password" width="200%"/></td>
					
		</tr>
		
		<tr>
		<td>
		<input  class="button button-reversed" type="submit" value="Change Password">
		</td>
		
		
		</tr>
		<input type="hidden" value="ChangePWD" name="action">
		</table>
			<%if(message!=null){%>
							<%=message %>
					<%} %>
		</form>


		</article> </section>
	</div>
			<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>