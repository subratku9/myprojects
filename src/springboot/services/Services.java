package com.capgemini.springboot.services;

import java.util.List;

import com.capgemini.springboot.beans.Asset;
import com.capgemini.springboot.beans.AssetAllocation;
import com.capgemini.springboot.beans.AssetStatus;
import com.capgemini.springboot.beans.Employee;
import com.capgemini.springboot.beans.UserMaster;

public interface Services {
	UserMaster loginService(Integer userid,String password);
	Asset addAssetService(Asset asset);
	Asset removeAssetService(Integer aid);
	Asset updateAssetService(Asset asu);
	List<Asset> getAllAssetService();
	Employee addEmployeeService(Employee employee);
	AssetAllocation raiseAllocationService(AssetAllocation assetallocation);
	List<AssetAllocation> getAllAssetAllocationService();
	AssetStatus setStatusService(Integer allocationid,String status);
	AssetStatus viewStatusService(Integer allocationid);
	//List<Asset> getAllAllocatedAssetService();
}
