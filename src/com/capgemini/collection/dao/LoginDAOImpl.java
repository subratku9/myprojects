package com.capgemini.collection.dao;

import java.util.Iterator;

import com.capgemini.collection.beans.User_Master;
import com.capgemini.collection.factory.AssetManagementFactory;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public User_Master login(String password, String userName) {
		
		User_Master returnuser = new User_Master();
		UserInitializingDAOImpl dao = AssetManagementFactory.getInitializeDAOImpl();
		Iterator<User_Master> it = dao.users().iterator();

		while (it.hasNext()) {

			User_Master user = it.next();

			if (user.getUserName().equals(userName) && user.getUserPassword().equals(password)) {

				returnuser = user;
				break;

			} else {

				returnuser = null;
			}
		}
		return returnuser;

	}

	
	
}
