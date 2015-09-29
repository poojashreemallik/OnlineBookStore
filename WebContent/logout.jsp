<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% //HttpSession session = request.getSession();
         if (session == null) {
    %>
       <h3>You have not login!</h3>
     <%
         } else {
            session.invalidate();
     %>
          <p>Bye!</p>
          <p><a href='index.html'>Login</a></p>
</body>
</html>