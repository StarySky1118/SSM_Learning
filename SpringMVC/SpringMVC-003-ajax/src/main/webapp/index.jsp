<%--
  Created by IntelliJ IDEA.
  User: 24211
  Date: 2022/12/6
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ajax请求</title>
    <%--导入 jQuery 函数库--%>
    <script type="text/javascript" src="js/jquery-3.6.1.js"></script>
</head>
<body>
    <a href="javascript:showstu()">请求获取集合</a>
    <br>
    <div id="data_div">等待服务器数据</div>
</body>

<script type="text/javascript">
    function showstu() {
        $.ajax({
            url: "${pageContext.request.contextPath}/list.action",
            type: "get",
            dataType: "json",
            success: function (stu_list) {
                // alert(stu_list);
                var s = "";
                $.each(stu_list, function (i, stu) {
                    s += stu.name + "---" + stu.age + "<br>";
                });
                // 数据显示
                $("#data_div").html(s);
            }
        })
    }
</script>
</html>
