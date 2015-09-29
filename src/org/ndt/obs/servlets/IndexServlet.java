package org.ndt.obs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ndt.obs.entity.Cart;
import org.ndt.obs.entity.User;
import org.ndt.obs.services.UserService;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
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
		String action=request.getParameter("ACTION");
		System.out.println(action);
		PrintWriter out=response.getWriter();
		if( action!=null && "LOGIN".equals(action))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String mess=null;
			RequestDispatcher rd;
			User user=UserService.userAthentucate(username,password);
			if(user!=null)
			{
				mess="Login Successfuly";
				System.out.println(mess);
				out.println(mess);
				HttpSession session=request.getSession(true);
				request.setAttribute("USER", user);
				rd=request.getRequestDispatcher("order.jsp");
				rd.forward(request, response);
			}
			else
			{
				mess="user name or password is incorrect";
				rd=getServletContext().getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
			
			//request.setAttribute("MESSAGE", mess);

		}
		else if("SEARCH".equals(action))
		{
			RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
		}
		else if("REGISTER".equals(action))
		{
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
		else
		{
			String username= request.getParameter("username");
			String password=request.getParameter("password");
			String mailid= request.getParameter("mailid");
			String city= request.getParameter("city");
			String state= request.getParameter("state");
			String phno= request.getParameter("phNo");
			long phNo=Long.parseLong(phno);
			User user=new User(username, password, mailid, city, state, phNo);
			if(UserService.createUser(user))
			{
				out.println("Successfully Created");
				request.getSession(true);
				request.setAttribute("USER", user);
				RequestDispatcher rd=request.getRequestDispatcher("order.jsp");
				rd.forward(request, response);
			}
		}
		
		/*HttpSession session = request.getSession(false); 
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
        }*/
	}

}
