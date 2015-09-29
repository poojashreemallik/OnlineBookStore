package org.ndt.obs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ndt.obs.entity.Book;
import org.ndt.obs.entity.Cart;
import org.ndt.obs.entity.CartItem;
import org.ndt.obs.services.BookService;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action=request.getParameter("ACTION");
		
	      HttpSession session = request.getSession(true);
	      Cart cart;
	      System.out.println(action);
	      synchronized (session) {  
	         cart = (Cart) session.getAttribute("cart");
	         if (cart == null) {  
	            cart = new Cart();
	            session.setAttribute("cart", cart);  
	         }
	      }
	      

	      	    if (action.equals("add") || action.equals("remove")|| action.equals("order") )
	      	    {
	    	  
	      		
			      if (action.equals("add"))
			      {
			    	  
			      	    String hid=request.getParameter("isbn");
			      	    String hprice=request.getParameter("price");
			            String title=request.getParameter("title");
			            
			            
			            int id=0;
			            float price=0;
			            if(hprice!=null)
			      		{
			            	
			      			price=Float.parseFloat(hprice);
			      		}
			      		if(hid!=null)
			      		{
			      			
			      			id=Integer.parseInt(hid);
			      		}
			      		
			            CartItem item=new CartItem(id, title, price);
			            
			    	  cart.add(item);
			    	  RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
						rd.forward(request, response);
			      }
			      else if(action.equals("remove"))
			      {
			    	  int hisbn=Integer.parseInt(request.getParameter("hdnid"));
			    	  System.out.println(hisbn);
			    	  cart.remove(hisbn);
			    	  RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
						rd.forward(request, response);
			      }
			      else if(action.equals("order"))
		      	   {
		      	    	response.sendRedirect("login.jsp");
		      	   }
			     
	            
		            
	      	      }
		      	   
	}    
}


