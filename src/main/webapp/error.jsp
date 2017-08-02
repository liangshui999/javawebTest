<%--
  Created by IntelliJ IDEA.
  User: asus-cp
  Date: 2017-07-31
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags"   prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    失败<br/>
    <s:fielderror fieldName="date"/>

    <br/><br/>
    表单重复提交相关 :
    <s:actionerror/>
</body>
</html>
