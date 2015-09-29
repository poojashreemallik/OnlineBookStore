package org.ndt.obs.entity;

public class CartItem
{
	private int isbn;
	private String title;
	private float price;
	private Author author;
	private int qtyOrdered;
	
	
	public CartItem(int isbn, String title, float price
			) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		/*this.author = author;
		this.qtyOrdered = qtyOrdered;*/
	}
	
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	
	

}
