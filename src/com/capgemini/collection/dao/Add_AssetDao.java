package com.capgemini.collection.dao;

import java.util.ArrayList;

import com.capgemini.collection.beans.Asset;

public interface Add_AssetDao {

	public Asset addAsset(ArrayList<Asset> al);
	public ArrayList<Asset> modifyAsset(ArrayList<Asset> al);
	
}
