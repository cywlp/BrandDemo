<%--
  Created by IntelliJ IDEA.
  User: 86158
  Date: 2022/3/18
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>确认删除</title>
</head>
<body>
<%
    String did = request.getParameter("id");
    request.setAttribute("id",did);
%>
<form action="/BrandDemo/deleteServlet" method="post">
    <input type="hidden" name="id" value="${id}">
    是否删除？<br>
    <input type="radio" name="status" value="0" checked>否
    <input type="radio" name="status" value="1">是<br>
    <input type="submit" value="提交">

</form>

</body>
</html>
