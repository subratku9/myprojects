package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.collection.beans.Asset;
import com.capgemini.collection.beans.Asset_Allocation;
import com.capgemini.collection.beans.Employee;
import com.capgemini.collection.beans.User_Master;

public interface UserInitializingDAO {

	public ArrayList<User_Master> users();
	
	public ArrayList<Employee> employees();
	
	public ArrayList<Asset> assets();
	
}
