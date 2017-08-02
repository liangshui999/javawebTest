<%--
  Created by IntelliJ IDEA.
  User: asus-cp
  Date: 2017-08-01
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="save.jsp">跳转到保存页面</a>
    <br/><br/>

    先通过useraction再到编辑页面<br/>
    <a href="${pageContext.request.contextPath}/modledriven/userAction_edit.action">跳转到编辑页面</a>
    <br/>

</body>
</html>
