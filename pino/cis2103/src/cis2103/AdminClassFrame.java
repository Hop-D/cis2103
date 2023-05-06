
package cis2103;

import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exceptions.MenuNotFoundException;
import model.AdminClass;
import model.Database;
import model.Item;
import model.Package;
import model.UserClass;

/**
 *
 * @author Janica Nyle Pino
 */
public class AdminClassFrame extends javax.swing.JFrame {
    
    private DefaultTableModel model;
    private DefaultTableModel model3;
    private int rowIndex;
    private static AdminClass user;
    
    
    public AdminClassFrame(UserClass user) {
        initComponents();

		inputItemID.setText(String.valueOf("" + Database.getLastItemID()));
		inputNewPackage.setText("" + Database.getLastPackageID());
        inputUserID.setText(String.valueOf("" + Database.getLastUserID()));
          
        inputItemID.setEditable(false);
        inputPackageID.setEditable(false);
        inputUserID.setEditable(false);
        inputNewPackage.setEditable(false);
        inputPackageSingleID.setEditable(false);
        
        tableViewUsers();
        tableViewItems("");
        tableViewPackages();
  
        tableItems.setRowHeight(40);
        tableUsers.setRowHeight(40);
        tablePackages.setRowHeight(30);
        tablePackageSingle.setRowHeight(30);
        tablePackageItem.setRowHeight(30);
        
        ButtonGroup userRoles = new ButtonGroup();
        userRoles.add(radioUserAdmin);
        userRoles.add(radioUserRegular);
        radioUserRegular.setSelected(true);
        user = (AdminClass) user;
        
        
//        
        tableViewPackageSingle();
        
        
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        buttonAddNewItem = new javax.swing.JButton();
        buttonItemUpdate = new javax.swing.JButton();
        buttonItemRemove = new javax.swing.JButton();
        buttonClearInputItem = new javax.swing.JButton();
        buttonItemPrint = new javax.swing.JButton();
        inputItemID = new javax.swing.JTextField();
        inputSingleName = new javax.swing.JTextField();
        inputSinglePrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        inputSingleSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonItemSearch = new javax.swing.JButton();
        buttonItemTableRefresh = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablePackageItem = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        buttonPackageItemRemove = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePackageSingle = new javax.swing.JTable();
        buttonPackageItemAdd = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        inputPackageSingleID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        inputNewPackage = new javax.swing.JTextField();
        buttonPackageAdd = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePackages = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        inputPackageID = new javax.swing.JTextField();
        inputPackagePrice = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        buttonPackageUpdate = new javax.swing.JButton();
        buttonPackageRemove = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        inputUserSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        buttonUserSearch = new javax.swing.JButton();
        buttonUserRefresh = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        inputUserID = new javax.swing.JTextField();
        inputUserName = new javax.swing.JTextField();
        inputUserPass = new javax.swing.JTextField();
        inputUserContact = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        buttonUserAdd = new javax.swing.JButton();
        buttonUserClear = new javax.swing.JButton();
        buttonUserUpdate = new javax.swing.JButton();
        buttonUserPrint = new javax.swing.JButton();
        buttonUserRemove = new javax.swing.JButton();
        radioUserAdmin = new javax.swing.JRadioButton();
        radioUserRegular = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        buttonLogOut.setText("LOG OUT");
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1396, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("WELCOME", jPanel3);

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));

        jPanel8.setBackground(new java.awt.Color(0, 102, 51));

        jPanel12.setBackground(new java.awt.Color(0, 51, 51));

        buttonAddNewItem.setText("ADD NEW");
        buttonAddNewItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddNewItemActionPerformed(evt);
            }
        });

        buttonItemUpdate.setText("UPDATE");
        buttonItemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					buttonItemUpdateActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        buttonItemRemove.setText("REMOVE");
        buttonItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemRemoveActionPerformed(evt);
            }
        });

        buttonClearInputItem.setText("CLEAR");
        buttonClearInputItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearInputItemActionPerformed(evt);
            }
        });

        buttonItemPrint.setText("PRINT");
        buttonItemPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(buttonItemUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonItemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonClearInputItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonClearInputItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonItemUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        inputSinglePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputSinglePriceKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ITEM ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ITEM NAME");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ITEM PRICE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(53, 53, 53)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputSingleName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSinglePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSingleName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSinglePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(0, 204, 153));

        jLabel4.setText("Search an Item");

        buttonItemSearch.setText("SEARCH");
        buttonItemSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemSearchActionPerformed(evt);
            }
        });

        buttonItemTableRefresh.setText("REFRESH");
        buttonItemTableRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItemTableRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(inputSingleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonItemSearch)
                .addGap(33, 33, 33)
                .addComponent(buttonItemTableRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSingleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(buttonItemSearch)
                    .addComponent(buttonItemTableRefresh))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(0, 51, 51));

        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "ITEM NAME", "PRICE", "DATE ADDED", "LAST UPDATED ON"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableItems);
        if (tableItems.getColumnModel().getColumnCount() > 0) {
            tableItems.getColumnModel().getColumn(0).setResizable(false);
            tableItems.getColumnModel().getColumn(1).setResizable(false);
            tableItems.getColumnModel().getColumn(2).setResizable(false);
            tableItems.getColumnModel().getColumn(3).setResizable(false);
            tableItems.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("MANAGE SINGLE ITEMS", jPanel4);

        jPanel13.setBackground(new java.awt.Color(204, 255, 204));

        tablePackageItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "NAME", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePackageItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackageItemMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablePackageItem);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("ITEMS IN PACKAGE");

        buttonPackageItemRemove.setText("REMOVE FROM PACKAGE");
        buttonPackageItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageItemRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonPackageItemRemove, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPackageItemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(0, 51, 51));

        tablePackageSingle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE"
            }
        ));
        tablePackageSingle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackageSingleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablePackageSingle);

        buttonPackageItemAdd.setText("ADD TO PACKAGE");
        buttonPackageItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageItemAddActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ITEM");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ITEMS");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(inputPackageSingleID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPackageItemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addContainerGap())
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPackageItemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPackageSingleID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(22, 22, 22))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("CREATE NEW PACKAGE WITH ID");

        buttonPackageAdd.setText("CREATE");
        buttonPackageAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputNewPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPackageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(inputNewPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPackageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tablePackages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE", "# ITEMS", "CREATED ON"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePackages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackagesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablePackages);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("PACKAGE PRICE");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("PACKAGE ID");

        buttonPackageUpdate.setText("UPDATE");
        buttonPackageUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageUpdateActionPerformed(evt);
            }
        });

        buttonPackageRemove.setText("REMOVE");
        buttonPackageRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputPackageID, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(inputPackagePrice))
                .addGap(40, 40, 40)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonPackageUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPackageRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPackageID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(buttonPackageUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPackagePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(buttonPackageRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("MANAGE PACKAGE ITEMS", jPanel5);

        jPanel15.setBackground(new java.awt.Color(204, 255, 204));

        jPanel17.setBackground(new java.awt.Color(0, 204, 153));

        jLabel10.setText("Search a User");

        buttonUserSearch.setText("SEARCH");
        buttonUserSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserSearchActionPerformed(evt);
            }
        });

        buttonUserRefresh.setText("REFRESH");
        buttonUserRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel10)
                .addGap(31, 31, 31)
                .addComponent(inputUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonUserSearch)
                .addGap(18, 18, 18)
                .addComponent(buttonUserRefresh)
                .addContainerGap(246, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(buttonUserSearch)
                    .addComponent(buttonUserRefresh))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(0, 51, 51));

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USERNAME", "PASSWORD", "CONTACT #", "ROLE", "CREATED ON", "UPDATED ON"
            }
        ));
        tableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableUsers);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(0, 102, 51));

        inputUserContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputUserContactKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USER ID");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("USERNAME");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PASSWORD");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CONTACT #");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("USER ROLE");

        buttonUserAdd.setText("ADD NEW");
        buttonUserAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserAddActionPerformed(evt);
            }
        });

        buttonUserClear.setText("CLEAR");
        buttonUserClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserClearActionPerformed(evt);
            }
        });

        buttonUserUpdate.setText("UPDATE");
        buttonUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserUpdateActionPerformed(evt);
            }
        });

        buttonUserPrint.setText("PRINT");
        buttonUserPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserPrintActionPerformed(evt);
            }
        });

        buttonUserRemove.setText("REMOVE");
        buttonUserRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserRemoveActionPerformed(evt);
            }
        });

        radioUserAdmin.setForeground(new java.awt.Color(255, 255, 255));
        radioUserAdmin.setText("Admin");

        radioUserRegular.setForeground(new java.awt.Color(255, 255, 255));
        radioUserRegular.setText("Regular");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputUserContact, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(inputUserPass, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(inputUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(inputUserID))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(radioUserAdmin)
                        .addGap(36, 36, 36)
                        .addComponent(radioUserRegular)))
                .addGap(116, 116, 116))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonUserRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonUserPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUserClear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUserPass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputUserContact, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(radioUserAdmin)
                    .addComponent(radioUserRegular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUserClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUserRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUserPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("MANAGE USERS", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    // LOG OUT
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {
        
        int out = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "SELECT", JOptionPane.YES_NO_OPTION);
        if(out == 0) {
            this.dispose();
            new Login().setVisible(true);
        }
    } 
    
    ////////////MANAGE SINGLE ITEMS////////////////////
    //```buttons ---- ADD NEW//
    private void buttonAddNewItemActionPerformed(java.awt.event.ActionEvent evt) {
        if(isEmptyItems()) {
        	try {
				@SuppressWarnings("unused")
				Item item = Database.getItemByName(inputSingleName.getText());
				JOptionPane.showMessageDialog(this, "Item already exists");
			} catch (MenuNotFoundException e) {
				try {
					int choice = JOptionPane.showConfirmDialog(null, "Add item?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
			        
			        if(choice == JOptionPane.NO_OPTION) {
			        	return;
			        }
					Database.addItem(new Item("I" + inputItemID.getText(), inputSingleName.getText(), Float.parseFloat(inputSinglePrice.getText())));
					tableViewItems("");
				} catch (NumberFormatException | SQLException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
					System.out.println(e.getMessage() + " " + e1.getClass());
				}
			}finally {
				clearSingle();
			}
        }
    }
  //```buttons ---- UPDATE ITEM//
    private void buttonItemUpdateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
    	
    	
		try {
			Database.updateItem(inputItemID.getText(), inputSingleName.getText(), Float.parseFloat(inputSinglePrice.getText()));
			tableViewItems("");
			clearSingle();
		} catch (Exception e) {
			JOptionPane.showInputDialog(this, e.getMessage());
		}
    }
    
    //```buttons ---- REMOVE ITEM//
    private void buttonItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        try {
        	Item item = Database.getItemByID(inputItemID.getText());
			Database.removeItem(item);
			tableViewItems("");
		} catch (SQLException | MenuNotFoundException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}finally {
			clearSingle();
		}
    }
    
    //```buttons ---- PRINT ITEM//
    private void buttonItemPrintActionPerformed(java.awt.event.ActionEvent evt) {
        
        try {
            MessageFormat header = new MessageFormat("ALL ITEMS");
            MessageFormat footer = new MessageFormat("Page {0, number, integer}");
            tableItems.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(AdminClassFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //```buttons ---- SEARCH ITEM//
    private void buttonItemSearchActionPerformed(java.awt.event.ActionEvent evt) {
        
        if(inputSingleSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input is empty");
        } else {
            tableItems.setModel(new DefaultTableModel(null, new Object[] {
            "ID", "NAME", "PRICE", "DATE ADDED", "LAST UPDATED ON"
        }));
        tableViewItems(inputSingleSearch.getText());
        }
    }

    //```buttons ---- CLEAR//    
    private void buttonClearInputItemActionPerformed(java.awt.event.ActionEvent evt) {   
        clearSingle();
    }

    //```buttons ---- REFRESH ITEM//
    private void buttonItemTableRefreshActionPerformed(java.awt.event.ActionEvent evt) {
		tableViewItems("");
    }

    // Display data of clicked row in MANAGE SINGLE ITEMS
    private void tableItemsMouseClicked(java.awt.event.MouseEvent evt) {
        
        model = (DefaultTableModel) tableItems.getModel();
        rowIndex = tableItems.getSelectedRow();
        
        inputItemID.setText(model.getValueAt(rowIndex, 0).toString());
        inputSingleName.setText(model.getValueAt(rowIndex, 1).toString());
        inputSinglePrice.setText(model.getValueAt(rowIndex, 2).toString());
    }
    
    // put data of items in a table
    private void tableViewItems(String searchVal) {
    	DefaultTableModel model = (DefaultTableModel) tableItems.getModel();
    	model.setRowCount(0);
    	Object[] row;
    	for(Item i: Database.getItems()) {
    		if(i.concatDets().contains(searchVal)) {
                row = new Object[5];
                row[0] = i.getId();
                row[1] = i.getName();
                row[2] = i.getPrice();
                row[3] = i.getDateAdded();
                row[4] = i.getDateUpdated();
                model.addRow(row);
    		}
    	}
    	model = (DefaultTableModel) tableItems.getModel();
    }

    //Check if all fields are filled
    public boolean isEmptyItems() {
        
        if(inputItemID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item ID is missing");
            return false;
        }   
        if(inputSingleName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item Name is missing");
            return false;
        }
        if(inputSinglePrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Item Price is missing");
            return false;
        }
        return true;
    }
    
    //clears inputs for items
    private void clearSingle() {
		inputItemID.setText("" + Database.getLastItemID());
	    inputSingleName.setText(null);
	    inputSinglePrice.setText(null);
    }
    
	////////////MANAGE PACKAGES////////////////////
	//```buttons ---- ADD NEW//
    // Fetch data of selected package
    private void tablePackagesMouseClicked(java.awt.event.MouseEvent evt) {
        
        model = (DefaultTableModel) tablePackages.getModel();
        rowIndex = tablePackages.getSelectedRow();
        
        inputPackageID.setText(model.getValueAt(rowIndex, 0).toString());
        inputPackagePrice.setText(model.getValueAt(rowIndex, 2).toString());
        
        tablePackageItem.setModel(new DefaultTableModel(null, new Object[] {
            "ITEM ID", "NAME", "PRICE"
        }));
    }

    // Add Package
    private void buttonPackageAddActionPerformed(java.awt.event.ActionEvent evt) {
    	String id = "P" + inputNewPackage.getText();
    	try {
    		Package pack = Database.getPackageByID(id);
			JOptionPane.showMessageDialog(this, "Package already exists");
    	}catch(MenuNotFoundException e) {
    		int choice = JOptionPane.showConfirmDialog(null, "Add package?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
	        
	        if(choice == JOptionPane.NO_OPTION) {
	        	return;
	        }
    		
	        try {
				Database.addPackage(new Package(id, "Package " + id, Float.parseFloat("0")));
				inputNewPackage.setText("" + Database.getLastPackageID());
	        } catch (NumberFormatException | SQLException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
    	}
//    	
//    	
//    	int packageID = admin2.getMax();
//        String packageName = "Package " + packageID;
//        String packagePrice = "0";
//        int packageCount = 0;
//        
//        admin2.insertPackage(packageID, packageName, packagePrice, packageCount);
//
//        tablePackages.setModel(new DefaultTableModel(null, new Object[] {
//            "ID", "NAME", "PRICE", "# ITEMS", "CREATED ON"
//        }));
////        admin2.getPackages(tablePackages, "");
//        
//        inputNewPackage.setText(String.valueOf(admin2.getMax()));
        
    }

    // Update a package
    private void buttonPackageUpdateActionPerformed(java.awt.event.ActionEvent evt) {
//        int packageID = Integer.parseInt(inputPackageID.getText());
//        String packagePrice = inputPackagePrice.getText();
//        
//        admin2.updatePackage(packageID, packagePrice);
//        tablePackages.setModel(new DefaultTableModel(null, new Object[] {
//            "ID", "NAME", "PRICE", "# ITEMS", "CREATED ON"
//        }));
////        admin2.getPackages(tablePackages, "");
    }
    
    // Remove a package
    private void buttonPackageRemoveActionPerformed(java.awt.event.ActionEvent evt) {
//        int packageID = Integer.parseInt(inputPackageID.getText());
//        
//        admin2.removeAllItems(packageID);
//        admin2.removePackage(packageID);
//        
//        tablePackages.setModel(new DefaultTableModel(null, new Object[] {
//            "ID", "NAME", "PRICE", "# ITEMS", "CREATED ON"
//        }));
////        admin2.getPackages(tablePackages, "");
//        
//        inputNewPackage.setText(String.valueOf(admin2.getMax()));
//        
//        tablePackageItem.setModel(new DefaultTableModel(null, new Object[] {
//            "ITEM ID", "NAME", "PRICE"
//        }));
//        admin2.getPackageItem(tablePackageItem, inputPackageID.getText());
    }
    
    // Fetch data of selected item
    private void tablePackageSingleMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tablePackageSingle.getModel();
        rowIndex = tablePackageSingle.getSelectedRow();
        
        inputPackageSingleID.setText(model.getValueAt(rowIndex, 0).toString());
    }

    // Add Item to Package
    private void buttonPackageItemAddActionPerformed(java.awt.event.ActionEvent evt) {
//        if(inputPackageID.getText().equals("0")) {
//            JOptionPane.showMessageDialog(null, "Choose A Package");
//        } else {
//            
//            if(!admin2.isPackageItemExist(Integer.parseInt(inputPackageID.getText()), Integer.parseInt(inputPackageSingleID.getText()))) {
//            
//                admin2.addItemPackage(Integer.parseInt(inputPackageID.getText()), Integer.parseInt(inputPackageSingleID.getText()));
//
//                tablePackageItem.setModel(new DefaultTableModel(null, new Object[] {
//                    "ITEM ID", "NAME", "PRICE"
//                }));
//                admin2.getPackageItem(tablePackageItem, inputPackageID.getText());
//                
//                tablePackages.setModel(new DefaultTableModel(null, new Object[] {
//                    "ID", "NAME", "PRICE", "# ITEMS", "CREATED ON"
//                }));
////                admin2.getPackages(tablePackages, "");
//                
//            } else {
//                JOptionPane.showMessageDialog(this, "Item already exists in package");
//            }   
//        }
    }
    
    // Fetch data of item inside package
    private void tablePackageItemMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tablePackageItem.getModel();
        rowIndex = tablePackageItem.getSelectedRow();
        
        inputPackageSingleID.setText(model.getValueAt(rowIndex, 0).toString());
    }

    // Remove Item from Package
    private void buttonPackageItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {
//        if(inputPackageID.getText().equals("0")) {
//            JOptionPane.showMessageDialog(null, "Choose A Package");
//        } else {
//            admin2.removeItemPackage(Integer.parseInt(inputPackageID.getText()), Integer.parseInt(inputPackageSingleID.getText()));
//            
//            tablePackageItem.setModel(new DefaultTableModel(null, new Object[] {
//                "ITEM ID", "NAME", "PRICE"
//            }));
//            admin2.getPackageItem(tablePackageItem, inputPackageID.getText());
//            
//            tablePackages.setModel(new DefaultTableModel(null, new Object[] {
//                "ID", "NAME", "PRICE", "# ITEMS", "CREATED ON"
//            }));
////            admin2.getPackages(tablePackages, "");
//        }
    }

    
	private void tableViewPackages() {
    	DefaultTableModel model1 = (DefaultTableModel) tablePackages.getModel();
    	model1.setRowCount(0);
    	Object[] row;
    	for(Package pack: Database.getPack()) {
    		row = new Object[5];
    		row[0] = pack.getId();
            row[1] = pack.getName();
            row[2] = pack.getPrice();
            row[3] = pack.getNumberOfItems();
            row[4] = pack.getDateAdded();
            model1.addRow(row);
  		}
    }
  
    
    private void tableViewPackageSingle() {
    	DefaultTableModel model = (DefaultTableModel) tablePackageSingle.getModel();
    	model.setRowCount(0);
    	Object[] row;
    	for(Item i: Database.getItems()) {
               row = new Object[5];
               row[0] = i.getId();
               row[1] = i.getName();
               row[2] = i.getPrice();
               model.addRow(row);
    	}
    	model = (DefaultTableModel) tablePackageSingle.getModel();
    }
    
    // for Manage Users
    private void tableViewUsers() {
      //  admin3.getUsers(tableUsers, "");
        model3 = (DefaultTableModel) tableUsers.getModel();
    }
    
    // clearing input boxes
    // for Manage Single Items
    
    // for Manage Users
    private void clearUser() {
   //     inputUserID.setText(String.valueOf(admin3.getMax()));
        inputUserName.setText(null);
        inputUserPass.setText(null);
        inputUserContact.setText(null);
        radioUserRegular.setSelected(true);     
    }
    
    
    // for Manage Users
    public boolean isEmptyUser() {
        if(inputUserName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User Name is missing");
            return false;
        }
        if(inputUserPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User Password is missing");
            return false;
        }      
        if(inputUserContact.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User Contact Number is missing");
            return false;
        }    
        return true;
    } 
    
  
    
    // EVENTS FOR MANAGE USERS
    
    // Only numeric inputs for contact
    private void inputUserContactKeyTyped(java.awt.event.KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    
    // Fetch data of selected table row
    private void tableUsersMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tableUsers.getModel();
        rowIndex = tableUsers.getSelectedRow();
        
        inputUserID.setText(model.getValueAt(rowIndex, 0).toString());
        inputUserName.setText(model.getValueAt(rowIndex, 1).toString());
        inputUserPass.setText(model.getValueAt(rowIndex, 2).toString());
        inputUserContact.setText(model.getValueAt(rowIndex, 3).toString());
        if(model.getValueAt(rowIndex, 4).toString().equals("admin")) {
            radioUserAdmin.setSelected(true);
            radioUserRegular.setSelected(false);
        } else {
            radioUserAdmin.setSelected(false);
            radioUserRegular.setSelected(true);
        }
    }

    // Add User
    private void buttonUserAddActionPerformed(java.awt.event.ActionEvent evt) {
//        if(isEmptyUser()) {
//            
//            if(!admin3.isUserExist(inputUserName.getText())) {
//                            
//     //           int userID = admin3.getMax();
//                String userName = inputUserName.getText();
//                String userPass = inputUserPass.getText();
//                String userContact = inputUserContact.getText();
//                String userType = "regular";
//                if(radioUserAdmin.isSelected()) {
//                    userType = "admin";
//                }
//
//     //           admin3.insertUser(userID, userName, userPass, userContact, userType);
//             
//                tableUsers.setModel(new DefaultTableModel(null, new Object[] {
//                    "ID", "USERNAME", "PASSWORD", "CONTACT#", "ROLE", "CREATED ON", "UPDATED ON"
//                }));
//            //    admin3.getUsers(tableUsers, "");
//                
//                clearUser();         
//            } else {
//                JOptionPane.showMessageDialog(this, "User already exists");
//                clearUser();
//            }
//        }
    }

    // Update User 
    private void buttonUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {
//        if(isEmptyUser()) {
//        
//            int userID = Integer.parseInt(inputUserID.getText());
//            String oldName = model3.getValueAt(rowIndex, 1).toString();
//
//            String userName = inputUserName.getText();
//            String userPass = inputUserPass.getText();
//            String userContact = inputUserContact.getText();
//            String userType = "";
//            if(radioUserAdmin.isSelected()) {
//                userType = "admin";
//            } else if(radioUserRegular.isSelected()) {
//                userType = "regular";
//            }
//
//            if(oldName.equals(userName) && admin3.isUserExist(inputUserName.getText()) ) {
//                admin3.updateUser(userID, userName, userPass, userContact, userType);
//                tableUsers.setModel(new DefaultTableModel(null, new Object[] {
//                    "ID", "USERNAME", "PASSWORD", "CONTACT#", "ROLE", "CREATED ON", "UPDATED ON"
//                }));
//        //        admin3.getUsers(tableUsers, "");
//                
//                clearUser(); 
//            } else {
//                JOptionPane.showMessageDialog(this, "User already exists");
//                clearUser();
//            }
//        }
    }

    // Remove User
    private void buttonUserRemoveActionPerformed(java.awt.event.ActionEvent evt) {
//        int userID = Integer.parseInt(inputUserID.getText());
//        
//        admin3.removeUser(userID);
//        
//        tableUsers.setModel(new DefaultTableModel(null, new Object[] {
//            "ID", "USERNAME", "PASSWORD", "CONTACT#", "ROLE", "CREATED ON", "UPDATED ON"
//        }));
//   //     admin3.getUsers(tableUsers, "");
//
//        clearUser();  
    }
    
    // Clear input components
    private void buttonUserClearActionPerformed(java.awt.event.ActionEvent evt) {
//        inputUserID.setText(String.valueOf(admin3.getMax()));
        inputUserName.setText(null);
        inputUserPass.setText(null);
        inputUserContact.setText(null);
        radioUserRegular.setSelected(true);  
    }

    // Print User List
    private void buttonUserPrintActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            MessageFormat header = new MessageFormat("ALL USERS");
            MessageFormat footer = new MessageFormat("Page {0, number, integer}");
            tableUsers.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(AdminClassFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Search User
    private void buttonUserSearchActionPerformed(java.awt.event.ActionEvent evt) {
        if(inputUserSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input is empty");
        } else {
            tableUsers.setModel(new DefaultTableModel(null, new Object[] {
                "ID", "USERNAME", "PASSWORD", "CONTACT#", "ROLE", "CREATED ON", "UPDATED ON"
            }));
    //        admin3.getUsers(tableUsers, inputUserSearch.getText());
        }
    }

    // Refresh User Table
    private void buttonUserRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        tableUsers.setModel(new DefaultTableModel(null, new Object[] {
            "ID", "USERNAME", "PASSWORD", "CONTACT#", "ROLE", "CREATED ON", "UPDATED ON"
        }));
       // admin3.getUsers(tableUsers, "");
        inputUserSearch.setText(null);
    }

    
    // EVENTS FOR MANAGE PACKAGE ITEMS

    
 // Only numeric inputs for price
    private void inputSinglePriceKeyTyped(java.awt.event.KeyEvent evt) {
        
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    

    private javax.swing.JButton buttonLogOut;
    private javax.swing.JButton buttonPackageAdd;
    private javax.swing.JButton buttonPackageItemAdd;
    private javax.swing.JButton buttonPackageItemRemove;
    private javax.swing.JButton buttonPackageRemove;
    private javax.swing.JButton buttonPackageUpdate;
    private javax.swing.JButton buttonAddNewItem;
    private javax.swing.JButton buttonClearInputItem;
    private javax.swing.JButton buttonItemPrint;
    private javax.swing.JButton buttonItemTableRefresh;
    private javax.swing.JButton buttonItemRemove;
    private javax.swing.JButton buttonItemSearch;
    private javax.swing.JButton buttonItemUpdate;
    private javax.swing.JButton buttonUserAdd;
    private javax.swing.JButton buttonUserClear;
    private javax.swing.JButton buttonUserPrint;
    private javax.swing.JButton buttonUserRefresh;
    private javax.swing.JButton buttonUserRemove;
    private javax.swing.JButton buttonUserSearch;
    private javax.swing.JButton buttonUserUpdate;
    private javax.swing.JTextField inputNewPackage;
    private javax.swing.JTextField inputPackageID;
    private javax.swing.JTextField inputPackagePrice;
    private javax.swing.JTextField inputPackageSingleID;
    private javax.swing.JTextField inputItemID;
    private javax.swing.JTextField inputSingleName;
    private javax.swing.JTextField inputSinglePrice;
    private javax.swing.JTextField inputSingleSearch;
    private javax.swing.JTextField inputUserContact;
    private javax.swing.JTextField inputUserID;
    private javax.swing.JTextField inputUserName;
    private javax.swing.JTextField inputUserPass;
    private javax.swing.JTextField inputUserSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radioUserAdmin;
    private javax.swing.JRadioButton radioUserRegular;
    private javax.swing.JTable tablePackageItem;
    private javax.swing.JTable tablePackageSingle;
    private javax.swing.JTable tablePackages;
    private javax.swing.JTable tableItems;
    private javax.swing.JTable tableUsers;
}
