package com.capgemini.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.beans.Asset;
import com.capgemini.springboot.beans.AssetAllocation;
import com.capgemini.springboot.beans.AssetStatus;
import com.capgemini.springboot.beans.Employee;
import com.capgemini.springboot.beans.UserMaster;
import com.capgemini.springboot.dao.DAO;
import com.capgemini.springboot.dao.DAOImpl;

@Service
public class ServicesImpl implements Services {
	
	@Autowired
	private DAO dao;

	public UserMaster loginService(Integer userid, String password) {

		return dao.login(userid, password);
	}

	public Asset addAssetService(Asset asset) {
		// TODO Auto-generated method stub
		return dao.addAsset(asset);
	}

	public Asset removeAssetService(Integer aid) {

		return dao.removeAsset(aid);
	}

	

	public List<Asset> getAllAssetService() {
		// TODO Auto-generated method stub
		return dao.getAllAsset();
	}

	public Employee addEmployeeService(Employee employee) {

		return dao.addEmployee(employee);
	}

	public AssetAllocation raiseAllocationService(AssetAllocation assetallocation) {
		return dao.raiseAllocation(assetallocation);
	}

	public List<AssetAllocation> getAllAssetAllocationService() {

		return dao.getAllAssetAllocation();
	}

	public AssetStatus viewStatusService(Integer allocationid) {
		// TODO Auto-generated method stub
		return dao.viewStatus(allocationid);
	}

//	public Asset updateAssetNameService(Integer aid, String assetname) {
//
//		return dao.updateAssetName(aid, assetname);
//	}
//
//	public Asset updateAssetDesService(Integer aid, String assetdes) {
//
//		return dao.updateAssetDes(aid, assetdes);
//	}
//
//	public Asset updateAssetQuantityService(Integer aid, Integer assetquan) {
//
//		return dao.updateAssetQuantity(aid, assetquan);
//	}
//
//	public Asset updateAssetStatusService(Integer aid, String assetstatus) {
//
//		return dao.updateAssetStatus(aid, assetstatus);
//	}

	
	public AssetStatus setStatusService(Integer allocationid, String status) {

		return dao.setStatus(allocationid, status);
	}

@Override
public Asset updateAssetService( Asset asu) {
	// TODO Auto-generated method stub
	return dao.updateAsset(asu);
}





}
