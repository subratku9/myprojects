package com.capgemini.hibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dept_Name")
public class Department {
	@Id
	@Column(name= "Dept_Id")
	private Integer deptid;
	@Column
	private String deptname;

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", deptname=" + deptname + "]";
	}
}
