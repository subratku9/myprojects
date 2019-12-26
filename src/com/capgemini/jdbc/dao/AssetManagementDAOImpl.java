package com.capgemini.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.jdbc.beans.UserBean;

public class AssetManagementDAOImpl implements AssetManagementDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet resultSet, resultSet1 = null;
	UserBean userBean = new UserBean();
	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3 = null;
	String query, query1, query2, query3;
	Scanner sc = new Scanner(System.in);

	public AssetManagementDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			String dburl = "jdbc:mysql://localhost:3306/cg_ams_jdbc_db";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(dburl, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public UserBean login(String id, String password) {
		query = "select * from user_master where userId like ? and userPassword like ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				userBean.setUserName(resultSet.getString(2));
				userBean.setUserType(resultSet.getString(4));
				return userBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("rror");
			// e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean assetAllocateRequest(int assetId, int empId, String allocateDate, String releaseDate) {
		query = "select * from asset where assetId = ?";
		query1 = "select * from employee where empno = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt1 = conn.prepareStatement(query1);
			pstmt.setInt(1, assetId);
			pstmt1.setInt(1, assetId);
			resultSet = pstmt.executeQuery();
			resultSet1 = pstmt1.executeQuery();
			if (resultSet.next() && resultSet1.next()) {
				Random rand = new Random();
				int rand_int1 = rand.nextInt(1000);
				query2 = "insert into asset_allocation values(?,?,?,?,?)";
				query3 = "insert into asset_status values(?,?,?,?)";
				pstmt2 = conn.prepareStatement(query2);
				pstmt2.setInt(1, rand_int1);
				pstmt2.setInt(2, assetId);
				pstmt2.setInt(3, empId);
				pstmt2.setString(4, allocateDate);
				pstmt2.setString(5, releaseDate);
				pstmt2.executeUpdate();
				pstmt3 = conn.prepareStatement(query3);
				pstmt3.setInt(1, rand_int1);
				pstmt3.setInt(2, assetId);
				pstmt3.setInt(3, empId);
				pstmt3.setString(4, "pending");
				pstmt3.executeUpdate();
				return true;
			} // end of if validation of assetid and empid block
			else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("wrong details");
			e.printStackTrace();
		}
		return false;
	}// end of manager request raised

	@Override
	public boolean add_modify_asset(int i) {
		if (i == 1) {
			System.out.println("Enter Id");
			int id = sc.nextInt();
			System.out.println("Enter Name");
			String name = sc.next();
			System.out.println("Enter Des");
			String des = sc.next();
			System.out.println("Enter Quantity");
			int quantity = sc.nextInt();
			System.out.println("Enter Avaibility");
			String avaibility = sc.next();
			query = "select * from asset where assetId = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, id);
				resultSet = pstmt.executeQuery();
				if (!resultSet.next()) {
					query1 = "insert into asset values(?,?,?,?,?)";
					pstmt1 = conn.prepareStatement(query1);
					pstmt1.setInt(1, id);
					pstmt1.setString(2, name);
					pstmt1.setString(3, des);
					pstmt1.setInt(4, quantity);
					pstmt1.setString(5, avaibility);
					pstmt1.executeUpdate();
					return true;
				} // end of inner if
				else {
					return false;
				}
			} // end of try
			catch (Exception e) {
				e.printStackTrace();
				return false;
			} // end of catch
		} // end of outer if
		else if (i == 2) {
			System.out.println("Enter Asset Id to be modified");
			int id = sc.nextInt();
			query = "update asset set assetName = ? ,assetDes = ? ,Quantity = ? ,Status = ?  where assetId = ? ";
			try {
				pstmt = conn.prepareStatement(query);
				System.out.println("Name");
				pstmt.setString(1, sc.next());
				System.out.println("Description");
				pstmt.setString(2, sc.next());
				System.out.println("Quantity");
				pstmt.setInt(3, sc.nextInt());
				System.out.println("Status");
				pstmt.setString(4, sc.next());
				System.out.println("ID to be modified");
				pstmt.setInt(5, id);
				pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}

	}// end of add_modify_asset()

	@Override
	public void requestOperation() {
		query = "select* from asset_status where status like ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "pending");
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				int allocationId = resultSet.getInt(1);
				System.out.println("Allocation ID: " + resultSet.getInt(1));
				System.out.println("Asset Id: " + resultSet.getInt(2));
				System.out.println("Emp No: " + resultSet.getInt(3));
				System.out.println("Press '1' to accept '2' to reject '3' to continue to next request");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("allocation success");
					query2 = "update asset_status set status = ? where allocationId=? ";
					pstmt1 = conn.prepareStatement(query2);
					pstmt1.setString(1, "allocated");
					pstmt1.setInt(2, allocationId);
					pstmt1.executeUpdate();
					break;
				case 2:
					System.out.println("unallocation success");
					query2 = "update asset_status set status = ? where allocationId=? ";
					pstmt1 = conn.prepareStatement(query2);
					pstmt1.setString(1, "unallocated");
					pstmt1.setInt(2, allocationId);
					pstmt1.executeUpdate();
					break;
				case 3:
					continue;
				default:
					System.out.println("Wrong Input");
					break;
				}// end of switch
			} // end of while
		} // end of try
		catch (SQLException e) {
			e.printStackTrace();
		}

	}// end of requestoperation()

	@Override
	public void displayOperatedRequest() {
		System.out.println("To view allocated asset press 1");
		System.out.println("To view unallocated asset press 2");
		int ch = sc.nextInt();
		if (ch == 1) {
			query = "select * from asset_status where status like ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "allocated");
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					System.out.println("Allocation Id: " + resultSet.getInt(1));
					System.out.println("Asset Id: " + resultSet.getInt(2));
					System.out.println("Employee Id: " + resultSet.getInt(3));
					System.out.println("Status :" + resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end of if ch==1
		else if (ch == 2) {
			query = "select * from asset_status where status like ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "unallocated");
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					System.out.println("Allocation Id: " + resultSet.getInt(1));
					System.out.println("Asset Id: " + resultSet.getInt(2));
					System.out.println("Employee Id: " + resultSet.getInt(3));
					System.out.println("Status :" + resultSet.getString(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void displayAssetStatus() {

		query = "select * from asset_Status";
		try {
			pstmt = conn.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("-----------------------------------");
				System.out.println("Allocation Id: " + resultSet.getInt(1));
				System.out.println("Asset Id: " + resultSet.getInt(2));
				System.out.println("Employee Id: " + resultSet.getInt(3));
				System.out.println("Status :" + resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}// end of class
