package com.capgemini.collection.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.capgemini.collection.beans.Asset_Allocation;


public class Request_ScreenDaoImpl implements Request_ScreenDao {

	@Override
	public void displayUpdated_Request(ArrayList<Asset_Allocation> al) {

Iterator<Asset_Allocation> it = al.iterator();
		
		while (it.hasNext()) {
			Asset_Allocation asset_Allocation = (Asset_Allocation) it.next();
			System.out.println("Allocation Id: " + asset_Allocation.getAllocationId());
			System.out.println("Asset Name: " + asset_Allocation.getAssetId());
			System.out.println("Employee No: " + asset_Allocation.getEmpId());
			System.out.println("Allocation Date: " + asset_Allocation.getAllocateDate());
			System.out.println("Release Date: " + asset_Allocation.getReleaseDate());
			System.out.println("*****************");
		}
	}
}
	
