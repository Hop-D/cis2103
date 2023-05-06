package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Package extends Menu{
	private ArrayList<Item> packageitems;
	
	public Package(String id, String name, float price, LocalDateTime dateAdded, LocalDateTime dateUpdated, ArrayList<Item> packageitems) {
		super(id, Menu.PACKAGE_TYPE, name, price, dateAdded, dateUpdated);
		this.packageitems = packageitems;
	}
	
	public Package(String id, String name, float price) {
		super(id, Menu.PACKAGE_TYPE, name, price);
	}

	public ArrayList<Item> getPackageitems() {
		return packageitems;
	}

	public void setPackageitems(ArrayList<Item> packageitems) {
		this.packageitems = packageitems;
	}

	@Override
	public void updateMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String concatDets() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumberOfItems() {
		return this.packageitems.size();
	}
	
}
