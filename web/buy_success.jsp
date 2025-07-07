<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>网上书城</title>
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
        <h2 style="text-align: center; color: green">购买成功，页面将在 <span id="countdown">&nbsp;</span> 秒后跳转</h2>
    </div>
</div>
<div id="footer" class="wrap">
    网上书城&copy;版权所有
</div>
</body>
<script>
    let countdown = 5; // 倒计时时间（秒）
    const countdownElement = document.getElementById('countdown');

    // 更新倒计时
    const countdownInterval = setInterval(() => {
        countdownElement.textContent = countdown; // 更新页面上的倒计时显示
        countdown--; // 倒计时减1

        // 当倒计时结束时
        if (countdown < 0) {
            clearInterval(countdownInterval); // 停止倒计时
            window.location.href = 'getBooks'; // 跳转到目标页面
        }
    }, 1000); // 每1000毫秒（1秒）更新一次
</script>
</html>






