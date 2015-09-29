package org.ndt.obs.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ndt.obs.entity.Cart;
import org.ndt.obs.entity.CartItem;
import org.ndt.obs.entity.OrderItem;
import org.ndt.obs.entity.OrderRecord;
import org.ndt.obs.services.OrderService;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderServlet() {
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
		HttpSession session=request.getSession(true);
		Cart cart=(Cart) session.getAttribute("cart");
		List<CartItem> itemList=cart.getItems();
		String username=request.getParameter("username");
		/*int isbn=Integer.parseInt(request.getParameter("isbn"));
		float price=Float.parseFloat(request.getParameter("price"));
		String title=request.getParameter("title");*/
		String mess=null;
		int isbn=0;
		float price=0;
		String title=null;
		float totalAmt=Float.parseFloat(request.getParameter("totalAmt"));
		OrderRecord record=new OrderRecord(username, totalAmt);
		int key=OrderService.orderRecord(record);
		if(key!=0)
		{
			System.out.println("order confirmed");
			for(CartItem item:itemList)
			{
				title=item.getTitle();
				isbn=item.getIsbn();
				price=item.getPrice();
				OrderItem oitem=new OrderItem(title, isbn, price);
				if(OrderService.orderItem(oitem, key))
				{
					System.out.println("Itemorder confirmed");
					mess="Your Order Confirmed";
				}
				else
				{
					System.out.println("Itemorder failed");
				}
			}
			cart.clear();
		}
		else
		{
			System.out.println("order failed");
		}
		
		request.setAttribute("MESSAGE", mess);
		RequestDispatcher rd=request.getRequestDispatcher("thankyou.jsp");
		rd.forward(request, response);
	}

}
