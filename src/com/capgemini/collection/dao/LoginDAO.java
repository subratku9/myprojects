package com.capgemini.collection.dao;

import com.capgemini.collection.beans.User_Master;

public interface LoginDAO {

	public User_Master login(String password , String userName);
	
}
