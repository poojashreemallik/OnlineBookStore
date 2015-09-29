package org.ndt.obs.entity;

public class Author 
{
	private String authorName;
	private String mailID;
	
	
	public Author(String authorName, String mailID) {
		super();
		this.authorName = authorName;
		this.mailID = mailID;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getMailID() {
		return mailID;
	}
	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
	
	

}
