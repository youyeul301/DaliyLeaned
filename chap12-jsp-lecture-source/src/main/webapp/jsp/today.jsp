<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-12
  Time: 오후 4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    Date today=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyyy년 mm월 dd일 E요일 a hh시 mm분 ss초");

    String output =sdf.format(today);
  %>
  <h3><%=output%></h3>
</body>
</html>
