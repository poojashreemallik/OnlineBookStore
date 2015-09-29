package org.ndt.obs.services;

import org.ndt.obs.db.UserDAO;
import org.ndt.obs.entity.User;

public class UserService 
{
	public static boolean createUser(User user)
	{
		UserDAO dao=new UserDAO();
		return dao.createUser(user);
	}

	public static User userAthentucate(String username, String password) {
		UserDAO dao=new UserDAO();
		return dao.authenticate(username, password);
	}

}
