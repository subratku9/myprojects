package com.capgemini.hibernate.dao;
import java.util.List;

import com.capgemini.hibernate.beans.Asset;
import com.capgemini.hibernate.beans.AssetAllocation;
import com.capgemini.hibernate.beans.Employee;
import com.capgemini.hibernate.beans.UserMaster;

public interface Dao {
	UserMaster login(Integer userid, String password);

	Asset addAsset(Asset asset);

	Asset removeAsset(Integer aid);

	Asset updateAssetName(Integer aid, String assetname);

	Asset updateAssetDes(Integer aid, String assetdes);

	Asset updateAssetQuantity(Integer aid, Integer assetquan);

	Asset updateAssetStatus(Integer aid, String assetstatus);

	List<Asset> getAllAsset();

	AssetAllocation raiseAllocation(AssetAllocation assetallocation);

	List<AssetAllocation> getAllAssetAllocation();

	Boolean setStatus(Integer allocationid, String status);

	String viewStatus(Integer allocationid);
}
