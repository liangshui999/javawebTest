<%--
  Created by IntelliJ IDEA.
  User: asus-cp
  Date: 2017-08-01
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
    <title>这是ognl的界面</title>
</head>
<body>
    获取几个作用域里面的name值<br/>
    request域：<s:property value="#request.name"/><br/>
    session域：<s:property value="#session.name"/><br/>
    application域：<s:property value="#application.name"/><br/>
    直接在attr里面寻找：<s:property value="#attr.name"/><br/>
    获取参数：<s:property value="#parameters.id"/>.....
    <s:property value="#parameters.score"/>
    <s:debug/>
    <br/><br/><hr/><br/><br/>

    获取对象栈里面的值<br/>
    地址：<s:property value="province"/>.........<s:property value="city"/><br/>
    五行：
    <s:iterator var="wuxing" value="list" status="st">
        <s:if test="#st.index>2"><%--千万注意st的前面必须加上#号，否则会出错--%>
            <s:property value="wuxing"/>
        </s:if>
    </s:iterator>
    <s:debug/>

</body>
</html>
