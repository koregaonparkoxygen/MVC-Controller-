<%@page import="bank.dao.bankInterfaceImp"%>
<%@page import="java.util.List"%>
<%@page import="bank.dao.bankInterface"%>
<%@page import="bank.info.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}
</style>

</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="HOME.html">Home</a></li>
					<li class="nav-item"><a class="nav-link active "
						href="register.html">REGISTER</a></li>
					<li class="nav-item"><a class="nav-link active "
						href="login.html">LOGIN</a></li>
					<li class="nav-item"><a class="nav-link active "
						href="search.jsp">SEARCH</a></li>
					<li class="nav-item"><a class="nav-link active "
						href="update.html">UPDATE</a></li>
					<li class="nav-item"><a class="nav-link active "
						href="delete.jsp">DELETE</a></li>
					<li class="nav-item"><a class="nav-link active "
						href="display.jsp">DISPLAY</a></li>
					
			</div>
		</div>
	</nav>

	<form action="display">

		<table>
			<tr>
				<th>Registration no</th>
				<th>Username</th>
				<th>Password</th>
				<th>Account balance</th>
			</tr>
			<%
			bankInterface rdao = new bankInterfaceImp();
			List<Register> lstreg = rdao.displayAll();
			for (Register reg : lstreg) {
			%>
			<tr>
				<td><%=reg.getAccNo()%></td>
				<td><%=reg.getUserName()%></td>
				<td><%=reg.getPassword()%></td>
				<td><%=reg.getAccBal()%></td>
			</tr>
			<%
			}
			lstreg=null;
			%>
		</table>

	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>