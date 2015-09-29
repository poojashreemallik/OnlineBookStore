package org.ndt.obs.entity;

	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	 
	
	public class Cart {
	 
	   private List<CartItem> cart;  
	   
	   public Cart() {
	      cart = new ArrayList<CartItem>();
	   }
	 
	   
	   //public void add(int id, String title,  float price) {
	    public void add(CartItem newItem){ 
	      Iterator<CartItem> iter = cart.iterator();
	      while (iter.hasNext()) {
	         CartItem item = iter.next();
	         /*if (item.getIsbn() == id) {
	            
	            item.setQtyOrdered(item.getQtyOrdered() + qtyOrdered);
	            return;
	         }*/
	      }
	      
	      //cart.add(new CartItem(id, title, price));
	      cart.add(newItem);
	   }
	 
	   
	   public boolean update(int id, int newQty) {
	      Iterator<CartItem> iter = cart.iterator();
	      while (iter.hasNext()) 
	      {
	         CartItem item = iter.next();
	         if (item.getIsbn() == id)
	         {
	            
	            item.setQtyOrdered(newQty);
	            return true;
	         }
	      }
	      return false;
	   }
	 
	   
	   public void remove(int id) {
		   System.out.println(id);
	      Iterator<CartItem> iter = cart.iterator();
	      while (iter.hasNext()) {
	         CartItem item = iter.next();
	         if (item.getIsbn() == id) {
	            cart.remove(item);
	            return;
	         }
	      }
	   }
	 
	   
	   public int size() {
	      return cart.size();
	   }
	 
	   
	   public boolean isEmpty() {
	      return size() == 0;
	   }
	 
	   
	   public List<CartItem> getItems() {
	      return cart;
	   }
	 
	   
	   public void clear() {
	      cart.clear();
	   }

}
