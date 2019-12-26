package com.capgemini.springrest.dao;

import java.util.List;

import com.capgemini.springrest.beans.Asset;
import com.capgemini.springrest.beans.AssetAllocation;
import com.capgemini.springrest.beans.AssetStatus;
import com.capgemini.springrest.beans.Employee;
import com.capgemini.springrest.beans.UserMaster;

public interface DAO {
	UserMaster login(Integer userid,String password);
	Asset addAsset(Asset asset);
	Asset removeAsset(Integer aid);
	 Asset updateAsset(Asset asu);
	List<Asset> getAllAsset();
	AssetAllocation raiseAllocation(AssetAllocation assetallocation);
	List<AssetAllocation> getAllAssetAllocation();
	AssetStatus setStatus(Integer allocationid,String status);
	AssetStatus viewStatus(Integer allocationid);
	
}
