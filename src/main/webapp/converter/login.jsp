<%--
  Created by IntelliJ IDEA.
  User: asus-cp
  Date: 2017-07-31
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login/login.action" method="get">
        用户名：<input type="text" name="userName"/><br/>
        密码：<input type="password" name="password"/><br/>
        登录日期：<input type="text" name="date"/><br/>
        省：<input type="text" name="address.province"/><br/>
        市：<input type="text" name="address.city"/><br/>
        <input type="submit" value="登录"/>
    </form>

</body>
</html>
