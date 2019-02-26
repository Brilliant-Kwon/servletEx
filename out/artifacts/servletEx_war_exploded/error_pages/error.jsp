<%--
  Created by IntelliJ IDEA.
  User: k1212
  Date: 2019-02-26
  Time: 오전 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%--내부에서 exception이라는 객체를 사용할 수 있게 됨--%>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>오류 발생</h1>
<p>Error Code: <%= response.getStatus() %>
</p>
<p>CAUSE: <%= exception.getCause()%>
</p>
<p>Error Message: <%= exception.getMessage()%>
</p>

</body>
</html>
