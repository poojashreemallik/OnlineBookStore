package org.ndt.obs.entity;

public class OrderItem 
{
	private String title;
	private int isbn;
	private float price;
	
	public OrderItem(String title, int isbn, float price) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
