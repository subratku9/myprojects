package com.capgemini.collection.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.collection.beans.Asset;
import com.capgemini.collection.beans.Asset_Allocation;
import com.capgemini.collection.beans.User_Master;
import com.capgemini.collection.dao.Add_AssetImpl;
import com.capgemini.collection.dao.Asset_AllocationDAOImpl;
import com.capgemini.collection.dao.UserInitializingDAOImpl;
import com.capgemini.collection.dao.LoginDAOImpl;
import com.capgemini.collection.dao.Request_ScreenDaoImpl;
import com.capgemini.collection.factory.AssetManagementFactory;

public class Controller {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Asset> asset = new ArrayList<Asset>();
		ArrayList<User_Master> um = new ArrayList<User_Master>();
		Asset_Allocation as = new Asset_Allocation();

		LoginDAOImpl dao1 = AssetManagementFactory.getloLoginDaoImpl();
		Asset_AllocationDAOImpl dao2 = AssetManagementFactory.getAssetAllocationImpl();
		Add_AssetImpl dao3 = AssetManagementFactory.getAddAssetImpl();
		Request_ScreenDaoImpl dao4 = AssetManagementFactory.getRequest_ScreenDaoImpl();

		ArrayList<Asset_Allocation> al = new ArrayList<Asset_Allocation>();
		ArrayList<Asset_Allocation> pending = new ArrayList<Asset_Allocation>();
		ArrayList<Asset_Allocation> allocated = new ArrayList<Asset_Allocation>();
		ArrayList<Asset_Allocation> unallocated = new ArrayList<Asset_Allocation>();
		ArrayList<Asset_Allocation> insert = new ArrayList<Asset_Allocation>();

		System.out.println("----------------WELCOME TO ASSET MANAGEMENT SYSTEM-----------------------------");

		while (true) {
			System.out.println("***************************************************");
			System.out.println("\t\t Login Here");
			System.out.print("Enter User Name: ");
			String name = sc.next();
			System.out.print("Enter User Password:");
			String pwd = sc.next();

			User_Master u = dao1.login(pwd, name);
			if (u != null) {

				System.out.println("Hello, Mr. " + u.getUserName() + " Logged as a " + u.getUserType());
				System.out.println("____________________________________________________________________");
				if (u.getUserType().equals("Admin")) {
					System.out.println("ADMIN PANEL");
					System.out.println("-------------------");

					int update = 0;
					int select = 0;

					while (update != 3 && update != 4) {
						System.out.println("PRESS 1 FOR ADD & MODIFY ASSET ");
						System.out.println("PRESS 2 FOR VIEW REQUEST");
						System.out.println("PRESS 3 FOR LOGOUT");
						System.out.println("PRESS 4 FOR EXIT PROGRAMME ");
						System.out.println();
						update = sc.nextInt();

						switch (update) {
						case 1:
							System.out.println("PRESS 1 FOR ADD ASSET");
							System.out.println("PRESS 2 FOR MODIFY ASSET");
							select = sc.nextInt();
							if (select == 1) {
								Asset add = dao3.addAsset(asset);
								if (add == null) {
									System.out.println("WRONG INPUT!!! PRESS AGAIN");
								} else {
									asset.add(add);
									System.out.println("ASSET ADDED SUCCESSFULLY");
								}
							} else if (select == 2) {
								ArrayList<Asset> modify = dao3.modifyAsset(asset);
								if (modify == null) {
									System.out.println("WRONG INPUT!!! PRESS AGAIN");
								} else {
									asset = modify;
									System.out.println("ASSET UPDATED SUCCESSFULLY");
								}

							} else
								System.out.println("WRONG INPUT!!! PRESS AGAIN");
							break;
						case 2:
							System.out.println("PRESS 1 FOR PERFORM OPERATION");
							System.out.println("PRESS 2 FOR VIEW REQUESTS");
							select = sc.nextInt();
							if (select == 1) {
								if (pending.isEmpty()) {
									System.out.println("There is No Request For Approve");
								} else {
									System.out.println("Pending Requests");
									System.out.println("Allocation Request Page");
									char input;
									int o;
									Iterator<Asset_Allocation> it = pending.iterator();
									while (it.hasNext()) {
										Asset_Allocation asset_Allocation = (Asset_Allocation) it.next();
										as = asset_Allocation;
										System.out.println("***********************");
										System.out.println("Allocation Id: " + asset_Allocation.getAllocationId());
										System.out.println("Asset Name: " + asset_Allocation.getAssetId());
										System.out.println("Employee No: " + asset_Allocation.getEmpId());
										System.out.println("Allocation Date: " + asset_Allocation.getAllocateDate());
										System.out.println("Release Date: " + asset_Allocation.getReleaseDate());
										System.out.println("To Perform Operation Press y/n");
										input = sc.next().charAt(0);
										if (input == 'y') {
											System.out.println("Press 1 To Accept:");
											System.out.println("Press 2 To Reject:");
											int k = sc.nextInt();
											if (k == 1) {
												asset_Allocation.setAllocateDate();
												asset_Allocation.setReleaseDate();
												asset_Allocation.setAllocationId(new Random().nextInt(10000));

												System.out.println("Asset Id: " + asset_Allocation.getAssetId());
												System.out.println("Employee No: " + asset_Allocation.getEmpId());
												System.out.println(
														"Asset Allocation Date: " + asset_Allocation.getAllocateDate());
												System.out.println(
														"Asset Release Date: " + asset_Allocation.getReleaseDate());
												System.out.println(
														"Asset Allocation Id: " + asset_Allocation.getAllocationId());

												System.out.println("Allocated Successfully");
												allocated.add(asset_Allocation);
												it.remove();

											} else if (k == 2) {
												System.out.println("Rejected Successfully");
												unallocated.add(asset_Allocation);
												it.remove();
											} else {
												System.out.println("Wrong Input");
											}

										} else if (input == 'n') {
											insert.add(asset_Allocation);
										} else {
											System.out.println("Wrong Input");

										}
									}

								}
							} else if (select == 2) {
								System.out.println("To View Allocated / Unallocated press 1/2");
								int press = sc.nextInt();
								switch (press) {
								case 1:
									if (allocated.isEmpty()) {
										System.out.println("No Asset Allocated");
									} else {
										dao4.displayUpdated_Request(allocated);
									}

									break;
								case 2:
									if (unallocated.isEmpty()) {
										System.out.println("Asset Unallocated Empty");
									} else {
										dao4.displayUpdated_Request(unallocated);
									}
									break;
								default:
									System.out.println("Wrong Input");
									break;
								}
							} else {
								System.out.println("wrong  input");
							}
							break;
						case 3:
							System.out.println("LoggedOut Successfully");
							break;

						case 4:
							System.out.println("Programme Exited Successfully");
							System.exit(0);
							break;

						default:
							System.out.println("Wrong Input");
							break;
						}// end of switch
					} // end of while
				} // end of if

				else if (u.getUserType().equals("Manager")) {
					int man_option = 0;
					while (man_option != 3 && man_option != 4) {
						System.out.println("Manager operation");
						System.out.println("To Raise Request Press 1");
						System.out.println("To View Request press 2");
						System.out.println("To Logout press 3");
						System.out.println("To Exit Programme press 4");

						man_option = sc.nextInt();
						switch (man_option) {

						case 1:
							System.out.println("Enter AssetId Number");
							int a = sc.nextInt();
							System.out.println("Enter Employee Number");
							int b = sc.nextInt();

							Asset_Allocation as2 = dao2.allocate_Asset(a, b);
							if (as2 == null)
								System.out.println("Wrong input Enter Asset Id and Employee Number correctly");
							else {

								al.add(as2);
								pending.add(as2);
								System.out.println("REQUESTED SUCCESSFULLY !!!");
							}
							break;
						case 2:
							System.out.println(" \t \t PENDING REQUESTS ARE: ");
							Iterator<Asset_Allocation> it = pending.iterator();
							while (it.hasNext()) {
								Asset_Allocation al1 = it.next();

								System.out.println("AssetId:  " + al1.getAssetId());
								System.out.println("Empno:  " + al1.getEmpId());
							}
							System.out.println(" \t \t Rejected REQUESTS ARE: ");
							it = unallocated.iterator();
							while (it.hasNext()) {
								Asset_Allocation al1 = it.next();

								System.out.println("AssetId:  " + al1.getAssetId());
								System.out.println("Empno:  " + al1.getEmpId());
								System.out.println("Allocation_date:  " + al1.getAllocateDate());
								System.out.println("Release_date():  " + al1.getReleaseDate());
								System.out.println("Asset allocation Id:  " + al1.getAllocationId());
								System.out.println("********************************");
							}
							System.out.println(" \t \t Accepted REQUESTS ARE: ");
							it = allocated.iterator();
							while (it.hasNext()) {
								Asset_Allocation al1 = it.next();

								System.out.println("AssetId:  " + al1.getAssetId());
								System.out.println("Empno:  " + al1.getEmpId());
								System.out.println("Allocation_date:  " + al1.getAllocateDate());
								System.out.println("Release_date():  " + al1.getReleaseDate());
								System.out.println("Asset allocation Id:  " + al1.getAllocationId());
								System.out.println("********************************");
							}
							break;
						case 3:
							System.out.println("YOU SUCCESSFULLY LOGGED-OUT");

							break;
						case 4:
							System.out.println("PROGRAMME EXITED SUCCESSFULLY");
							System.exit(0);
							break;

						default:
							System.out.println("WRONG INPUT!!! PRESS AGAIN");
							break;

						}// end of switch (man_option)
					} // end of manager option
				} // end of else if(manager type)
			} // end of if (u != null)
			else {
				System.out.println("Invalid Cridentials !!!!");
			}
		} // End of while Loop
	}// end of mail
}// end of class
