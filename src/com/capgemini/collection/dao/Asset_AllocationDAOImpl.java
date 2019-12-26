package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.Iterator;

import com.capgemini.collection.beans.Asset;
import com.capgemini.collection.beans.Asset_Allocation;
import com.capgemini.collection.beans.User_Master;
import com.capgemini.collection.factory.AssetManagementFactory;

public class Asset_AllocationDAOImpl implements Asset_AllocationDAO {

	@Override
	public Asset_Allocation allocate_Asset(int as_Id, int emp_Id) {
		ArrayList<Asset_Allocation> al = new ArrayList<Asset_Allocation>();
		Asset_Allocation asset = new Asset_Allocation();
		UserInitializingDAOImpl dao = AssetManagementFactory.getInitializeDAOImpl();
		Iterator<User_Master> it = dao.users().iterator();
		Integer id = (Integer) emp_Id;
		boolean ch = false;
		while(it.hasNext()) {
			User_Master user = it.next();
			if(user.getUserId()==id) {
			ch=true;
			break;
			}
		}
			Iterator<Asset> it1 = dao.assets().iterator();
			Integer id1 = (Integer) as_Id;
			boolean ch1=false;
			if(ch==true) {
			while(it1.hasNext()) {
				Asset user1 = it1.next();
				if(user1.getAssetId()==id1) {
				ch1=true;
				break;
				}
			}
			}
			if(ch1==true) {
				asset.setAssetId(as_Id);
				asset.setEmpId(emp_Id);
				
				al.add(asset);
				return asset;
			}
			else {
				return null;	
			}
		
	}


}
