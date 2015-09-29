<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ThankYou</title>
<style type="text/css">
	body
	{
		text-align:center;
		background-color:pink;
	}
	h4 
	{ 
	font-family: 'Lucida Handwriting';
	font-size: 15pt; 
	color: Blue; 
	align: center;
	}
</style>
</head>
<body>
	<% String mess=(String)request.getAttribute("MESSAGE"); %>
	<h4><p>Thank you for shopping ....</p></h4>
	<%if(mess!=null){ %>
    <h4><p><%=mess%></p></h4>   
	<%} %>
</body>
</html>