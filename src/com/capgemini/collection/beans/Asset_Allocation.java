package com.capgemini.collection.beans;

import java.time.LocalDate;

public class Asset_Allocation {

	private int allocationId;
	private int assetId;
	private int empId;
	private LocalDate allocateDate;
	private LocalDate releaseDate;

	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public LocalDate getAllocateDate() {
		return allocateDate;
	}

	public void setAllocateDate() {
		this.allocateDate = LocalDate.now();
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate() {
		this.releaseDate = LocalDate.now().plusDays(2);
	}

}
