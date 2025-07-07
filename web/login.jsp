<%@page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>网上书城</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<script>
    var value = '${message}';

    if (value) {
        alert(value);
    }
</script>
<script type="text/javascript">
    //非空检查
    function isUsernameNull() {
        var username = document.getElementById("username").value;
        var usernull = document.getElementById("usernull");

        if (username == null || username === "") {
            usernull.innerHTML = "<span color=\"red\">用户名不能为空！</span>"
            return false;
        } else
            usernull.innerHTML = ""
        return true;
    }

    function isPasswordNull() {
        var password = document.getElementById("password").value;
        var pwdnull = document.getElementById("pwdnull");

        if (password == null || password === "") {
            pwdnull.innerHTML = "<span color=\"red\">密码不能为空！</span>"
            return false;
        } else
            pwdnull.innerHTML = ""
        return true;
    }

    function check() {
        if (!isUsernameNull()) {
            return false;
        } else if (!isPasswordNull()) {
            return false;
        }
        return true;
    }
</script>

<body>
<div id="container">
    <div id="header" class="wrap">
        <div id="banner"></div>
        <div id="navbar">
        </div>
    </div>

    <div id="login">
        <h2>用户登陆</h2>
        <form method="post" action="login" onsubmit="return check()">
            <dl>
                <dt>用户名：</dt>
                <dd><input class="input-text" type="text" id="username" name="username" onblur="isUsernameNull()"/><span
                        id="usernull"></span></dd>
                <dt>密　码：</dt>
                <dd><input class="input-text" type="password" id="password" name="password"
                           onblur="isPasswordNull()"/><span id="pwdnull"></span></dd>
                <dt>&nbsp;</dt>
                <dd class="button"><input class="input-btn" type="submit" name="submit" value=""/><input
                        class="input-reg" type="button" name="register" value=""
                        onclick="window.location='register.jsp';"/></dd>
            </dl>
        </form>
    </div>
</div>

<div id="footer" class="wrap">
    网上书城 &copy; 版权所有
</div>

</body>
</html>