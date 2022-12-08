<%--
  Created by IntelliJ IDEA.
  User: 24211
  Date: 2022/12/4
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用</title>
</head>
<body>
    <!--使用 .action 后缀以便请求可以被 DispatcherServlet 拦截-->
    <a href="${pageContext.request.contextPath}/user/demo.action">访问服务器</a>
</body>
</html>
