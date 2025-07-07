<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="header" class="wrap">
    <div id="banner"></div>
    <div id="navbar">
    </div>
</div>
<div id="content" class="wrap">
    <div>
        <h2 style="text-align: center; ">您的登录状态已失效，页面将在 <span style="color: red" id="countdown">5</span> 秒后跳转至登录界面</h2>
    </div>
</div>
<div id="footer" class="wrap">
    网上书城&copy;版权所有
</div>
</body>
<script>
    let countdown = 4; // 倒计时时间（秒）
    const countdownElement = document.getElementById('countdown');

    // 更新倒计时
    const countdownInterval = setInterval(() => {
        countdownElement.textContent = countdown; // 更新页面上的倒计时显示
        countdown--; // 倒计时减1

        // 当倒计时结束时
        if (countdown < 0) {
            clearInterval(countdownInterval); // 停止倒计时
            window.location.href = 'login.jsp'; // 跳转到目标页面
        }
    }, 1000); // 每1000毫秒（1秒）更新一次
</script>
</html>