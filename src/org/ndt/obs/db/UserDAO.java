package org.ndt.obs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ndt.obs.entity.User;

public class UserDAO 
{
	private final static String sql="insert into user(username,password,email,city,state,phNo)" +
			                           " values(?,?,?,?,?,?)";
	private static final String ATHENTICATE_SQL="select username,password,email,city,state,phNo from user where username=? and password=?";
	public boolean createUser(User user)
	{
	Connection conn=DBConnManager.getConnection();
	int row=0;
	try 
	{
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getMailid());
		ps.setString(4, user.getCity());
		ps.setString(5, user.getState());
		ps.setLong(6, user.getPhNo());
		row=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return (row>0);

}
public User authenticate(String username, String password) {
		
		Connection conn=DBConnManager.getConnection();
		ResultSet rs=null;
		User user=null;
		boolean flag=false;
		try {
			PreparedStatement ps=conn.prepareStatement(ATHENTICATE_SQL);
			ps.setString(1, username );
			ps.setString(2,password);
			rs=ps.executeQuery();
			
			while(rs!=null && rs.next())
			{
				user=new User((rs.getString(1)), (rs.getString(2)),(rs.getString(3)),
						                (rs.getString(4)), (rs.getString(5)), (rs.getLong(6)));
				flag=true;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}