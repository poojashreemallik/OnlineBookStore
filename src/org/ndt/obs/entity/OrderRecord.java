package org.ndt.obs.entity;

public class OrderRecord 
{
	private String username;
	private float totalAmt;
	
	public OrderRecord(String username, float totalAmt) {
		super();
		this.username = username;
		this.totalAmt = totalAmt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}
	
}
