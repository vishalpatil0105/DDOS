<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/styles.css" type="text/css" />
</head>
<body>
<div id="container">

		<header>
			<div class="width">
				<h1>
					<a href="/">File Downloader Manager</a>
				</h1>
			</div>
		</header>

		<nav>
			<div class="width">
				<ul>
					<li><a href="<%=request.getContextPath()%>/Servlet?action=blockip">Blocked IP</a>
					</li>
					<li class=""><a href="<%=request.getContextPath()%>/Servlet?action=download">Download Files</a>
					</li>
					<li><a href="<%=request.getContextPath()%>/Servlet?action=showfiles">Show Access List</a>
					</li>
					<li class="bt-icon"><a href="<%=request.getContextPath()%>/JSP/Login.jsp">Log out</a></li>
				</ul>
			</div>
		</nav>
		</div>
		
</body>
</html>