<%--
  Created by IntelliJ IDEA.
  User: 24211
  Date: 2022/12/7
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转方式</title>
</head>
<body>
    <h3>请求转发</h3>
    <a href="${pageContext.request.contextPath}/one.action">跳转至 main.jsp</a><br>
    <a href="${pageContext.request.contextPath}/two.action">跳转至 main.jsp</a><br>
    <a href="${pageContext.request.contextPath}/three.action">跳转至 main.jsp</a><br>
    <a href="${pageContext.request.contextPath}/four.action">跳转至 main.jsp</a><br>
    <a href="${pageContext.request.contextPath}/five.action">携带参数跳转至 main.jsp</a><br>
    <form action="${pageContext.request.contextPath}/date.action">
        请输入日期：<input type="date" name="date">
        <input type="submit" value="提交">
    </form>
</body>
</html>
