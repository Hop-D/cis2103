package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import exceptions.MenuNotFoundException;
import exceptions.NameExistsInArrayException;
import exceptions.UserNotFoundException;

public class Database {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	private static ArrayList<UserClass> users = new ArrayList<UserClass>();
	private static ArrayList<Menu> menu = new ArrayList<Menu>();
	private static ArrayList<Item> items = new ArrayList<Item>();
	private static ArrayList<Package> pack = new ArrayList<Package>();
	private static ArrayList<Order> orders = new ArrayList<Order>();
	private static ArrayList<Feedbacks> feedback = new ArrayList<Feedbacks>();
	private static ArrayList<Vouchers> vouchers = new ArrayList<Vouchers>();
	private static ArrayList<Invoice> invoice = new ArrayList<Invoice>();

	public Database () throws SQLException {
		conn = null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis2103", "root", "");
        
	}
	//Getters and setters
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public Statement getSt() {
		return st;
	}

	public void setSt(Statement st) {
		this.st = st;
	}

	public PreparedStatement getPst() {
		return pst;
	}

	public void setPst(String string) throws SQLException {
		this.pst = conn.prepareStatement(string);
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs() throws SQLException {
		this.rs = this.pst.executeQuery();
	}

	public static ArrayList<UserClass> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<UserClass> users) {
		Database.users = users;
	}

	public static ArrayList<Item> getItems() {
		return items;
	}

	public static void setItems(ArrayList<Item> items) {
		Database.items = items;
	}
	
	
	//Getters and setters
	
	public static ArrayList<Package> getPack() {
		return pack;
	}
	public static void setPack(ArrayList<Package> pack) {
		Database.pack = pack;
	}
	//Additional codes for database
	public void closeConn() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet executeStatement(String string) throws SQLException {
		this.st = conn.createStatement();
		this.rs = st.executeQuery(string);
		return rs;
	}
	
	
	
	/////////////////////USER////////////////////////////////
	
	//store USERS from database to arraylist
	public static void loadUsersFromDatabase() throws SQLException {
	    Database db = null;
	    UserClass user = null;
	    users.clear();
	    try {
	        db = new Database();
	        ResultSet rs = db.executeStatement("SELECT * FROM user");
	        while (rs.next()) {
	            String id = rs.getString("userID");
	            String userName = rs.getString("name");
	            String password = rs.getString("password");
	            String contact = rs.getString("contactNo");
	            String role = rs.getString("role");
	            Timestamp userCreated = rs.getTimestamp("userCreated");
	            Timestamp userUpdated = rs.getTimestamp("userUpdated");
	            String editedByID = rs.getString("editorID");
	            if(role.equals(UserClass.ADMIN_USER)) {
				    user = new AdminClass(id, userName, password, contact, role, userCreated.toLocalDateTime(), userUpdated.toLocalDateTime(), editedByID);    
				}
				if(role.equals(UserClass.REGULAR_USER)) {
						user = new RegularClass(id, userName, password, contact, role, userCreated.toLocalDateTime(), userUpdated.toLocalDateTime(), editedByID);
				}
	            users.add(user);
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	//add a user
	public static void addUser(UserClass u) throws SQLException, NameExistsInArrayException {
		Database db = null;
		try {
			db = new Database();
			db.setPst("INSERT INTO user (userID, name, password, contactNo, role, userCreated, userUpdated, editorID) \r\n"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			db.getPst().setString(1, u.getId());
			db.getPst().setString(2, nameExist(u.getUserName(), "USER"));
			db.getPst().setString(3, u.getPassword());
			db.getPst().setString(4, u.getContact());
			db.getPst().setString(5, u.getRole());
			db.getPst().setTimestamp(6, Timestamp.valueOf(u.getUserCreated()));
			db.getPst().setTimestamp(7, Timestamp.valueOf(u.getUserUpdated()));
			db.getPst().setString(8, u.getEditedByID());
			db.getPst().executeUpdate();
			
			users.add(u);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static String nameExist(String name, String array) throws NameExistsInArrayException {
		if(array.equals("USER")) {
			for(UserClass n: users) {
				if(name.equals(n.getUserName())) {
					throw new NameExistsInArrayException();
				}
			}
		}else if(array.equals("ITEMS")) {
			for(Item n: items) {
				if(name.equals(n.getName())) {
					throw new NameExistsInArrayException();
				}
			}
		}else if(array.equals("PACKAGE")) {
			for(Package n: pack) {
				if(name.equals(n.getName())) {
					throw new NameExistsInArrayException();
				}
			}
		}
			
		
		return name;
	}
	
	//get a user from array
	public static UserClass getUserByID(String id) throws UserNotFoundException {
		for(UserClass user: users) {
			if(id.equals(user.getId())) {
				return user;
			}
		}
		throw new UserNotFoundException();
	}
	
	public static int getLastUserID(){
		if(users.isEmpty()) {
			return 1;
		}
		return Integer.parseInt(users.get(users.size()-1).getId().substring(1))+1;
	}
	
	// update a user
	public static void updateUser(String id, String username, String password, String contact, String role, String editedByID) throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("UPDATE user SET name = ?, password = ?, contactNo = ?, role = ?, userUpdated = current_timestamp(), editorID = ? WHERE userID = ?");
			db.getPst().setString(1, username);
			db.getPst().setString(2, password);
			db.getPst().setString(3, contact);
			db.getPst().setString(4, role);
			db.getPst().setString(5, editedByID);
			db.getPst().setString(6, id);
			db.getPst().executeUpdate();
			
			for(UserClass user : users) {
				if(id.equals(user.getId())) {
					user.setUserName(username);
					user.setPassword(password);
					user.setContact(contact);
					user.setRole(role);
					user.setUserUpdated(LocalDateTime.now());
					user.setEditedBy(editedByID);
					return;
				}
			}
	    }finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	// remove a user
	public static void removeUser(UserClass user) throws SQLException {
		Database db = new Database();
		try {
			db.setPst("DELETE FROM user WHERE userID = ?");
			db.getPst().setString(1, user.getId());
			db.getPst().executeUpdate();
			
			users.remove(user);
			
		} finally {
			if(db != null) {
				db.closeConn();
			}
		}
	}
	
	
	
	////////////////////MENU////////////////////
	
	public static void loadMenuFromDatabase() throws SQLException {
		Database db = null;
	    menu.clear();
	    try {
	        db = new Database();
	        ResultSet rs = db.executeStatement("SELECT COALESCE(package.packageID, items.itemID) AS id, \r\n"
	        		+ "menu.menuType AS type, \r\n"
	        		+ "COALESCE(package.name, items.name) AS name, \r\n"
	        		+ "COALESCE(package.price, items.price) AS price,\r\n"
	        		+ "COALESCE(package.dateAdded, items.dateAdded) AS dateAdded,\r\n"
	        		+ "COALESCE(package.dateUpdated, items.dateUpdated) AS dateUpdated  \r\n"
	        		+ "menu.menuID  \r\n"
	        		+ "FROM menu\r\n"
	        		+ "LEFT JOIN package ON menu.menuID = package.menuID\r\n"
	        		+ "LEFT JOIN items ON menu.menuID = items.menuID");
	        while (rs.next()) {
	            String id = rs.getString("id");
	            String type = rs.getString("type");
	            String name = rs.getString("name");
	            float price = rs.getFloat("price");
	            Timestamp dateAdded = rs.getTimestamp("dateAdded");
	            Timestamp dateUpdated = rs.getTimestamp("dateUpdated");
	            int menuID = rs.getInt("menuID");
	            if(type.equals(Menu.PACKAGE_TYPE)) {
				    menu.add(new Package(id, name, price, dateAdded.toLocalDateTime(), dateUpdated.toLocalDateTime(), loadPackageItemFromDatabase(id), menuID));    
				}else if(type.equals(Menu.ITEM_TYPE)) {
					menu.add(new Item(id, name, price, dateAdded.toLocalDateTime(), dateUpdated.toLocalDateTime(), menuID));
				}
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static Menu getMenuByID(String id) throws MenuNotFoundException{
		for(Menu m: menu) {
			if(id.equals(m.getId())) {
				return m;
			}
		}
		throw new MenuNotFoundException();
	}
	
	public static void addMenu(String type) throws SQLException {
		Database db = new Database();
		try {
			System.out.println(getLastMenuID());
			db = new Database();
			db.setPst("INSERT INTO menu(menuID, menuType) VALUES(?, ?)");
			db.getPst().setInt(1, getLastMenuID()+1);
			db.getPst().setString(2, type);
			db.getPst().executeUpdate();
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
//	
	public static int getLastMenuID() throws SQLException {
		Database db = new Database();
		int ret = 1;
		try {
			db = new Database();
			ResultSet rs = db.executeStatement("SELECT MAX(menuID) FROM menu");
			
			if(rs.next()) {
				ret = rs.getInt("MAX(menuID)");
			}
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return ret;
	}
	
	public static int getLastItemID(){
		if(items.isEmpty()) {
			return 1;
		}
		return Integer.parseInt(items.get(items.size()-1).getId().substring(1))+1;
	}
	
	public static void loadItemsFromDatabase() throws SQLException {
	    Database db = null;
	    items.clear();
	    try {
	        db = new Database();
	        ResultSet rs = db.executeStatement("Select * FROM items");
	        while (rs.next()) {
	            String id = rs.getString("itemID");
	            String name = rs.getString("name");
	            float price = rs.getFloat("price");
	            Timestamp dateAdded = rs.getTimestamp("dateAdded");
	            Timestamp dateUpdated = rs.getTimestamp("dateUpdated");
	            int menuID = rs.getInt("menuID");
				items.add(new Item(id, name, price, dateAdded.toLocalDateTime(), dateUpdated.toLocalDateTime(), menuID));
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void addItem(Item item) throws SQLException, NameExistsInArrayException {
		Database db = new Database();
		try {
			addMenu(item.getType());
			db = new Database();
			db.setPst("INSERT INTO items (itemID, name, price,  dateAdded, dateUpdated, menuID) \r\n"
					+ "VALUES (?, ?, ?, current_timestamp(), current_timestamp(), ?)");
			db.getPst().setString(1, item.getId());
			db.getPst().setString(2, nameExist(item.getName(), "ITEMS"));
			db.getPst().setFloat(3, item.getPrice());
			db.getPst().setInt(4, getLastMenuID());
			db.getPst().executeUpdate();
			
			items.add(item);
			menu.add(item);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		
	}
	
	
	public static void removeMenu(Item item) throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("DELETE FROM items WHERE itemID = ?");
			db.getPst().setString(1, item.getId());
			db.getPst().executeUpdate();
			
			items.remove(item);
			menu.remove(item);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		
	}
	
	public static void updateItem(String id, String name, float price) throws SQLException, NameExistsInArrayException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("UPDATE items SET name = ?, price = ?, dateUpdated = current_timestamp() WHERE itemID = ?");
			db.getPst().setString(1, name);
			db.getPst().setFloat(2, price);
			db.getPst().setString(3, id);
			db.getPst().executeUpdate();
			
			for(Item item: items) {
				if(id.equals(item.getId())) {
					item.setName(name);
					item.setPrice(price);
					item.setDateUpdated(LocalDateTime.now());
					return;
				}
			}
	    }finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static Item getItemByID(String id) throws MenuNotFoundException {
		for(Item i: items) {
			if(id.equals(i.getId())) {
				return i;
			}
		}
		throw new MenuNotFoundException();
	}
	
	public static Item getItemByName(String name) throws MenuNotFoundException {
		for(Item i: items) {
			if(name.equals(i.getName())) {
				return i;
			}
		}
		throw new MenuNotFoundException();
	}
	
	
	public static void loadPackageFromDatabase() throws SQLException {
	    Database db = null;
	    try {
	    	pack.clear();
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM package");
	        while (rs.next()) {
	            String id = rs.getString("packageID");
	            String name = rs.getString("name");
	            float price = rs.getFloat("price");
	            Timestamp dateAdded = rs.getTimestamp("dateAdded");
	            Timestamp dateUpdated = rs.getTimestamp("dateUpdated");
	            int menuID = rs.getInt("menuID");
				pack.add(new Package(id, name, price, dateAdded.toLocalDateTime(), dateUpdated.toLocalDateTime(), loadPackageItemFromDatabase(id), menuID));
	        }
	    } catch (SQLException e) {
	        throw e;
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
		
	public static void addPackage(Package packag) throws SQLException, NameExistsInArrayException {
		Database db = new Database();
		try {
			addMenu(packag.getType());
			db = new Database();
			db.setPst("INSERT INTO Package (packageID, name, price, count, dateAdded, dateUpdated, menuID) \r\n"
					+ "VALUES (?, ?, ?, ?, current_timestamp(), current_timestamp(), ?)");
			db.getPst().setString(1, packag.getId());
			db.getPst().setString(2, nameExist(packag.getName(), "PACKAGE"));
			db.getPst().setFloat(3, packag.getPrice());
			db.getPst().setInt(4, Integer.parseInt("0"));
			db.getPst().setInt(5, getLastMenuID());
			db.getPst().executeUpdate();
			pack.add(packag);
			menu.add(packag);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void updatePackage(String id, String name, float price, int count) throws SQLException, NameExistsInArrayException {
		Database db = new Database();
		try {
			
			for(Package p: pack) {
				if(id.equals(p.getId())) {
					db = new Database();
					db.setPst("UPDATE package SET name = ?, price = ?, count = ?, dateUpdated = current_timestamp() WHERE packageID = ?");
					db.getPst().setString(1, name);
					db.getPst().setFloat(2, price);
					db.getPst().setFloat(3, count);
					db.getPst().setString(4, id);
					db.getPst().executeUpdate();
					
					p.setName(name);
					p.setPrice(price);
					p.setDateUpdated(LocalDateTime.now());
					return;
				}
			}
			
	    }finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void removePackage(Package p) throws SQLException {
		
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("DELETE FROM package WHERE package.packageID = ?");
			db.getPst().setString(1, p.getId());
			db.getPst().executeUpdate();
			
			removeMenu(p);
			
			pack.remove(p);
			menu.remove(p);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		
	}
	
	public static void  removeMenu(Package packag) throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("DELETE FROM menu WHERE menuID = (SELECT menuID FROM package WHERE packageID = ?)");
			db.getPst().setString(1, packag.getId());
			db.getPst().executeUpdate();
			pack.remove(packag);
			menu.remove(packag);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}

	
	
	public static void addPackageItem(int id, Package p, Item i) throws SQLException {
		Database db = new Database();
		
		try {
			db = new Database();
			db.setPst("INSERT INTO packageitem (packageItemID, quantity, itemID, packageID) VALUES (?, ?, ?, ?)");
			db.getPst().setInt(1, id);
			db.getPst().setInt(2, 1);
			db.getPst().setString(3, i.getId());
			db.getPst().setString(4, p.getId());
			db.getPst().executeUpdate();
			p.getPackageitems().add(i);
			
		} finally {
	        if (db != null) {
	            db.closeConn();
	        }
		}
	}
	
	public static void removePackageItem(Package p, Item i) throws SQLException {
		Database db = new Database();
		
		try {
			db = new Database();
			db.setPst("DELETE FROM packageitem WHERE itemID = ? && packageID = ?");
			db.getPst().setString(1, i.getId());
			db.getPst().setString(2, p.getId());
			db.getPst().executeUpdate();
			p.getPackageitems().remove(i);
		} finally {
	        if (db != null) {
	            db.closeConn();
	        }
		}
	}
	
	public static Package getPackageByID(String id) throws MenuNotFoundException {
		for(Package p: pack) {
			if(id.equals(p.getId())) {
				return p;
			}
		}
		throw new MenuNotFoundException();
	}
	
	public static int getLastPackageID() {
		if(pack.isEmpty()) {
			return 1;
		}
		return Integer.parseInt(pack.get(pack.size()-1).getId().substring(1))+1;
	}
	
	public static int getLastPackageItemID() {
		
		Database db = null;
		int id = 0;
	    try {
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT MAX(packageItemID) FROM packageitem");
	        while (rs.next()) {
	        	id = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return id + 1;
	}
	
	public static ArrayList<Item> loadPackageItemFromDatabase(String idd) {
		ArrayList<Item> packItem = new ArrayList<Item>();
		Database db = null;
		
		try {
			Package temp = Database.getPackageByID(idd);
			db = new Database();
			db.setPst("Select itemID FROM packageitem WHERE packageID = ?");
			db.getPst().setString(1, idd);
		    ResultSet rs = db.getPst().executeQuery();
		    while (rs.next()) {
	            String itemID = rs.getString("itemID");
		    	packItem.add(getItemByID(itemID));
	        }
		    temp.setPackageitems(packItem);
		} catch (SQLException | MenuNotFoundException e) {
	        System.out.println(e.getMessage());
	    }finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return packItem;
	}
	
	public static void loadOrdersFromDatabase() throws SQLException{
		 Database db = null;
		 try {
		   	orders.clear();
		   	db = new Database();
		   	Statement stmt = db.getConn().createStatement();
		   	ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
		    while (rs.next()) {
		    	int id = rs.getInt("orderID");
		        int menuID = rs.getInt("menuID");
		        String orderMethod = rs.getString("orderMethod");
		        String deliveryMethod = rs.getString("deliveryMethod");
		        float total = rs.getFloat("total");
		        orders.add(new Order(id, orderMethod, deliveryMethod, total, loadOrderItems(menuID)));
		    }
		 } finally {
		     if (db != null) {
		    	 db.closeConn();
		     }
		 }
	}
	
	public static ArrayList<Menu> loadOrderItems(int id) throws SQLException{
		Database db = null;
		ArrayList<Menu> oi = new ArrayList<Menu>();
	    try {
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT menuID FROM orderitems WHERE orderID = ?");
	        while (rs.next()) {
	            oi.add(getMenuBymenuID(rs.getInt("menuID")));
	        }
	    } catch (MenuNotFoundException e) {
			e.printStackTrace();
		} finally {
	   
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	    return oi;
	}
	
	public static Menu getMenuBymenuID(int menuID) throws MenuNotFoundException{
		for(Menu m: menu) {
			if(m.getMenuID() == menuID) {
				return m;
			}
		}
		throw new MenuNotFoundException();
	}
	
	public static void addOrder(Order order) throws SQLException {
		Database db = new Database();
		try {
			orders.add(order);
			db = new Database();
			db.setPst("INSERT INTO orders (orderID, orderMethod, deliveryMethod, total) VALUES (?, ?, ?, ?, ?);");
			db.getPst().setInt(1, order.getId());
			db.getPst().setString(2, order.getOrderMethod());
			db.getPst().setString(3, order.getDeliveryMethod());
			db.getPst().setFloat(4, order.getTotal());
			db.getPst().executeUpdate();
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void addOrderItems(Order order, int menuID) throws SQLException {
		Database db = new Database();
		try {
			
			db = new Database();
			db.setPst("INSERT INTO orderitems (orderItemsID, orderID, quantity, notes, menuID) VALUES (?, ?, ?, ?, ?)");
			db.getPst().setInt(1, getNextOIID());
			db.getPst().setString(2, order.getOrderMethod());
			db.getPst().setString(3, order.getDeliveryMethod());
			db.getPst().setFloat(4, order.getTotal());
			db.getPst().setInt(5, menuID);
			db.getPst().executeUpdate();
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static int getNextOIID() throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
		   	Statement stmt = db.getConn().createStatement();
		   	ResultSet rs = stmt.executeQuery("SELECT MAX(orderItemsID) AS nextID FROM orderitems");
		    if (rs.next()) {
		    	return rs.getInt("nextID")+1;
		    }else {
		    	return 1;
		    }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	
	public static ArrayList<Feedbacks> getFeedback() {
		return feedback;
	}
	public static void setFeedback(ArrayList<Feedbacks> feedback) {
		Database.feedback = feedback;
	}
	public static ArrayList<Vouchers> getVouchers() {
		return vouchers;
	}
	public static void setVouchers(ArrayList<Vouchers> vouchers) {
		Database.vouchers = vouchers;
	}
	public static ArrayList<Invoice> getInvoice() {
		return invoice;
	}
	public static void setInvoice(ArrayList<Invoice> invoice) {
		Database.invoice = invoice;
	}

}
