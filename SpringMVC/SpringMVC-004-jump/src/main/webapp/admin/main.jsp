<%--
  Created by IntelliJ IDEA.
  User: 24211
  Date: 2022/12/7
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>你好</h1>
    request:${requestScope.request}<br>
    session:${sessionScope.session}<br>
    model:${model}<br>
    map:${map}<br>
    modelMap:${modelMap}<br>
    你提交的日期为：${requestScope.date}

</body>
</html>
