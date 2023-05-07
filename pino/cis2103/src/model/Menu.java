package model;

import java.time.LocalDateTime;

public abstract class Menu {
	private String id;
	private String type;
	private String name;
	private float price;
	private LocalDateTime dateAdded;
	private LocalDateTime dateUpdated;
	private int menuID;
	
	public static final String PACKAGE_TYPE = "Package";
	public static final String ITEM_TYPE = "Item";

	public Menu(String id, String type, String name, float price, LocalDateTime dateAdded, LocalDateTime dateUpdated, int menuID) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
		this.dateUpdated = dateUpdated;
		this.menuID = menuID;
	}
	
	public Menu(String id, String type, String name, float price) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
		this.dateAdded = LocalDateTime.now();
		this.dateUpdated = LocalDateTime.now();
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	
	public abstract String concatDets();
	
	public abstract void updateMenu();
	
	
}
