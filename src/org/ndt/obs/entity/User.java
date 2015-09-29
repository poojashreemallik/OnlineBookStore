package org.ndt.obs.entity;

public class User
{
	private String username;
	private String password;
	private String mailid;
	private String city;
	private String state;
	private long phNo;
	
	
	public User(String username, String password, String mailid, String city,
			String state, long phNo) {
		super();
		this.username = username;
		this.password = password;
		this.mailid = mailid;
		this.city = city;
		this.state = state;
		this.phNo = phNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}
	

}
