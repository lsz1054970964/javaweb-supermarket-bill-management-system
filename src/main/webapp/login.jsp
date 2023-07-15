<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>System Login - SMBMS</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <script>

    </script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>Supermarket Bill Management System</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath}/login.do" name="actionForm" id="actionForm" method="post">
            <div class="info">${error}</div>
            <div class="inputbox">
                <label>Username：</label>
                <input type="text" class="input-text" id="userCode" name="userCode" required/>
            </div>
            <div class="inputbox">
                <label>Password：</label>
                <input type="password" id="userPassword" name="userPassword" required/>
            </div>
            <div class="subBtn">
                <input type="submit" value="login"/>
                <input type="reset" value="reset"/>
            </div>
        </form>
    </section>
</section>
</body>
</html>
