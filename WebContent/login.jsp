<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
	}
</style>
</head>
<body>
<script type="text/javascript">
function register()
{
	document.forms[0].ACTION.value='REGISTER';
	document.forms[0].submit();
}
</script>
<h4>LOGIN HERE</h4>
	<br>
	<form action="IndexServlet" method="post" >
	<label>Enter user name:</label><input type="text" name="username"><br><br>
	<label>Enter password :</label><input type="text" name="password"><br><br>
	
	<input type="submit" value="Login">
	<input type="button" value="REGISTER" onclick="register();" >
	<input type="hidden" name="ACTION" value="LOGIN">

	</form>
</body>
</html>