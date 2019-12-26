package com.capgemini.collection.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capgemini.collection.beans.Asset;
import com.capgemini.collection.beans.Asset_Allocation;
import com.capgemini.collection.beans.Employee;
import com.capgemini.collection.beans.User_Master;
import com.capgemini.collection.factory.AssetManagementFactory;

public class UserInitializingDAOImpl implements UserInitializingDAO {


	@Override
	public ArrayList<User_Master> users() {

		User_Master u1 = new User_Master();
		User_Master u2 = new User_Master();

		ArrayList<User_Master> ul = new ArrayList<User_Master>();

		u1.setUserId(1);
		u1.setUserName("Subrat");
		u1.setUserPassword("qwerty");
		u1.setUserType("Admin");

		u2.setUserId(2);
		u2.setUserName("Ankit");
		u2.setUserPassword("qwerty");
		u2.setUserType("Manager");

		ul.add(u1);
		ul.add(u2);

		return ul;
	}

	@Override
	public ArrayList<Employee> employees() {

		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e4 = new Employee();

		ArrayList<Employee> em = new ArrayList<Employee>();

		e1.setEmpNo(1);
		e1.setEmpName("Sagar");
		e1.setHireDate("01/01/2019");
		e1.setJob("SA");
		e1.setDeptId(909);
		e1.setDeptName("Analyst");
		
		e2.setEmpNo(2);
		e2.setEmpName("Gourav");
		e2.setHireDate("05/05/2019");
		e2.setJob("SA");
		e2.setDeptId(808);
		e2.setDeptName("Testing");

		e3.setEmpNo(3);
		e3.setEmpName("Mansi");
		e3.setHireDate("03/03/2019");
		e3.setJob("AE");
		e3.setDeptId(707);
		e3.setDeptName("Support");

		e4.setEmpNo(4);
		e4.setEmpName("Khusi");
		e4.setHireDate("09/09/2019");
		e4.setJob("VE");
		e4.setDeptId(606);
		e4.setDeptName("Developer");
		
		em.add(e1);
		em.add(e2);
		em.add(e3);
		em.add(e4);

		return em;
	}

	@Override
	public ArrayList<Asset> assets() {

		Asset a1 = new Asset();
		Asset a2 = new Asset();
		Asset a3 = new Asset();

		ArrayList<Asset> a = new ArrayList<Asset>();

		a1.setAssetId(1);
		a1.setAssetName("HP LapTop");
		a1.setQuantity(5);
		a1.setStatus("Available");
		a1.setAssetDes("I3 processor with windows 10");

		a2.setAssetId(2);
		a2.setAssetName("Zebronics KeyBoard");
		a2.setQuantity(7);
		a2.setStatus("Available");
		a2.setAssetDes("15X7x2 size Large Keyboard");

		a3.setAssetId(3);
		a3.setAssetName("Logitech Mouse");
		a3.setQuantity(10);
		a3.setStatus("Available");
		a3.setAssetDes("M275 Small Mouse");
		
		a.add(a1);
		a.add(a2);
		a.add(a3);

		return a;
	}
}
