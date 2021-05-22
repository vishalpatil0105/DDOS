<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<%String username=(String)request.getAttribute("username"); %>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

	<div id="body" class="width">

<form method="post" class="searchform" action="<%=request.getContextPath()%>/Servlet">
		<table>
		
		<tr>
		<td><label for="name">User ID</label></td>
		<td><input name="EMAILID" id="emailid"
					value="" type="text" width="200%"/></td>
		
		</tr>
		
		
		<tr>
		<td><label for="email">Password</label></td>
		<td><input name="PASSWORD" id="password"
					value="" type="password" width="200%"/></td>
					
		</tr>
		
		<tr>
		<td>
		<input  class="button button-reversed" type="submit" value="Login">
		</td>
		<td>
		<a href="Registration.jsp" class="button button-reversed">Don't have account</a>
		</td>
		
		</tr>
		<input type="hidden" value="login" name="action">
		</table>
			<%if("invalid".equals(username)){ %>
<p style="color:red">The username or password you entered is incorrect.</p>
<%}else{ %>
<p>Detail msg</p>
<%} %>
		</form>


		</article> </section>
	</div>
			<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>