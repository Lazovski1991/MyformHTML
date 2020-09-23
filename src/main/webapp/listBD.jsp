<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 22.09.2020
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListBD</title>
</head>
<body>


<% List<User> list = (ArrayList<User>) request.getAttribute("list"); %>
<%
    for (User pair : list) {
%>
<div><a href="/addBase?name=<%=pair.getName()%>"><%=pair.getName()%> </a>
</div>
<%
    }
%>
</body>
</html>
