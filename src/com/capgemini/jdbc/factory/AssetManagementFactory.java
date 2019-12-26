package com.capgemini.jdbc.factory;

import com.capgemini.jdbc.dao.AssetManagementDAOImpl;

public class AssetManagementFactory {

	public static AssetManagementDAOImpl getAssetManagementDAOImpl() {
		return new AssetManagementDAOImpl();
	}
}
