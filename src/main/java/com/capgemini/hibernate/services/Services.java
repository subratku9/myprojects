package com.capgemini.hibernate.services;
import java.util.List;

import com.capgemini.hibernate.beans.Asset;
import com.capgemini.hibernate.beans.AssetAllocation;
import com.capgemini.hibernate.beans.Employee;
import com.capgemini.hibernate.beans.UserMaster;

public interface Services {
	UserMaster loginService(Integer userid, String password);

	Asset addAssetService(Asset asset);

	Asset removeAssetService(Integer aid);

	Asset updateAssetNameService(Integer aid, String assetname);

	Asset updateAssetDesService(Integer aid, String assetdes);

	Asset updateAssetQuantityService(Integer aid, Integer assetquan);

	Asset updateAssetStatusService(Integer aid, String assetstatus);

	List<Asset> getAllAssetService();

	AssetAllocation raiseAllocationService(AssetAllocation assetallocation);

	List<AssetAllocation> getAllAssetAllocationService();

	Boolean setStatusService(Integer allocationid, String status);

	String viewStatusService(Integer allocationid);
	
}

