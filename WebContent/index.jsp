<%@page import="org.ndt.obs.entity.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<style type="text/css">
	body
	{
		text-align:center;
		background-color:pink;
		top:100px;
        left:100; 
	    /* background-image: url("C:\\Users\\User\\Downloads\\bookImages\\download.png") ; 
        background-size: cover;
        background-position:top;
        background-repeat: no repeat; 
        min-width:100%;
        min-height:100%;
        
        background-size: 100% auto; */
	}
	h4 
	{ 
	font-family: 'Lucida Handwriting';
	font-size: 15pt; 
	color: Blue; 
	align: center;
	
	}
	label 
	{ 
	font-family: 'Lucida Handwriting';
	font-size: 10pt; 
	color: red; 
	align: center;
	
	}
</style>
</head>

<body >
	<%
	if (session != null)
    {
       Cart cart;
       synchronized (session) 
       {
          
          cart = (Cart) session.getAttribute("cart");
          if (cart != null && !cart.isEmpty())
          {
              out.println("<P><a href='cart.jsp'>View Shopping Cart</a></p>");
          }
       }
    }
	%>
	<form action="SearchServlet" method="post" class=form>
		<h4><pre> WELCOME TO ONLINE BOOK STORE</pre></h4>
		<label>Search by Title : </label>
		<input type="text" name="title"><br><br>
		<input type="submit" value="Submit"><br><br>
		<input type="hidden" name="ACTION" value="SEARCH">
	</form>
</body>
</html>