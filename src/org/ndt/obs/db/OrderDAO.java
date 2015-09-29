package org.ndt.obs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ndt.obs.entity.OrderItem;
import org.ndt.obs.entity.OrderRecord;

public class OrderDAO
{
	private static final String sql="insert into orderrecord(username,totalAmt) values(?,?)";
	private static final String Item_SQL="insert into orderItem(id,isbn,title,price)" +
		                    	" values(?,?,?,?)";
	ResultSet keyset;
	
	public int orderRecord(OrderRecord record)
	{
		Connection conn=DBConnManager.getConnection();
		int row=0;
		int key=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, record.getUsername());
			ps.setFloat(2, record.getTotalAmt());
			row=ps.executeUpdate();
			keyset=ps.getGeneratedKeys();
			
			if(row>0)
			{
				while(keyset.next())
				{
					key=keyset.getInt(1);
					System.out.println(key);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
	public boolean orderItem(OrderItem item,int key)
	{
		Connection conn=DBConnManager.getConnection();
		int row=0;
		try {
			PreparedStatement ps=conn.prepareStatement(Item_SQL);
			ps.setInt(1, key);
			ps.setInt(2, item.getIsbn());
			ps.setString(3, item.getTitle());
			ps.setFloat(4, item.getPrice());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (row>0);
	}
}
