<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 23.09.2020
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<% User user = (User) request.getAttribute("user"); %>
<%

%>
<div><%= user.getId()%>
</div>
<div><%= user.getName()%>
</div>
<div><%= user.getEmail()%>
</div>
<div><%= user.getText()%>
</div>
</body>
</html>
