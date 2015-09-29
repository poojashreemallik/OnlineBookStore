<%@page import="org.ndt.obs.entity.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="org.ndt.obs.entity.Cart"%>
<%@page import="org.ndt.obs.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OrderDetails</title>
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
<script type="text/javascript">
	function logout()
	{
		
	}
</script>
</head>
<body>
<% User user=(User)request.getAttribute("USER");
  
	Cart cart= (Cart)session.getAttribute("cart");
	
	
	if(cart==null)
	{
		cart=new Cart();
		session.setAttribute("Cart", cart);
		
	}
	else if(cart!=null)
	 {
		 List<CartItem> items = cart.getItems();
	 
	
	float totalPrice=0;
	String username=null;
%>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout" >
	</form>
	
	<form action="ConfirmOrderServlet" method="post" class=form>
		
		<table border="1" width="300px">
		<caption><h4><p>USER_DETAILS</p></h4></caption>
			<thead>
				<tr>
					<td>USER NAME</td>
					<td>CITY</td>
					<td>STATE</td>
				</tr>
				<tr>
					<td><%=username=user.getUsername() %></td>
					<td><%=user.getCity() %></td>
					<td><%=user.getState() %></td>
				</tr>
		</table>
		<table border="1" width="300px">
		<caption><h4><p>ITEM_DETAILS</p></h4></caption>
		<thead>
			<tr>
				<td>Title</td>
				<td>Price</td>
			</tr>
		</thead>
			 <%
			 //if(item!=null)
			 for (CartItem item : items) 
			 {		
			%>
			
			<tr>
				<td><%=item.getTitle() %></td>
				<td><%=item.getPrice()%></td>
				<%   
					totalPrice+=item.getPrice();
				%>
			</tr>
			<%
			 }
			%> 
			<tr>
				<td>Total Price</td>
				<td><%=totalPrice %></td>
			</tr>
			<tr>
				<td><input type="submit" value="Confirm Order" >
				<td><a href="http://localhost:8080/OnlineBookStore/thankyou.jsp">Next</a></td>
			</tr>	
		</table>
			
			<input type="hidden" name="username" value="<%=username%>">
			<input type="hidden" name="totalAmt" value="<%=totalPrice%>">
	</form> 
	<%} %>
</body>
</html>