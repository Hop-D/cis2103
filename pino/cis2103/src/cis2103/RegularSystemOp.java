
package cis2103;

import java.sql.*;
import java.util.ArrayList;
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
    
    public void getRegItem(JTable table, String searchVal) {
        String sql = "SELECT * FROM saleitem WHERE CONCAT(saleitemID, saleID, listID, count)like ? ORDER BY saleitemID DESC";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchVal + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object[] row;
            while(rs.next()) {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                row[2] = rs.getInt(3);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegularSystemOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getMax() {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(saleID) FROM sales");
            while(rs.next()) {
                id = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminSingleOp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;   
    }
    
    public void insertSaleItem(ArrayList<SaleItem> saleitems, int saleID) {
        int i;
        String items = "";
        for(i = 0; i < saleitems.size(); i++) {
            String current = saleitems.get(i).itemName + " - ";
            items = items.concat(current);
        }
        System.out.println(items);
        
        String sql = "INSERT INTO saleitem VALUES (?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, saleID);
            ps.setInt(2, saleID);
            ps.setString(3, items);
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sale Done");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegularSystemOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertSale(int saleID, String custName, String custAdd, String custNum, String custOrder, String custMode, int itemCount, float total, float amount, float cchange) {
        String sql = "INSERT INTO sales VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, saleID);
            ps.setString(2, custName);
            ps.setString(3, custAdd);
            ps.setString(4, custNum);
            ps.setString(5, custOrder);
            ps.setString(6, custMode);
            ps.setInt(7, itemCount);
            ps.setFloat(8, total);
            ps.setFloat(9, amount);
            ps.setFloat(10, cchange);
            ps.setTimestamp(11, new java.sql.Timestamp(new java.util.Date().getTime()));
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Sale Done");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegularSystemOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
