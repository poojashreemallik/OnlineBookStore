<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style type="text/css">
	body
	{
		text-align:center;
		background-color:pink;
	}
	.form
	{
		width:100px;  
     	position:absolute; 
     	top:50px; left:4in;
		
	}
	label 
	{ 
	font-family: 'Lucida Handwriting';
	font-size: 10pt; 
	color: red; 
	align: center;
	
	}
	h4 
	{ 
	font-family: 'Lucida Handwriting';
	font-size: 15pt; 
	color: Blue; 
	align: center;
	
</style>
</head>
<body>
<script type="text/javascript">
	

</script>
	<h4><p>REGISTER HERE</p></h4>
	<form action="IndexServlet" method="post">
		<label>User Name :</label> <input type="text" name="username"><br><br>
		<label>Password  :</label> <input type="text" name="password"><br><br>
		<label>E-MailId  :</label> <input type="text" name="mailid"><br><br>
		<label>City      :</label> <input type="text" name="city"><br><br>
		<label>State     :</label> <input type="text" name="state"><br><br>
		<label>Phone No  :</label> <input type="text" name="phNo"><br><br>
		
		
		<input type="submit" value="Create" >
		<input type="hidden" name="ACTION" value="CREATE">
	</form>
</body>
</html>