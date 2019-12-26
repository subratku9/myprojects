package com.capgemini.hibernate.services;
import java.util.List;

import com.capgemini.hibernate.beans.Asset;
import com.capgemini.hibernate.beans.AssetAllocation;
import com.capgemini.hibernate.beans.Employee;
import com.capgemini.hibernate.beans.UserMaster;
import com.capgemini.hibernate.dao.Dao;
import com.capgemini.hibernate.dao.DaoImpl;

public class ServicesImpl implements Services {
	
	Dao dao = new DaoImpl();

	public UserMaster loginService(Integer userid, String password) {

		return dao.login(userid, password);
	}

	public Asset addAssetService(Asset asset) {
		return dao.addAsset(asset);
	}

	public Asset removeAssetService(Integer aid) {

		return dao.removeAsset(aid);
	}

	
	public List<Asset> getAllAssetService() {

		return dao.getAllAsset();
	}

	
	public AssetAllocation raiseAllocationService(AssetAllocation assetallocation) {
		return dao.raiseAllocation(assetallocation);
	}

	public List<AssetAllocation> getAllAssetAllocationService() {

		return dao.getAllAssetAllocation();
	}

	public String viewStatusService(Integer allocationid) {

		return dao.viewStatus(allocationid);
	}

	public Asset updateAssetNameService(Integer aid, String assetname) {

		return dao.updateAssetName(aid, assetname);
	}

	public Asset updateAssetDesService(Integer aid, String assetdes) {

		return dao.updateAssetDes(aid, assetdes);
	}

	public Asset updateAssetQuantityService(Integer aid, Integer assetquan) {

		return dao.updateAssetQuantity(aid, assetquan);
	}

	public Asset updateAssetStatusService(Integer aid, String assetstatus) {

		return dao.updateAssetStatus(aid, assetstatus);
	}

	public Boolean setStatusService(Integer allocationid, String status) {

		return dao.setStatus(allocationid, status);
	}

}

