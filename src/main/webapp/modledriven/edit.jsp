<%--
  Created by IntelliJ IDEA.
  User: asus-cp
  Date: 2017-08-01
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form action="userAction_update" namespace="/modledriven" method="POST" theme="simple">
        用户名：<s:textfield name="name"/><br/>
        密码：<s:password name="password"/><br/>
        <s:submit value="提交"/>
    </s:form>

    <br/>
    <s:debug/>
</body>
</html>
