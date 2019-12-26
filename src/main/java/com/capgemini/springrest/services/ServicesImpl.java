package com.capgemini.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springrest.beans.Asset;
import com.capgemini.springrest.beans.AssetAllocation;
import com.capgemini.springrest.beans.AssetStatus;
import com.capgemini.springrest.beans.Employee;
import com.capgemini.springrest.beans.UserMaster;
import com.capgemini.springrest.dao.DAO;

@Service
public class ServicesImpl implements Services {
	
	@Autowired
	private DAO dao;

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

	public AssetStatus viewStatusService(Integer allocationid) {
		return dao.viewStatus(allocationid);
	}
	
	public AssetStatus setStatusService(Integer allocationid, String status) {

		return dao.setStatus(allocationid, status);
	}

@Override
public Asset updateAssetService( Asset asu) {

	return dao.updateAsset(asu);
}

}
