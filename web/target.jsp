<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-02-26
  Time: 오후 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Request 정보 확인</title>
</head>
<body>
<h1>Request Info</h1>
<ul>
    <li>Request Method:
        <%= request.getMethod()%>
    </li>
    <li>Context Path:
        <%= request.getContextPath()%>
    </li>
</ul>

<h3>HTTP Header</h3>
<ul>
    <% //헤더 정보 확인
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
        }

    %>
</ul>
</body>
</html>
