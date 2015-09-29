<%@page import="java.util.List"%>
<%@page import="org.ndt.obs.entity.CartItem"%>
<%@page import="org.ndt.obs.entity.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	.form1
	{
		width:200px;  
     	position:absolute; 
     	top:150px; left:6.1in;
		
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

	<% 
	
		Cart cart= (Cart)session.getAttribute("cart");
		 ServletContext sc = getServletConfig().getServletContext();
		if(sc.getAttribute("cart") != null){
			List<CartItem> it = (List<CartItem>)sc.getAttribute("cart");
		   // out.println(it);
		    for(int i = 0; i< it.size(); i++){
		        out.println(it.get(i).getPrice());
		    }
		}
		
		else if(cart==null)
		{
			cart=new Cart();
			session.setAttribute("Cart", cart);
			out.println("Cart is Empty");
		}
		List<CartItem> items = cart.getItems();
		
			
	%>
	
	
	<form action="CartServlet" method="post" class=form>
	<h4><pre>WELCOME TO YOUR CART</pre></h4>
	<table border="1">
			<thead>
				<tr>
					<td>ISBN</td>
					<td>TITLE</td>
					<td>PRICE</td>
				</tr>
			</thead>
			<% 
				
		            for (CartItem item : items)
		            {
		               
		     %>
		     <tr>
		     	<td><%=item.getIsbn()  %></td>
		     	<td><%=item.getTitle() %></td>
		     	<td><%=item.getPrice() %></td>
		     	<td><input type="submit" value="REMOVE"></td>
		     </tr>

     		<input type="hidden" name="ACTION" value="remove"/>
     		<input type="hidden" name="hdnid" value="<%=item.getIsbn()%>"/>
     		<%
		            }
	  %>
	  </table>
	   
	</form>	
	<form action="CartServlet" method="post" class=form1>
	    	<a href='http://localhost:8080/OnlineBookStore/index.jsp'>Select More Books...</a>
	   		<input type="submit"  value="ORDER" /> 
	   		<input type="hidden" name="ACTION" value="order"/>
	   		
	</form>     
	   
	
	
	</body>
	</html>		