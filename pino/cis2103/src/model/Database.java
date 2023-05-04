package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.UserNotFoundException;

public class Database {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	private static ArrayList<UserClass> users = new ArrayList<UserClass>();
	private static ArrayList<Item> items = new ArrayList<Item>();
	private static ArrayList<Package> pack = new ArrayList<Package>();
	
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
	
	//Additional codes for database
	public void closeConn() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet executeStatement(String string) throws SQLException {
		this.st = conn.createStatement();
		this.rs = st.executeQuery(string);
		return rs;
	}
	

	public static void loadUsersFromDatabase() throws SQLException {
	    Database db = null;
	    UserClass user = null;
	    try {
	        db = new Database();
	        ResultSet rs = db.executeStatement("SELECT * FROM users");
	        while (rs.next()) {
	            String id = rs.getString("userID");
	            String userName = rs.getString("userName");
	            String password = rs.getString("password");
	            String contact = rs.getString("contact");
	            String role = rs.getString("usertype");
	            Timestamp userCreated = rs.getTimestamp("userCreated");
	            Timestamp userUpdated = rs.getTimestamp("userUpdated");
	            String editedByID = rs.getString("edited_by");
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
	
	public static void loadItemFromDatabase() throws SQLException {
	    Database db = null;
	    Item item = null;
	    try {
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM item");
	        while (rs.next()) {
	            int id = rs.getInt("itemID");
	            String name = rs.getString("itemName");
	            float price = rs.getFloat("itemPrice");
	            int count = rs.getInt("itemCount");
	            Timestamp itemAdded = rs.getTimestamp("itemUpdated");
	            Timestamp itemUpdated = rs.getTimestamp("userUpdated");
	            item = new Item(id, name, price, count, itemAdded.toLocalDateTime(), itemUpdated.toLocalDateTime());
	            items.add(item);
	        }
	    } catch (SQLException e) {
	        throw e;
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void loadPackageFromDatabase() throws SQLException {
	    Database db = null;
	    Package packag = null;
	    ArrayList<Item> packageItem;
	    try {
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM item");
	        while (rs.next()) {
	            int id = rs.getInt("itemID");
	            String name = rs.getString("itemName");
	            float price = rs.getFloat("itemPrice");
	            int count = rs.getInt("itemCount");
	            Timestamp itemAdded = rs.getTimestamp("itemUpdated");
	            Timestamp itemUpdated = rs.getTimestamp("userUpdated");
	            
	            
	            packag = new Package(id, name, price, count, itemAdded.toLocalDateTime(), itemUpdated.toLocalDateTime(), loadPackageItemFromDatabase(id));
	            pack.add(packag);
	        }
	    } catch (SQLException e) {
	        throw e;
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static ArrayList<Item> loadPackageItemFromDatabase(int packID) throws SQLException {
		ArrayList<Item> packItem = new ArrayList<Item>();
		Database db = null;
		try {
			db = new Database();
			db.setPst("Select * FROM item WHERE packageID = ?");
			db.getPst().setInt(1, packID);
		    ResultSet rs = db.getRs();
		    while (rs.next()) {
	            int id = rs.getInt("itemID");
	            String name = rs.getString("itemName");
	            float price = rs.getFloat("itemPrice");
	            int count = rs.getInt("itemCount");
	            Timestamp itemAdded = rs.getTimestamp("itemUpdated");
	            Timestamp itemUpdated = rs.getTimestamp("userUpdated");
	            packItem.add(new Item(id, name, price, count, itemAdded.toLocalDateTime(), itemUpdated.toLocalDateTime()));
	        }
		} catch (SQLException e) {
	        throw e;
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return packItem;
	}

	public static UserClass getUser(String id) throws UserNotFoundException {
		for(UserClass user: users) {
			if(id.equals(user.getId())) {
				return user;
			}
		}
		throw new UserNotFoundException();
	}
	
	public static UserClass loadUserFromDataBase(String ID) throws UserNotFoundException {
		UserClass user = null;
		try {
			Database db = new Database();
			db.setPst("Select * FROM users WHERE userID = ?");
			db.getPst().setString(1, ID);
			ResultSet rs = db.getRs();
			if(!rs.next())
				throw new UserNotFoundException();
			else {
				String id = rs.getString("userID");
	            String userName = rs.getString("userName");
	            String password = rs.getString("password");
	            String contact = rs.getString("contact");
	            String role = rs.getString("usertype");
	            Timestamp userCreated = rs.getTimestamp("userCreated");
	            Timestamp userUpdated = rs.getTimestamp("userUpdated");
	            String editedByID = rs.getString("edited_by");
	            if(role == UserClass.ADMIN_USER) {
	            	user = new AdminClass(id, userName, password, contact, role, userCreated.toLocalDateTime(), userUpdated.toLocalDateTime(), editedByID);
	            }else {
	            	user = new RegularClass(id, userName, password, contact, role, userCreated.toLocalDateTime(), userUpdated.toLocalDateTime(), editedByID);
		        }
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
    
}
