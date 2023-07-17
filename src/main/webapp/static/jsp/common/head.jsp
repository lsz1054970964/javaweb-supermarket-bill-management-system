<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Smbms</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css" />
</head>
<body>
<!--Header-->
<header class="publicHeader">
    <h1>Supermarket Bill Management System</h1>
    <div class="publicHeaderR">
        <p><span>Hello </span><span style="color: #fff21b">${userSession.userCode}</span>, Welcome！</p>
        <a href="${pageContext.request.contextPath }/static/js/logout.do">Exit</a>
    </div>
</header>
<!--Time-->
<section class="publicTime">
    <span id="time">2023-01-01 11:11  Monday</span>
    <a href="#">Reminder： In order to browse normally, please use a higher version browser！</a>
</section>
<!--main-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>Functions <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath }/static/jsp/bill.do?method=query">Bills</a></li>
                <li><a href="${pageContext.request.contextPath }/static/jsp/provider.do?method=query">Providers</a></li>
                <li><a href="${pageContext.request.contextPath }/static/jsp/user.do?method=query">Users</a></li>
                <li><a href="${pageContext.request.contextPath }/static/jsp/pwdmodify.jsp">Password Revision</a></li>
                <li><a href="${pageContext.request.contextPath }/static/js/logout.do">Exit the System</a></li>
            </ul>
        </nav>
    </div>
    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }/static"/>
    <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
