<%--
  Created by IntelliJ IDEA.
  User: 24211
  Date: 2022/12/6
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/req.action" method="post">
        <input type="submit" value="提交">
    </form>

    <%--单个数据提交--%>
    <form action="${pageContext.request.contextPath}/one.action" method="post">
        姓名<input type="text" name="name">
        年龄<input type="text" name="age">
        <input type="submit" value="提交">
    </form>

    <%--数据封装提交--%>
    <form  action="${pageContext.request.contextPath}/two.action">
        姓名<input type="text" name="name">
        年龄<input type="text" name="age">
        <input type="submit" value="提交">
    </form>

    <%--动态占位符提交--%>
    <h3>动态占位符提交</h3>
    <a href="${pageContext.request.contextPath}/three/田所浩二/24.action">蟹蟹♂</a>
</body>
</html>
