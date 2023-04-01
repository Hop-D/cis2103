
package cis2103;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Janica Nyle Pino
 */
public class AdminSingleOp {
    
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    
    // get latest single item id possible
    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(itemID) FROM items");
            while(rs.next()) {
                id = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;   
    }
    
    public int getlistMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(listID) FROM list");
            while(rs.next()) {
                id = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;    
    }
    
    public void addList() {
        int id = getlistMax();
        int id2 = getMax();
        
        String sql = "INSERT INTO list VALUES(?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id2 - 1);
            
            if(ps.executeUpdate() > 0) {

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeList(int itemID) {
        
        String sql = "DELETE FROM list WHERE ID = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, itemID);

            if(ps.executeUpdate() > 0) {
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // insert single item entry to database
    public void insertSingle(int itemID, String itemName, String itemPrice) {
        String sql = "INSERT INTO items VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, itemID);
            ps.setString(2, itemName);
            ps.setString(3, itemPrice);
            ps.setInt(4, 0);
            ps.setInt(5, getlistMax());
            ps.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
            ps.setTimestamp(7, new java.sql.Timestamp(new java.util.Date().getTime()));
            
            
            if(ps.executeUpdate() > 0) {
                addList();
                JOptionPane.showMessageDialog(null, "New Item Added Successfully");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // check if item already exists
    public boolean isSingleExist(String itemName) {
        String sql = "SELECT * FROM items where itemName = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, itemName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // display in table
    public void getSingleItems(JTable table, String searchVal) {
        String sql = "SELECT * FROM items WHERE CONCAT(itemID, itemName, itemPrice, itemAdded, itemUpdated)like ? ORDER BY itemID DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchVal + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while(rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(6);
                row[4] = rs.getString(7);
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // update single item
    public void updateSingle(int itemID, String itemName, String itemPrice) {
        String sql = "UPDATE items SET itemName = ?, itemPrice = ?, itemUpdated = ? WHERE itemID = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, itemName);
            ps.setString(2, itemPrice);
            ps.setTimestamp(3, new java.sql.Timestamp(new java.util.Date().getTime()));
            ps.setInt(4, itemID);
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Item Updated Successfully");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    // delete single item
    public void removeSingle(int itemID) {
        int choice = JOptionPane.showConfirmDialog(null, "Removing an item is irreversible", "Item Remove", JOptionPane.OK_CANCEL_OPTION, 0);
        
        if(choice == JOptionPane.OK_OPTION) {
            String sql = "DELETE FROM items WHERE itemID = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, itemID);
                
                if(ps.executeUpdate() > 0) {
                    removeList(itemID);
                    JOptionPane.showMessageDialog(null, "Item Removed Successfully");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
