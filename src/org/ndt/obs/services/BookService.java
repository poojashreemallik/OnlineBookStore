package org.ndt.obs.services;

import java.util.ArrayList;

import org.ndt.obs.db.bookDAO;
import org.ndt.obs.entity.Book;

public class BookService 
{
	public static ArrayList<Book> searchByTitle(String title)
	{
		bookDAO dao=new bookDAO();
		return dao.searchBytitle(title);
		
	}
	public static Book searchByID(int id)
	{
		bookDAO dao=new bookDAO();
		return dao.searchByID(id);
	}

}
