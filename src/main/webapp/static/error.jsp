<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background: url("${pageContext.request.contextPath}/images/pic-error.png") 0 0 no-repeat;
	 background-position:55% -70%;
}
/* body{
	background-color: #ccc;
} */
</style>
<body>
	<h1>There is something wrong...</h1>
	<a href="../login.jsp">return to the login page</a>
</body>
</html>