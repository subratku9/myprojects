package com.capgemini.collection.factory;

import com.capgemini.collection.dao.Add_AssetImpl;
import com.capgemini.collection.dao.Asset_AllocationDAOImpl;
import com.capgemini.collection.dao.UserInitializingDAOImpl;
import com.capgemini.collection.dao.LoginDAOImpl;
import com.capgemini.collection.dao.Request_ScreenDaoImpl;

public class AssetManagementFactory {

	
	public static LoginDAOImpl getloLoginDaoImpl() {
		return new LoginDAOImpl();
	}

	public static Asset_AllocationDAOImpl getAssetAllocationImpl() {
		return new Asset_AllocationDAOImpl();
	}

	public static Add_AssetImpl getAddAssetImpl() {
		return new Add_AssetImpl();
	}

	public static UserInitializingDAOImpl getInitializeDAOImpl() {
		return new UserInitializingDAOImpl();
	}
	
	public static Request_ScreenDaoImpl getRequest_ScreenDaoImpl() {
		return new Request_ScreenDaoImpl();
	}

}
