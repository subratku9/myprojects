package com.capgemini.springboot.dao;

import java.util.List;

import com.capgemini.springboot.beans.Asset;
import com.capgemini.springboot.beans.AssetAllocation;
import com.capgemini.springboot.beans.AssetStatus;
import com.capgemini.springboot.beans.Employee;
import com.capgemini.springboot.beans.UserMaster;

public interface DAO {
	UserMaster login(Integer userid,String password);
	Asset addAsset(Asset asset);
	Asset removeAsset(Integer aid);
	 Asset updateAsset(Asset asu);
	List<Asset> getAllAsset();
	Employee addEmployee(Employee employee);
	AssetAllocation raiseAllocation(AssetAllocation assetallocation);
	List<AssetAllocation> getAllAssetAllocation();
	AssetStatus setStatus(Integer allocationid,String status);
	AssetStatus viewStatus(Integer allocationid);
	//List<Asset> getAllAllocatedAsset();
}
