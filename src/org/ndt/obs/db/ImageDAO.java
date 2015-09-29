package org.ndt.obs.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDAO 
{
	public boolean RetrieveImg(int isbn)
	{
		Connection conn=DBConnManager.getConnection();
		PreparedStatement ps;
		ResultSet rs=null;
		
			try
			{
				ps = conn.prepareStatement("select img from book where isbn=?");
				ps.setInt(1,isbn);  
				rs=ps.executeQuery();
				if(rs.next())
				{
					Blob b=rs.getBlob(1);
					byte barr[]=b.getBytes(1,(int)b.length());
					try {
						FileOutputStream fout=
					  new FileOutputStream("C:\\Users\\User\\Downloads\\bookImages\\images (4).jpg");
						fout.write(barr);
						fout.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				conn.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return false; 
			
		
		 
	}
	
}
