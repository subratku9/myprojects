package com.capgemini.jdbc.dao;

import com.capgemini.jdbc.beans.UserBean;

public interface AssetManagementDAO {
	
	public UserBean login(String id, String password);

	public boolean assetAllocateRequest(int assetId, int empId, String allocateDate, String releaseDate);

	public boolean add_modify_asset(int i);

	public void requestOperation();
	
	public void displayOperatedRequest();
	
	public void displayAssetStatus();
}
