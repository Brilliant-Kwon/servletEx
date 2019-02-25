<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-02-25
  Time: 오후 1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello JSP</title>
</head>
<body>
<h1>Hello JSP</h1>
<!--동적으로 값을 할당--!>
<!--name 파라미터--!>
<%
    //JSP는 Request에 관련된 객체를
    //request라는 이름으로 미리 만들어 전달.
    //Response객체 -> response
    String name = request.getParameter("name");
    if (name == null) name = "Anonymous";
%>
<p>Welcome, <%=name%></p>
</body>
</html>
