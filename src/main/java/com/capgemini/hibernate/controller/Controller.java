package com.capgemini.hibernate.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.hibernate.beans.Asset;
import com.capgemini.hibernate.beans.AssetAllocation;
import com.capgemini.hibernate.beans.Employee;
import com.capgemini.hibernate.beans.UserMaster;
import com.capgemini.hibernate.exceptions.ValidationException;
import com.capgemini.hibernate.services.Services;
import com.capgemini.hibernate.services.ServicesImpl;
import com.capgemini.hibernate.validations.Validation;

public class Controller {
	public static void main(String[] args) {
		Services service = new ServicesImpl();
		Scanner sc = new Scanner(System.in);
		Validation validate = new Validation();
		System.out.println("----------------WELCOME TO ASSET MANAGEMENT SYSTEM-----------------------------");
		
		while (true) {
			System.out.println("***************************************************");
			System.out.println("\t\t Login Here");
			System.out.println("Enter User Id");
			Integer userid = sc.nextInt();
			
			System.out.println("Enter  UserPassword");
			String password = sc.next();
			UserMaster usermaster = service.loginService(userid, password);
			
			if (usermaster != null) {
				System.out.println("welcome");
				boolean y = true;
				
				while (y == true) {
					if (usermaster.getUsertype().equalsIgnoreCase("admin")) {
						System.out.println("Admin operation");
						System.out.println("press 1 to Add asset");
						System.out.println("press 2 to Remove asset");
						System.out.println("press 3 to Update asset");
						System.out.println("press 4 to View all asset");
						System.out.println("press 5 to View all allocation request");
						System.out.println("press 6 to Set allocation status");
						System.out.println("press 7 to logout");
						System.out.println("*******************************");
						Integer choice = sc.nextInt();
						switch (choice) {
						case 1:
							Asset assset = new Asset();
							System.out.println("Enter asset id");
							String assetid = sc.next();
							Boolean b = validate.numValidation(assetid);
							while (b) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter the number");
									System.out.println("enter again");
									assetid = sc.next();
									if (validate.numValidation(assetid)) {
									}
								}
							}
							assset.setAssetid(Integer.parseInt(assetid));
							System.out.println("Enter the Asset name ");
							String assetname = sc.next();
							Boolean b1 = validate.numValidation(assetname);
							while (b1) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter in string format");
									System.out.println("enter again");
									assetname = sc.next();
									if (!validate.numValidation(assetname)) {
									}
								}
							}
							assset.setAssetname(assetname);
							System.out.println("Enter Asset description");
							assset.setAssetdes(sc.next());
							System.out.println("Enter Asset quantity");
							String assetquantity = sc.next();
							Boolean b2 = validate.numValidation(assetquantity);
							while (b2) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter the number");
									System.out.println("enter it again");
									assetquantity = sc.next();
									if (validate.numValidation(assetquantity)) {
									
									}
								}
							}
							assset.setQuantity(Integer.parseInt(assetquantity));
							System.out.println("Enter asset status ");
							String status = sc.next();
							Boolean b3 = validate.numValidation(status);
							while (b3) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter in string format");
									System.out.println("enter again");
									status = sc.next();
									if (!validate.numValidation(status)) {
										
									}
								}
							}
							assset.setStatus(status);
							System.out.println("Added asset :" + service.addAssetService(assset));
							break;
						case 2:
							System.out.println("enter the asset id you want to remove");
							Asset asset1 = new Asset();
							String assetid1 = sc.next();
							Boolean b4 = validate.numValidation(assetid1);
							while (b4) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter number");
									System.out.println("enter again");
									assetid1 = sc.next();
									if (validate.numValidation(assetid1)) {
										
									}
								}
							}
							asset1 = service.removeAssetService(Integer.parseInt(assetid1));
							System.out.println("removed asset is :" + asset1);
							break;

						case 3:
							System.out.println("enter the asset id you want to update");
							String assetid2 = sc.next();
							Boolean b5 = validate.numValidation(assetid2);
							while (b5) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter number");
									System.out.println("enter again");
									assetid2 = sc.next();
									if (validate.numValidation(assetid2)) {
										
									}
								}
							}
							System.out.println("To Update asset");
							System.out.println("press 1 to Update asset name :");
							System.out.println("press 2 to Update asset description :");
							System.out.println("press 3 to Update asset quantity :");
							System.out.println("press 4 to Update asset status :");
							String assetchoice = sc.next();
							Boolean b10 = validate.numValidation(assetchoice);
							while (b10) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter number");
									System.out.println("enter again");
									assetchoice = sc.next();
									if (validate.numValidation(assetchoice)) {
										
									}
								}
							}
							switch (Integer.parseInt(assetchoice)) {
							case 1:
								System.out.println("Enter asset name you want to update :");
								String updatedassetname = sc.next();
								System.out.println("Updated asset name :"
										+ service.updateAssetNameService(Integer.parseInt(assetid2), updatedassetname));
								break;

							case 2:
								System.out.println("Enter asset description you want to update :");
								String updatedassetdes = sc.next();
								System.out.println("Updated asset description :"
										+ service.updateAssetDesService(Integer.parseInt(assetid2), updatedassetdes));
								break;

							case 3:
								System.out.println("Enter asset quantity you want to update :");
								Integer updatedassetquantity = sc.nextInt();
								System.out.println("Updated asset quantity :" + service
										.updateAssetQuantityService(Integer.parseInt(assetid2), updatedassetquantity));
								break;

							case 4:
								System.out.println("Enter asset status you want to update :");
								String updatedassetstatus = sc.next();
								System.out.println("Updated asset status :" + service
										.updateAssetStatusService(Integer.parseInt(assetid2), updatedassetstatus));
								break;

							}
							break;
						case 4:
							System.out.println("Assets :");
							List list = service.getAllAssetService();
							Iterator iterator = list.iterator();
							while (iterator.hasNext()) {
								System.out.println(iterator.next());
							}
							break;
						case 5:
							List list1 = service.getAllAssetAllocationService();
							Iterator iterator1 = list1.iterator();
							while (iterator1.hasNext()) {
								System.out.println(iterator1.next());
							}
							break;
						case 6:
							System.out.println("Enter allocation id to set status");
							String allocationid = sc.next();
							Boolean b6 = validate.numValidation(allocationid);
							while (b6) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter number");
									System.out.println("enter again");
									allocationid = sc.next();
									if (validate.numValidation(allocationid)) {
										
									}
								}
							}
							Integer allocation_id = Integer.parseInt(allocationid);
							System.out.println("Enter status");
							String assetstatus = sc.next();
							Boolean app = validate.numValidation(assetstatus);
							while (app) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter in string format");
									System.out.println("enter again");
									assetstatus = sc.next();
									if (!validate.numValidation(assetstatus)) {
									}
								}
							}
							if (service.setStatusService(allocation_id, assetstatus)) {
								System.out.println("status changed");
							} else {
								System.out.println("status not changed");
							}
							break;

						case 7:
							y = false;
							System.out.println("Admin logged out successfully");
							break;
						default:
							System.out.println("enter valid number");
							break;
						}// end of switch
					} // end of (admin)

					else {
						usermaster.getUsertype().equalsIgnoreCase("manager");
						System.out.println("Manager operation");
						System.out.println("press 1 for Raise Allocation ");
						System.out.println("press 2 for View Status");
						System.out.println("press 3 to logout");
						System.out.println("*******************************");
						Integer choice1 = sc.nextInt();
						switch (choice1) {

						case 1:
							AssetAllocation assetallocation = new AssetAllocation();
							assetallocation.setAllocationid(new Random().nextInt(3000));
							System.out.println("Enter Asset id ");
							String assetid = sc.next();
							Boolean b6 = validate.numValidation(assetid);
							while (b6) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter number again");
									assetid = sc.next();
									if (validate.numValidation(assetid)) {
									}
								}
							}
							assetallocation.setAssetid(Integer.parseInt(assetid));
							System.out.println("Enter employee number");
							String empno = sc.next();
							Boolean b7 = validate.numValidation(empno);
							while (b7) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter number");
									System.out.println("enter again");
									empno = sc.next();
									if (validate.numValidation(empno)) {
									}
								}
							}
							assetallocation.setEmpno(Integer.parseInt(empno));
							System.out.println("Enter allocation date");
							String date = sc.next();
							Boolean b8 = validate.dateValidation(date);
							while (b8) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter in DD/MM/YYYY format");
									System.out.println("enter again");
									date = sc.next();
									if (validate.dateValidation(date)) {
									}
								}
							}
							assetallocation.setAllocationdate(date);
							System.out.println("Enter release date ");
							String releasedate = sc.next();
							Boolean b9 = validate.dateValidation(releasedate);
							while (b9) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter in DD/MM/YYYY format");
									System.out.println("enter again");
									releasedate = sc.next();
									if (validate.dateValidation(releasedate)) {
									}
								}
							}
							assetallocation.setReleasedate(releasedate);
							System.out.println("Enter quantity");
							String quantity = sc.next();
							Boolean b10 = validate.numValidation(quantity);
							while (b10) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter number");
									System.out.println("enter again");
									quantity = sc.next();
									if (validate.numValidation(quantity)) {
									}
								}
							}
							assetallocation.setQuantity(Integer.parseInt(quantity));
							System.out.println(
									"Raised allocation request :" + service.raiseAllocationService(assetallocation));
							System.out.println("Allocated allocation id :" + assetallocation.getAllocationid());
							break;
						case 2:
							System.out.println("enter the allocation id");
							String allocationid = sc.next();
							Boolean b11 = validate.numValidation(allocationid);
							while (b11) {
								try {
									throw new ValidationException();
								} catch (ValidationException e1) {
									System.out.println("please enter number");
									System.out.println("enter again");
									allocationid = sc.next();
									if (validate.numValidation(allocationid)) {
										System.out.println("jump6");
									}
								}
							}
							System.out.println(service.viewStatusService(Integer.parseInt(allocationid)));
							break;
						case 3:
							y = false;
							System.out.println("Manager logged out successfully");
							break;
						default:
							System.out.println("enter valid number");
							break;
						}// end of switch(choice1)
					} // end of (manager)
				} // end of while(y)
			} // end of if(usermaster!=null)
			else {
				System.out.println("invalid Login!!");
			}
		}

	}// end of main
}// end of class
