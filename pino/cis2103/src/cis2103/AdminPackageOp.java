
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
public class AdminPackageOp {
    
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    
    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(packageID) FROM packages");
            while(rs.next()) {
                id = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPackageOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;   
    }
    
    public void getPackages(JTable table, String searchVal) {
        String sql = "SELECT * FROM packages WHERE CONCAT(packageID, packageName, packagePrice, packageCount, packageCreated)like ? ORDER BY packageID DESC";
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
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPackageOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getPackageSingle(JTable table, String searchVal) {
        String sql = "SELECT * FROM items WHERE CONCAT(itemID, itemName, itemPrice)like ? ORDER BY itemID DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchVal + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while(rs.next()) {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                model.addRow(row);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPackageOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertPackage(int packageID, String packageName, String packagePrice, int packageCount) {
        String sql = "INSERT INTO packages VALUES (? , ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, packageID);
            ps.setString(2, packageName);
            ps.setString(3, packagePrice);
            ps.setInt(4, packageCount);
            ps.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New Package Added Successfully");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPackageOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePackage(int packageID, String packagePrice) {
        String sql = "UPDATE packages SET packagePrice = ? WHERE packageID = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, packagePrice);
            ps.setInt(2, packageID);
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Package Updated Successfully");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPackageOp.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    
    
    
}
