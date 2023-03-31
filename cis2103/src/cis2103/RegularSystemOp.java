
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


public class RegularSystemOp {
    
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    
    public void getRegSingle(JTable table, String searchVal) {
        String sql = "SELECT * FROM items WHERE CONCAT(itemID, itemName, itemPrice, itemAdded, itemUpdated)like ? ORDER BY itemID DESC";
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
            Logger.getLogger(RegularSystemOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getRegPackage(JTable table, String searchVal) {
        String sql = "SELECT * FROM packages WHERE CONCAT(packageID, packageName, packagePrice, packageCount, packageCreated)like ? ORDER BY packageID DESC";
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
    
}
