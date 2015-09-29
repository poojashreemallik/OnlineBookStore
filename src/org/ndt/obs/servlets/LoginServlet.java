package org.ndt.obs.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ndt.obs.entity.User;
import org.ndt.obs.services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String mess=null;
		RequestDispatcher rd;
		User user=UserService.userAthentucate(username,password);
		if(user!=null)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("USER", user);
			mess="Login Successfuly";
			rd=getServletContext().getRequestDispatcher("/home.jsp");
		}
		else
		{
			mess="user name or password is incorrect";
			rd=getServletContext().getRequestDispatcher("/login.jsp");
		}
		
		request.setAttribute("MESSAGE", mess);
		rd.forward(request, response);
	}
}


