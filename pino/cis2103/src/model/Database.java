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
	private PreparedStatement st;
	
	private static ArrayList<UserClass> users = new ArrayList<UserClass>();
	private static ArrayList<Items> items = new ArrayList<Items>();
	
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
	
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void closeConn() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getSt() {
		return st;
	}

	public void setSt(PreparedStatement st) {
			 
		this.st = st;
	}
	
	
	
	public static ArrayList<UserClass> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<UserClass> users) {
		Database.users = users;
	}

	public static ArrayList<Items> getItems() {
		return items;
	}

	public static void setItems(ArrayList<Items> items) {
		Database.items = items;
	}

	public static void loadUsersFromDatabase() throws SQLException {
	    Database db = null;
	    UserClass user = null;
	    try {
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
	        while (rs.next()) {
	            String id = rs.getString("userID");
	            String userName = rs.getString("userName");
	            String password = rs.getString("password");
	            String contact = rs.getString("contact");
	            String role = rs.getString("usertype");
	            Timestamp userCreated = rs.getTimestamp("userCreated");
	            Timestamp userUpdated = rs.getTimestamp("userUpdated");
	            String editedByID = rs.getString("edited_by");
	            try {
		            if(role.equals(UserClass.ADMIN_USER)) {
		                user = new AdminClass(id, userName, password, contact, role, userCreated.toLocalDateTime(), userUpdated.toLocalDateTime());    
		            }
		            if(role.equals(UserClass.REGULAR_USER)) {
							user = new RegularClass(id, userName, password, contact, role, userCreated.toLocalDateTime(), userUpdated.toLocalDateTime());
		            }
	            } catch (UserNotFoundException e) {
	            	e.getMessage();
				}
	            users.add(user);
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void loadItemsFromDatabase() throws SQLException {
	    Database db = null;
	    Items item = null;
	    try {
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM items");
	        while (rs.next()) {
	            int id = rs.getInt("itemID");
	            String name = rs.getString("itemName");
	            float price = rs.getFloat("itemPrice");
	            int count = rs.getInt("itemCount");
	            Timestamp itemAdded = rs.getTimestamp("itemUpdated");
	            Timestamp itemUpdated = rs.getTimestamp("userUpdated");
	            String modifiedBy = rs.getString("modifiedBy");
	            try {
	        		item = new Items(id, name, price, count, itemAdded.toLocalDateTime(), itemUpdated.toLocalDateTime(), getUser(modifiedBy));     
	            } catch (UserNotFoundException e) {
	            	e.getMessage();
				}
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

	public static UserClass getUser(String id) throws UserNotFoundException {
		for(UserClass user: users) {
			if(id.equals(user.getId())) {
				return user;
			}
		}
		throw new UserNotFoundException();
	}
    
}
