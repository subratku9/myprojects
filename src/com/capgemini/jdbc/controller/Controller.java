package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.beans.UserBean;
import com.capgemini.jdbc.dao.AssetManagementDAOImpl;
import com.capgemini.jdbc.factory.AssetManagementFactory;

public class Controller {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int request;
		AssetManagementDAOImpl dao = AssetManagementFactory.getAssetManagementDAOImpl();
		UserBean user = new UserBean();
		System.out.println("----------------WELCOME TO ASSET MANAGEMENT SYSTEM-----------------------------");
		while (true) {
			System.out.println("Enter the UserId:");
			String userId = sc.next();
			System.out.println("Enter the User Password:");
			String password = sc.next();
			user = dao.login(userId, password);
			boolean logout = true;
			int c=0;
			while (logout == true && user!=null) {
				if (user.getUserType().equals("Admin")) {
					c=1;
					System.out.println("ADMIN PORTAL");
					System.out.println("*****************************");
					System.out.println("Welcome " + user.getUserName());
					System.out.println("1.To Add OR Modify Assetpress 1");
					System.out.println("2.To  View OR Perform operation on raised request press 2");
					System.out.println("3.To Logout press 3");
					request = sc.nextInt();
					switch (request) {
					case 1:
						System.out.println("To Add press 1:");
						System.out.println("To Modify press 2:");
						int n = sc.nextInt();
						boolean k = dao.add_modify_asset(n);
						if (k == true && n == 1) {
							System.out.println("Asset Added Successfully");
						} else if (k == true && n == 2) {
							System.out.println("Asset Modified Successfully");
						} else {
							System.out.println("Wrong Input");
						}
						break;
					case 2:
						System.out.println("To operate on request 1:");
						System.out.println("ToView press 2:");
						int ch =sc.nextInt();
						if(ch==1) {
						dao.requestOperation();
						}
						else if(ch==2){
							dao.displayOperatedRequest();
						}
						else {
							System.out.println("Wrong Input");
						}
						break;
					case 3:
						System.out.println("Logged Out Successfully");
						logout = false;
						user=null;
						break;
					default:
						break;
					}

				} // end of Admin if block
				else if (user.getUserType().equals("Manager")) {
					c=1;
					System.out.println("MANAGER PORTAL");
					System.out.println("*****************************");
					System.out.println("Welcome " + user.getUserName());
					System.out.println("*****************************");
					System.out.println("1.To Raise a request press 1");
					System.out.println("2.To View raised request press 2");
					System.out.println("3.To Logout press 3");
					request = sc.nextInt();
					switch (request) {
					case 1:
						System.out.println("Enter Asset Id");
						int asId = sc.nextInt();
						System.out.println("Enter Employee Id");
						int empId = sc.nextInt();
						System.out.println("Enter Allocation Date");
						String aldate = sc.next();
						System.out.println("Enter Release Date");
						String reldate = sc.next();
						boolean check = dao.assetAllocateRequest(asId, empId, aldate, reldate);
						if (check == false)
							System.out.println("Wrong Asset Id OR Employee No");
						else {
							System.out.println("Request sent successfully");
						}
						break;
					case 2:
						System.out.println("Status of Asset Requested");
						dao.displayAssetStatus();
						break;
					case 3:
						logout = false;
						System.out.println("Logged Out Successfully");
						break;
					default:
						System.out.println("Wrong Input No Such options !!!!!!");
						break;
					}// end of manager switch option

				} // end of Manager elseif block
				
			} // end of logout block
			if(user==null&&c==0) {
				System.out.println("Wrong Credentials");
				logout = false;
			} // end of user=null else block
		} // End of while Loop
	}// End of main()
}// End of class
