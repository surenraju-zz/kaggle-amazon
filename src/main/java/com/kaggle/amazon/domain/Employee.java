package com.kaggle.amazon.domain;

public class Employee {
	private double action;
    private double resource;
    private double mgrId;
    private double roleRollup1;
    private double roleRollup2;
    private double roleDeptname;
    private double roleTitle;
    private double roleFamilyDesc;
    private double roleFamily;
    private double roleCode;
	
	public double getAction() {
		return action;
	}
	public void setAction(double action) {
		this.action = action;
	}
	public double getResource() {
		return resource;
	}
	public void setResource(double resource) {
		this.resource = resource;
	}
	public double getMgrId() {
		return mgrId;
	}
	public void setMgrId(double mgrId) {
		this.mgrId = mgrId;
	}
	public double getRoleRollup1() {
		return roleRollup1;
	}
	public void setRoleRollup1(double roleRollup1) {
		this.roleRollup1 = roleRollup1;
	}
	public double getRoleRollup2() {
		return roleRollup2;
	}
	public void setRoleRollup2(double roleRollup2) {
		this.roleRollup2 = roleRollup2;
	}
	public double getRoleDeptname() {
		return roleDeptname;
	}
	public void setRoleDeptname(double roleDeptname) {
		this.roleDeptname = roleDeptname;
	}
	public double getRoleTitle() {
		return roleTitle;
	}
	public void setRoleTitle(double roleTitle) {
		this.roleTitle = roleTitle;
	}
	public double getRoleFamilyDesc() {
		return roleFamilyDesc;
	}
	public void setRoleFamilyDesc(double roleFamilyDesc) {
		this.roleFamilyDesc = roleFamilyDesc;
	}
	public double getRoleFamily() {
		return roleFamily;
	}
	public void setRoleFamily(double roleFamily) {
		this.roleFamily = roleFamily;
	}
	public double getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(double roleCode) {
		this.roleCode = roleCode;
	}
    
	@Override
    public String toString() {
        return action + "," + resource + "," + mgrId + "," + roleRollup1 + "," + roleRollup2 + "," + roleDeptname + "," + roleTitle + "," + roleFamilyDesc + "," +roleFamily + "," + roleCode;
    }


}
