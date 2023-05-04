package model;

import java.time.LocalDateTime;

public class Item {

	private int id;
	private String name;
	private float price;
	private int count;
	private LocalDateTime dateAdded;
	private LocalDateTime dateUpdated;
	
	public Item(int id, String name, float price, int count, LocalDateTime dateAdded, LocalDateTime dateUpdated) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
		this.dateAdded = dateAdded;
		this.dateAdded = dateUpdated;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

//	 private static int setId() {
//		java.util.ArrayList<Item> items = Database.getItems();
//		return items.get(items.size()-1).getId()+1;
//	}

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

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	

}
