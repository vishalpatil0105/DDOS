<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<script src="../javascript/validation.js"></script>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>

	<div id="body" class="width">




		<article>


		<form action="<%=request.getContextPath() %>/Servlet" method="post" class="searchform" action="#">
		<table>
		<tr>
		<td width="20%"><label for="name">First Name</label></td>
		<td width="30%"> <input name="FNAME" id="fname"
					value="" type="text" width="200%" onblur="firstname();"/></td>
					<td>
				<p id="fnameerror" style="visibility: hidden" width="30%"> There is an error in First Name</p>
				</td>
		</tr>
		<tr>
		<td><label for="name">Last Name</label></td>
		<td><input name="LNAME" id="lname"
					value="" type="text" width="200%" onblur="lastname();"/></td>
					<td>
				<q id="lnameerror" style="visibility: hidden"></q>
				</td>
		
		</tr>
		<tr>
		<td><label for="name">Address</label></td>
		<td><input name="ADDRESS" id="address"
					value="" type="text" width="200%" onblur="address();"/></td>
		</tr>
		<tr>
		<td><label for="name">Email-id</label></td>
		<td><input name="EMAILID" id="email-id"
					value="" type="text" width="200%" onblur="email-id();"/></td>
		</tr>
		<tr>
		<td><label for="name">Confirm Email-id</label></td>
		<td><input name="CONFIRM EMAIL-ID" id="confirm email-id"
					value="" type="text" width="200%" onblur="emailid();"/></td>
					<td>
				<q id="email-iderror" style="visibility: hidden"></q>
				</td>
				
		</tr>
		<tr>
		
		<td><label for="gender">Gender</label></td>
		<td><input type="radio" name="GENDER" checked="checked" value="m"/> Male   <input type="radio" value="f" name="GENDER" />Female</td>
		</tr>
		<tr>
		<td>
		<input type="submit" class="button button-reversed" value="Sign Up">
		</td>
		<td>
		<input type="reset" value="Reset"  class="button button-reversed" />
		</td>
		
		</tr>
		
		</table>
			<input type="hidden" value="registration" name="action">
		</form>


		</article> </section>
	</div>
			<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>