package com.capgemini.springrest.services;

import java.util.List;

import com.capgemini.springrest.beans.Asset;
import com.capgemini.springrest.beans.AssetAllocation;
import com.capgemini.springrest.beans.AssetStatus;
import com.capgemini.springrest.beans.Employee;
import com.capgemini.springrest.beans.UserMaster;

public interface Services {
	UserMaster loginService(Integer userid,String password);
	Asset addAssetService(Asset asset);
	Asset removeAssetService(Integer aid);
	Asset updateAssetService(Asset asu);
	List<Asset> getAllAssetService();
	AssetAllocation raiseAllocationService(AssetAllocation assetallocation);
	List<AssetAllocation> getAllAssetAllocationService();
	AssetStatus setStatusService(Integer allocationid,String status);
	AssetStatus viewStatusService(Integer allocationid);
}
