<%--
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
  <h1>include directive</h1>
  <div><%@include file="today.jsp"%></div>
    <%
//        String output=""; include의 경우 가지고있던 변수도 가져오기떄문에 동일 변수명으로 생성불가
    %>
</body>
</html>
