package model;

import java.time.LocalDateTime;

public class Items {
	private int id;
	private String name;
	private float price;
	private int count;
	private LocalDateTime itemAdded;
	private LocalDateTime itemUpdated;
	private UserClass modifiedBy;
	
	public Items(String name, float price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public Items(int id, String name, float price, int count, LocalDateTime itemAdded, LocalDateTime itemUpdated, UserClass modified) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.itemAdded = itemAdded;
		this.itemUpdated = itemUpdated;
		this.modifiedBy = modifiedBy;
	}
	
	public int getId() {
		return id;
	}
	public int setId(int id) {
		java.util.ArrayList<Items> items = Database.getItems();
		return items.get(items.size()-1).getId()+1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public LocalDateTime getItemAdded() {
		return itemAdded;
	}
	public void setItemAdded(LocalDateTime itemAdded) {
		this.itemAdded = itemAdded;
	}
	public LocalDateTime getItemUpdated() {
		return itemUpdated;
	}
	public void setItemUpdated(LocalDateTime itemUpdated) {
		this.itemUpdated = itemUpdated;
	}
	public UserClass getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(UserClass modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
