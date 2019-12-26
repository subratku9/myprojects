package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.capgemini.collection.beans.Asset;

public class Add_AssetImpl implements Add_AssetDao {

	@Override
	public Asset addAsset(ArrayList<Asset> al) {
		
		Scanner sc = new Scanner(System.in);
		Asset as = new Asset();
		System.out.println("Enter Asset ID: ");
		Integer id = sc.nextInt();
		System.out.println("Enter Asset Name");
		String name = sc.next();
		System.out.println("Enter Quantity: ");
		Integer quant = sc.nextInt();
		System.out.println("Enter Asset Description: ");
		String des = sc.next();
		System.out.println("Avaibility: (Enter Y for Yes & N for No)");
		String avail = sc.next();
		
		
		
		Iterator<Asset> it = al.iterator();
		int count = 0;
		while (it.hasNext()) {
			Asset a = it.next();
			if (id == a.getAssetId()) {
				count = 1;
				break;
			}
		}
		if (count == 1) {
			return null;
		} else {
			as.setAssetId(id);
			as.setAssetName(name);
			as.setAssetDes(des);
			as.setQuantity(quant);
			as.setStatus(avail);
			return as;
		}

	}//end of addasset()

	@Override
	public ArrayList<Asset> modifyAsset(ArrayList<Asset> al) {
		Iterator<Asset> it = al.iterator();

		System.out.println("Enter Asset  ID to be Modified");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		int ch = 0;
		String name;
		String des;
		int quantity;
		String status;

		while (it.hasNext()) {
			Asset a = (Asset) it.next();
			if (id == a.getAssetId()) {
				ch = 1;
				System.out.println("Asset Name " + a.getAssetName() + " to:");
				name = sc.next();
				a.setAssetName(name);
				System.out.println("Asset Des " + a.getAssetDes() + " to:");
				des = sc.next();
				a.setAssetDes(des);
				System.out.println("Asset Quantity " + a.getQuantity() + " to:");
				quantity = sc.nextInt();
				a.setAssetName(name);
				System.out.println("Asset Status " + a.getStatus() + " to:");
				status = sc.next();
				a.setStatus(status);
			}
		}
		if (ch == 0) {
			return null;
		} else {
			return al;
		}

	}

}// End of class
