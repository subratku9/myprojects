package com.capgemini.springboot.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asset_allocation")
public class AssetAllocation {
	@Id
	@Column
	private Integer allocationid;
	@Column
	private Integer assetid;
	@Column
	private Integer empno;
	@Column
	private String allocationdate;
	@Column
	private String releasedate;
	
	public Integer getAllocationid() {
		return allocationid;
	}

	public void setAllocationid(Integer allocationid) {
		this.allocationid = allocationid;
	}

	public Integer getAssetid() {
		return assetid;
	}

	public void setAssetid(Integer assetid) {
		this.assetid = assetid;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getAllocationdate() {
		return allocationdate;
	}

	public void setAllocationdate(String allocationdate) {
		this.allocationdate = allocationdate;
	}

	public String getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}

	@Override
	public String toString() {
		return "AssetAllocation [allocationid=" + allocationid + ", assetid=" + assetid + ", empno=" + empno
				+ ", allocationdate=" + allocationdate + ", releasedate=" + releasedate	+ "]";
	}

}
