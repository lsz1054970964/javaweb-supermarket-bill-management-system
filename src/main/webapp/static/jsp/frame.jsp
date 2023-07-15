<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css" />
</head>
<section>
    <%@ include file="./common/head.jsp"%>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath}/static/images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${userSession.userCode},</h2>
            <h3> Welcome to the supermarket bill management system！</h3>
        </div>
    </div>
</section>

<%@ include file="./common/foot.jsp"%>
