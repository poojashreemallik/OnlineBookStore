<%@page import="org.ndt.obs.entity.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.ndt.obs.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchResult</title>
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
     	top:100px; left:3.5in;
		
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
	<h4><p>SEARCH</p></h4>
	<%ArrayList<Book> booklist=(ArrayList<Book>) request.getAttribute("BookList");%>
	<form action="CartServlet" method="post" class=form>
	
	<table border="1" >
	  <thead>
		<tr>
			<td>ISBN</td>
			<td>TITLE</td>
			<td>PRICE</td>
			<td>AUTHOR</td>
			<td>MAIL</td>
		</tr>
	  </thead>
		 	<%
			if(booklist!=null)
			{
				for(Book b:booklist)
				{
			
		    %> 
		<tr>
			<td><%=b.getIsbn()%></td>
			<td><%=b.getTitle()%></td>
			<td><%=b.getPrice()%></td>
			<td><%=b.getAuthor().getAuthorName()%></td>
			<td><%=b.getAuthor().getMailID()%></td>
			<td><input type="submit" value="Add To Cart"></td>
		</tr>
		<tr>
			<td>
			<a href="http://localhost:8080/OnlineBookStore/index.jsp">Back</a>
			</td>
		</tr>
</table>
		<input type="hidden" name="ACTION" value="add"/>
		<input type="hidden" name="isbn" value="<%= b.getIsbn()%>"/>
		<input type="hidden" name="title" value="<%= b.getTitle()%>"/>
		<input type="hidden" name="price" value="<%= b.getPrice()%>"/>
		<%
				}
			}
		%>
</form>
</body>
</html>