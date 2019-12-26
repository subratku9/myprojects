package com.capgemini.springrest.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column
	private Integer empno;
	@Column
	private String ename;
	@Column
	private String job;
	@Column
	private Integer mgrno;
	@Column
	private String hiredate;
	@Column
	private Integer deptid;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgrno() {
		return mgrno;
	}
	public void setMgrno(Integer mgrno) {
		this.mgrno = mgrno;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgrno=" + mgrno + ", hiredate="
				+ hiredate + ", deptid=" + deptid + "]";
	}

}
