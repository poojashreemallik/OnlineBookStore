package org.ndt.obs.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.ndt.obs.entity.Author;
import org.ndt.obs.entity.Book;

public class bookDAO
{
	private static final String SEARCH_SQL="select b.Book_ISBN,b.Book_Title,b.price,a.Author_Name,a.Author_Mail_id from book b,author a where b.Book_ISBN=a.Book_ISBN and b.Book_Title=?";
	private static final String sql="select Book_ISBN,Book_Title,price from book where Book_ISBN=?";
	
	public ArrayList<Book> searchBytitle(String title)
	{
		ArrayList<Book> searchList=new ArrayList<Book>();
		Connection conn=DBConnManager.getConnection();
		ResultSet rs=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SEARCH_SQL);
			ps.setString(1, title);
			rs=ps.executeQuery();
			while(rs!=null && rs.next())
			{
				Author author=new Author((rs.getString(4)),(rs.getString(5)));
				Book book=new Book((rs.getInt(1)),(rs.getString(2)),(rs.getFloat(3)),author);
				searchList.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(searchList);
		return searchList;
	}
	public Book searchByID(int id) {
		Connection conn=DBConnManager.getConnection();
		ResultSet rs=null;
		Book book=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs!=null && rs.next())
			{
				Author author=new Author((rs.getString(4)),(rs.getString(5)));
			    book=new Book((rs.getInt(1)),(rs.getString(2)),(rs.getFloat(3)),author);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return book;
		return;
	}

}
