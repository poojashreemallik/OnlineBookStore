package org.ndt.obs.services;

import org.ndt.obs.db.OrderDAO;
import org.ndt.obs.entity.OrderItem;
import org.ndt.obs.entity.OrderRecord;

public class OrderService 
{
	public static int orderRecord(OrderRecord record)
	{
		OrderDAO dao=new OrderDAO();
		int key=dao.orderRecord(record);
		return key;
		
	}
	public static boolean orderItem(OrderItem item,int key)
	{
		OrderDAO dao=new OrderDAO();
		return dao.orderItem(item, key);
		
	}
}
