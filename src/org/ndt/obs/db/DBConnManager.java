package org.ndt.obs.db;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnManager {
	private static Context initContext;
	private static Context envContext;
	private static DataSource ds;
	static
	{
		try 
		{
			initContext = new InitialContext();
			envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/trng");
		}
		catch (NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		Connection conn=null;
		try
		{
			conn=ds.getConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}


}

