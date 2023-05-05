
package cis2103;

/**
 *
 * @author Janica Nyle Pino
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminUser {
    
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    
    // return the latest possible unique id in users
//    public int getMax() {
//        int id = 0;
//        Statement st;
//        try {
//            st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT MAX(userID) FROM users");
//            while(rs.next()) {
//                id = rs.getInt(1);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return id + 1;   
//    }
    
    // fetch all data for initial display in Manage Users
//    public void getUsers(JTable table, String searchVal) {
//        String sql = "SELECT * FROM users WHERE CONCAT(userID, username, password, contact, usertype, userCreated, userUpdated)like ? ORDER BY userID DESC";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, "%" + searchVal + "%");
//            ResultSet rs = ps.executeQuery();
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//            Object[] row;
//            while(rs.next()) {
//                row = new Object[7];
//                row[0] = rs.getInt(1);
//                row[1] = rs.getString(2);
//                row[2] = rs.getString(3);
//                row[3] = rs.getString(4);
//                row[4] = rs.getString(5);
//                row[5] = rs.getString(6);
//                row[6] = rs.getString(7);
//                model.addRow(row);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    // check if user already exists
    public boolean isUserExist(String username) {
        String sql = "SELECT * FROM users where username = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // CREATE NEW USER
    public void insertUser(int userID, String userName, String userPass, String userContact, String userType) {
        String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setString(2, userName);
            ps.setString(3, userPass);
            ps.setString(4, userContact);
            ps.setString(5, userType);
            ps.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
            ps.setTimestamp(7, new java.sql.Timestamp(new java.util.Date().getTime()));
            
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New User Added Successfully");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    // UPDATE USER
    public void updateUser(int userID, String userName, String userPass, String userContact, String userType) {
        String sql = "UPDATE users SET username = ?, password = ?, contact = ?, usertype = ?, userUpdated = ? WHERE userID = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, userPass);
            ps.setString(3, userContact);
            ps.setString(4, userType);
            ps.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            ps.setInt(6, userID);
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "User Updated Successfully");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // REMOVE USER
    public void removeUser(int userID) {
        int choice = JOptionPane.showConfirmDialog(null, "Removing a user is irreversible", "User Remove", JOptionPane.OK_CANCEL_OPTION, 0);
        
        if(choice == JOptionPane.OK_OPTION) {
            String sql = "DELETE FROM users WHERE userID = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, userID);
                
                if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "User Removed Successfully");
            }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
