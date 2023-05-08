
package cis2103;

import java.awt.print.PrinterException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import exceptions.MenuNotFoundException;
import exceptions.NameExistsInArrayException;
import exceptions.UserNotFoundException;
import model.AdminClass;
import model.RegularClass;
import model.Database;
import model.Feedbacks;
import model.Item;
import model.Package;
import model.UserClass;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminClassFrame extends javax.swing.JFrame {
    
    private DefaultTableModel model, model3;
    private int rowIndex;
    private static AdminClass temp;
    
    
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
        
        tableViewUsers("");
        tableViewItems("");
        tableViewPackages();
        tableViewPackageSingle();
        tableViewFeedbacks();
        
        ButtonGroup userRoles = new ButtonGroup();
        userRoles.add(radioUserAdmin);
        userRoles.add(radioUserRegular);
        radioUserRegular.setSelected(true);
        temp = (AdminClass) user;
        
    }

    private void initComponents() {
    	
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonLogOut = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        inputSingleSearch = new javax.swing.JTextField();
        buttonItemSearch = new javax.swing.JButton();
        buttonItemTableRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputItemID = new javax.swing.JTextField();
        inputSingleName = new javax.swing.JTextField();
        inputSinglePrice = new javax.swing.JTextField();
        buttonAddNewItem = new javax.swing.JButton();
        buttonItemUpdate = new javax.swing.JButton();
        buttonItemRemove = new javax.swing.JButton();
        buttonClearInputItem = new javax.swing.JButton();
        buttonItemPrint = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePackageItem = new javax.swing.JTable();
        buttonPackageItemRemove = new javax.swing.JButton();
        inputPackageSingleID2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePackageSingle = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        buttonPackageItemAdd = new javax.swing.JButton();
        inputPackageSingleID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputNewPackage = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inputNewPackageName = new javax.swing.JTextField();
        buttonPackageAdd = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePackages = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inputPackageID = new javax.swing.JTextField();
        inputPackageName = new javax.swing.JTextField();
        inputPackagePrice = new javax.swing.JTextField();
        buttonPackageUpdate = new javax.swing.JButton();
        buttonPackageRemove = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        inputUserSearch = new javax.swing.JTextField();
        buttonUserSearch = new javax.swing.JButton();
        buttonUserRefresh = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        inputUserID = new javax.swing.JTextField();
        inputUserName = new javax.swing.JTextField();
        inputUserPass = new javax.swing.JTextField();
        inputUserContact = new javax.swing.JTextField();
        radioUserAdmin = new javax.swing.JRadioButton();
        radioUserRegular = new javax.swing.JRadioButton();
        buttonUserAdd = new javax.swing.JButton();
        buttonUserUpdate = new javax.swing.JButton();
        buttonUserRemove = new javax.swing.JButton();
        buttonUserClear = new javax.swing.JButton();
        buttonUserPrint = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        labelFeedID = new javax.swing.JLabel();
        labelFeedSender = new javax.swing.JLabel();
        labelFeedDate = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        textFeedArea = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableFeedback = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1720, 880));
        setMinimumSize(new java.awt.Dimension(1720, 880));
        setPreferredSize(new java.awt.Dimension(1720, 880));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1720, 880));
        jPanel1.setMinimumSize(new java.awt.Dimension(1720, 880));

        jPanel2.setBackground(new java.awt.Color(11, 36, 71));
        jPanel2.setMaximumSize(new java.awt.Dimension(1720, 100));
        jPanel2.setMinimumSize(new java.awt.Dimension(1720, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SYSTEM | ADMIN");

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1720, 762));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1720, 762));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1720, 762));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(1720, 731));
        jPanel4.setMinimumSize(new java.awt.Dimension(1720, 731));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1720, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("WELCOME", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(1720, 731));
        jPanel3.setMinimumSize(new java.awt.Dimension(1720, 731));

        jPanel7.setBackground(new java.awt.Color(20, 30, 97));
        jPanel7.setMaximumSize(new java.awt.Dimension(1100, 731));
        jPanel7.setMinimumSize(new java.awt.Dimension(1100, 731));
        jPanel7.setPreferredSize(new java.awt.Dimension(1100, 731));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(1100, 80));
        jPanel8.setMinimumSize(new java.awt.Dimension(1100, 80));
        jPanel8.setPreferredSize(new java.awt.Dimension(1100, 80));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Search an Item :");

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(inputSingleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(buttonItemSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonItemTableRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(369, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputSingleSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemTableRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "NAME", "PRICE", "DATE ADDED", "DATE UPDATED", "UPDATED BY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItems.setMaximumSize(new java.awt.Dimension(1060, 580));
        tableItems.setMinimumSize(new java.awt.Dimension(1060, 580));
        tableItems.setPreferredSize(new java.awt.Dimension(1060, 580));
        tableItems.setRowHeight(40);
        tableItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableItems);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7Layout.setHorizontalGroup(
        	jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		.addGroup(Alignment.LEADING, jPanel7Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1046, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
        	jPanel7Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel7Layout.createSequentialGroup()
        			.addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel7.setLayout(jPanel7Layout);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Item ID :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Item Name :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Item Price :");

        inputItemID.setMaximumSize(new java.awt.Dimension(250, 40));
        inputItemID.setMinimumSize(new java.awt.Dimension(250, 40));
        inputItemID.setPreferredSize(new java.awt.Dimension(250, 40));

        inputSinglePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputSinglePriceKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputItemID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputSingleName)
                            .addComponent(inputSinglePrice)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonItemUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonClearInputItem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonItemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonItemPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputSingleName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputSinglePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonItemUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClearInputItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonItemPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );

        jTabbedPane1.addTab("MANAGE ITEMS", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(1720, 731));
        jPanel6.setMinimumSize(new java.awt.Dimension(1720, 731));

        jPanel9.setBackground(new java.awt.Color(20, 30, 97));

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
        tablePackageItem.setRowHeight(40);
        tablePackageItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackageItemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePackageItem);

        buttonPackageItemRemove.setText("REMOVE FROM PACKAGE");
        buttonPackageItemRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageItemRemoveActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ITEM ID :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(inputPackageSingleID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPackageItemRemove)
                .addGap(30, 30, 30))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12))
                    .addComponent(buttonPackageItemRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(inputPackageSingleID2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(20, 30, 97));

        tablePackageSingle.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePackageSingle.setRowHeight(40);
        tablePackageSingle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackageSingleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablePackageSingle);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ITEM ID :");

        buttonPackageItemAdd.setText("ADD TO PACKAGE");
        buttonPackageItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageItemAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(inputPackageSingleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPackageItemAdd)
                .addGap(28, 28, 28))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPackageItemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(inputPackageSingleID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("CREATE NEW PACKAGE WITH ID :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("ENTER PACKAGE NAME :");

        buttonPackageAdd.setText("CREATE");
        buttonPackageAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageAddActionPerformed(evt);
            }
        });

        tablePackages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE", "# OF ITEMS", "CREATED ON"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePackages.setRowHeight(40);
        tablePackages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePackagesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablePackages);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Package ID :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Package Name :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Package Price :");

//        inputPackagePrice.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyTyped(java.awt.event.KeyEvent evt) {
//                inputPackagePriceKeyTyped(evt);
//            }
//        });

        buttonPackageUpdate.setText("UPDATE");
        buttonPackageUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					buttonPackageUpdateActionPerformed(evt);
				} catch (MenuNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        buttonPackageRemove.setText("REMOVE");
        buttonPackageRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackageRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6Layout.setHorizontalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGap(30)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jLabel6)
        						.addComponent(jLabel7))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(inputNewPackage, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel6Layout.createSequentialGroup()
        							.addComponent(inputNewPackageName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(buttonPackageAdd)))
        					.addGap(0, 4, Short.MAX_VALUE))
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGap(59)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jLabel8)
        						.addComponent(jLabel9)
        						.addComponent(jLabel10))
        					.addGap(18)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(inputPackageID)
        						.addComponent(inputPackagePrice, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        						.addComponent(inputPackageName))
        					.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(buttonPackageUpdate, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonPackageRemove, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
        					.addGap(43)))
        			.addGap(18)
        			.addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
        			.addGap(24))
        );
        jPanel6Layout.setVerticalGroup(
        	jPanel6Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addGap(13)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(inputNewPackage, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel7)
        						.addComponent(inputNewPackageName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonPackageAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(inputPackageID, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel8))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(inputPackageName, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel9))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel6Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(inputPackagePrice, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel10)))
        				.addGroup(jPanel6Layout.createSequentialGroup()
        					.addComponent(buttonPackageUpdate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(buttonPackageRemove, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addGap(4)))
        			.addContainerGap(58, Short.MAX_VALUE))
        		.addGroup(jPanel6Layout.createSequentialGroup()
        			.addGroup(jPanel6Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jPanel10, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jPanel9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
        			.addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel6.setLayout(jPanel6Layout);

        jTabbedPane1.addTab("MANAGE PACKAGES", jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(1720, 731));
        jPanel5.setMinimumSize(new java.awt.Dimension(1720, 731));

        jPanel11.setBackground(new java.awt.Color(20, 30, 97));
        jPanel11.setMaximumSize(new java.awt.Dimension(1100, 100));
        jPanel11.setMinimumSize(new java.awt.Dimension(1100, 100));
        jPanel11.setPreferredSize(new java.awt.Dimension(1100, 100));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Search a User :");

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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(inputUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(buttonUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonUserRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(inputUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUserRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USERNAME", "PASSWORD", "CONTACT #", "ROLE", "CREATED ON", "UPDATED ON", "UPDATED BY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUsers.setRowHeight(40);
        tableUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUsersMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableUsers);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11Layout.setHorizontalGroup(
        	jPanel11Layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jPanel12, GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        		.addGroup(Alignment.LEADING, jPanel11Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 1044, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
        	jPanel11Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel11Layout.createSequentialGroup()
        			.addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel11.setLayout(jPanel11Layout);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("USER ID :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("USERNAME :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("PASSWORD :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("CONTACT # :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("USER ROLE :");

        radioUserAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioUserAdmin.setText("ADMIN");

        radioUserRegular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioUserRegular.setText("REGULAR");
        
        inputUserContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputUserContactKeyTyped(evt);
            }
        });

        buttonUserAdd.setText("ADD NEW");
        buttonUserAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserAddActionPerformed(evt);
            }
        });

        buttonUserUpdate.setText("UPDATE");
        buttonUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserUpdateActionPerformed(evt);
            }
        });

        buttonUserRemove.setText("REMOVE");
        buttonUserRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserRemoveActionPerformed(evt);
            }
        });

        buttonUserClear.setText("CLEAR");
        buttonUserClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserClearActionPerformed(evt);
            }
        });

        buttonUserPrint.setText("PRINT");
        buttonUserPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUserPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5Layout.setHorizontalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel5Layout.createSequentialGroup()
        			.addGap(69)
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel13)
        						.addComponent(jLabel14)
        						.addComponent(jLabel15)
        						.addComponent(jLabel16)
        						.addComponent(jLabel17))
        					.addGap(22))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addComponent(buttonUserAdd, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        					.addGap(46)))
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(jPanel5Layout.createSequentialGroup()
        						.addComponent(radioUserAdmin)
        						.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
        						.addComponent(radioUserRegular)
        						.addGap(48))
        					.addComponent(inputUserID)
        					.addComponent(inputUserName)
        					.addComponent(inputUserPass)
        					.addComponent(inputUserContact))
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(buttonUserUpdate, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonUserClear, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
        					.addGap(49)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(buttonUserPrint, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonUserRemove, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
        			.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
        			.addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, 1090, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
        	jPanel5Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel5Layout.createSequentialGroup()
        			.addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel5Layout.createSequentialGroup()
        					.addGap(105)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel13)
        						.addComponent(inputUserID, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel14)
        						.addComponent(inputUserName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel15)
        						.addComponent(inputUserPass, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel16)
        						.addComponent(inputUserContact, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel17)
        						.addComponent(radioUserAdmin)
        						.addComponent(radioUserRegular))
        					.addGap(79)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(buttonUserRemove, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonUserUpdate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonUserAdd, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        					.addGap(40)
        					.addGroup(jPanel5Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(buttonUserPrint, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonUserClear, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel5.setLayout(jPanel5Layout);

        jTabbedPane1.addTab("MANAGE USERS", jPanel5);
        
        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        labelFeedID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFeedID.setText("FEEDBACK ID :");

        labelFeedSender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFeedSender.setText("FEEDBACK SENDER :");

        labelFeedDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelFeedDate.setText("SENT ON :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("MESSAGE :");

        textFeedArea.setColumns(20);
        textFeedArea.setRows(5);
        textFeedArea.setEditable(false);
        jScrollPane6.setViewportView(textFeedArea);

        jPanel14.setBackground(new java.awt.Color(20, 30, 97));

        tableFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MESSAGE", "DATE", "SENT BY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFeedback.setRowHeight(40);
        tableFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFeedbackMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableFeedback);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14Layout.setHorizontalGroup(
        	jPanel14Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel14Layout.createSequentialGroup()
        			.addGap(18)
        			.addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
        	jPanel14Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel14Layout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel14.setLayout(jPanel14Layout);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13Layout.setHorizontalGroup(
        	jPanel13Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel13Layout.createSequentialGroup()
        			.addGap(223)
        			.addGroup(jPanel13Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(labelFeedID)
        				.addGroup(jPanel13Layout.createSequentialGroup()
        					.addGroup(jPanel13Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel22)
        						.addComponent(labelFeedDate)
        						.addComponent(labelFeedSender))
        					.addGap(82)
        					.addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(260, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
        	jPanel13Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel13Layout.createSequentialGroup()
        			.addGap(61)
        			.addComponent(labelFeedID)
        			.addGap(18)
        			.addGroup(jPanel13Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel14, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel13Layout.createSequentialGroup()
        					.addComponent(labelFeedSender)
        					.addGap(18)
        					.addComponent(labelFeedDate)
        					.addGap(18)
        					.addComponent(jLabel22)
        					.addGap(18)
        					.addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel13.setLayout(jPanel13Layout);

        jTabbedPane1.addTab("FEEDBACK", jPanel13);
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
    

    // LOG OUT
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {
        
        int out = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "SELECT", JOptionPane.YES_NO_OPTION);
        if(out == 0) {
            this.dispose();
            Login log = new Login();
        	log.setVisible(true);
        	log.setLocationRelativeTo(null);
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
				} catch (NumberFormatException | SQLException | NameExistsInArrayException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
			}finally {
				clearSingle();
				tableViewItems("");
		        tableViewPackageSingle();
			}
        }
    }
    
    //```buttons ---- UPDATE ITEM//
    private void buttonItemUpdateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
		try {
			Database.updateItem(inputItemID.getText(), inputSingleName.getText(), Float.parseFloat(inputSinglePrice.getText()));
		} catch (Exception e) {
			JOptionPane.showInputDialog(this, e.getMessage());
		} finally {
			clearSingle();
			tableViewItems("");
	        tableViewPackageSingle();
		}
    }
    
    //```buttons ---- REMOVE ITEM//
    private void buttonItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        try {
        	int choice = JOptionPane.showConfirmDialog(null, "Remove item?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
	        if(choice == JOptionPane.NO_OPTION) {
	        	return;
	        }
        	Item item = Database.getItemByID(inputItemID.getText());
			Database.removeItem(item);
		} catch (SQLException | MenuNotFoundException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}finally {
			clearSingle();
			tableViewItems("");
	        tableViewPackageSingle();
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
        tableItems.clearSelection();
    	clearSingle();
    }

    //```buttons ---- REFRESH ITEM//
    private void buttonItemTableRefreshActionPerformed(java.awt.event.ActionEvent evt) {
    	clearSingle();
		tableViewItems("");
    }
    
    // clear input boxes
    private void clearSingle() {
		inputItemID.setText("" + Database.getLastItemID());
	    inputSingleName.setText(null);
	    inputSinglePrice.setText(null);
    }

    // display data of clicked row in MANAGE SINGLE ITEMS
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

    
	////////////MANAGE PACKAGES////////////////////
    
    // -- CRUD -- //
    
    // display data to table
	private void tableViewPackages() {
		model = (DefaultTableModel) tablePackages.getModel();
    	model.setRowCount(0);
    	Object[] row;
    	for(Package pack: Database.getPack()) {
    		row = new Object[5];
    		row[0] = pack.getId();
            row[1] = pack.getName();
            row[2] = pack.getPrice();
            row[3] = pack.getNumberOfItems();
            row[4] = pack.getDateAdded();
            model.addRow(row);
  		}
    }
  
	
	// display data to table
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
    }
    
    // display data to table
    private void tableViewPackageItem(String id) {
    	DefaultTableModel model = (DefaultTableModel) tablePackageItem.getModel();
    	model.setRowCount(0);
    	Object[] row;
		try {
	    	Package temp = Database.getPackageByID(id);
			Database.loadPackageItemFromDatabase(id);
	    	for(Item i : temp.getPackageitems()) {
	    		row = new Object[3];
	    		row[0] = i.getId();
	    		row[1] = i.getName();
	    		row[2] = i.getPrice();
	    		model.addRow(row);
	    	}
		} catch (MenuNotFoundException e) {
			System.out.println(e.getMessage());
		}
    }
    
    // Fetch data of selected package
    private void tablePackagesMouseClicked(java.awt.event.MouseEvent evt) {
    	model = (DefaultTableModel) tablePackages.getModel();
    	rowIndex = tablePackages.getSelectedRow();
    	
    	inputPackageID.setText(model.getValueAt(rowIndex, 0).toString());
    	inputPackageName.setText(model.getValueAt(rowIndex, 1).toString());
    	inputPackagePrice.setText(model.getValueAt(rowIndex, 2).toString());
    	tableViewPackageItem(inputPackageID.getText());
    }
    
    // Fetch data of selected item
    private void tablePackageSingleMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tablePackageSingle.getModel();
        rowIndex = tablePackageSingle.getSelectedRow();
        
        inputPackageSingleID.setText(model.getValueAt(rowIndex, 0).toString());
    }
    
    // Fetch data of selected package item
    private void tablePackageItemMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tablePackageItem.getModel();
        rowIndex = tablePackageItem.getSelectedRow();
        
        inputPackageSingleID2.setText(model.getValueAt(rowIndex, 0).toString());
    }
    
    //```buttons ---- ADD PACKAGE//
    private void buttonPackageAddActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	String id = "P" + inputNewPackage.getText();
    	try {
    		Package pack = Database.getPackageByID(id);
			JOptionPane.showMessageDialog(this, "Package already exists");
    	} catch (MenuNotFoundException e) {
    		int choice = JOptionPane.showConfirmDialog(null, "Add package?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
	        if(choice == JOptionPane.NO_OPTION) {
	        	return;
	        }
	        try {
	        	Database.addPackage(new Package(id, inputNewPackageName.getText(), 0));
				inputNewPackage.setText("" + Database.getLastPackageID());
				inputNewPackage.setText("" + Database.getLastPackageID());;
	        } catch (NumberFormatException | SQLException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
    	} finally {
        	clearPackages();
			tableViewPackages();
    	}
    }

    //```buttons ---- UPDATE PACKAGE//
    private void buttonPackageUpdateActionPerformed(java.awt.event.ActionEvent evt) throws MenuNotFoundException {
    	
    	if(isEmptyPackage()) {
        	int choice = JOptionPane.showConfirmDialog(null, "Update Package?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
    		if(choice == JOptionPane.NO_OPTION) {
    			return;
    		}
    		updatePackage();
    	} else {
    		JOptionPane.showMessageDialog(this, "Package Name already exists");
    	}
    	
    	clearPackages();
    	tableViewPackages();
    }
    
    private void updatePackage() {
    	try {
			Package temp = Database.getPackageByID(inputPackageID.getText());
			Database.updatePackage(inputPackageID.getText(), inputPackageName.getText(), Float.parseFloat(inputPackagePrice.getText().toString()), tablePackageItem.getRowCount());
		} catch (NumberFormatException | SQLException | MenuNotFoundException | NameExistsInArrayException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
    	tableViewPackages();
    }
    
    //```buttons ---- REMOVE PACKAGE//
    private void buttonPackageRemoveActionPerformed(java.awt.event.ActionEvent evt) {
    	int choice = JOptionPane.showConfirmDialog(null, "Remove Package?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.NO_OPTION) {
			return;
		}
		
    	try {
        	Package pack = Database.getPackageByID(inputPackageID.getText());
			Database.removePackage(pack);
			inputNewPackage.setText("" + Database.getLastPackageID());
		} catch (SQLException | MenuNotFoundException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}finally {
			clearPackages();
			tableViewPackages();
		}
    }
    
    //```buttons ---- ADD ITEM TO PACKAGE//
    private void buttonPackageItemAddActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	int id = Database.getLastPackageItemID();	
		int choice = JOptionPane.showConfirmDialog(null, "Add item to package?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.NO_OPTION) {
        	return;
        }

    	try {
    		Database.loadPackageItemFromDatabase(inputPackageID.getText());
			Package p = Database.getPackageByID(inputPackageID.getText());
			Item i = Database.getItemByID(inputPackageSingleID.getText());
			try {
				Database.addPackageItem(id, p, i);
				updatePackage();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (MenuNotFoundException e) {
			System.out.println(e.getMessage());
		}
    	
    	tableViewPackageItem(inputPackageID.getText());
    	clearPackages();
    }

    //```buttons ---- REMOVE ITEM FROM PACKAGE//
    private void buttonPackageItemRemoveActionPerformed(java.awt.event.ActionEvent evt) {
    		
		int choice = JOptionPane.showConfirmDialog(null, "Remove item from package?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.NO_OPTION) {
        	return;
        }
    	try {
			Package p = Database.getPackageByID(inputPackageID.getText());
			Item i = Database.getItemByID(inputPackageSingleID2.getText());
			try {
				Database.removePackageItem(p, i);
				updatePackage();
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (MenuNotFoundException e) {
			System.out.println(e.getMessage());
		}
    	
    	tableViewPackageItem(inputPackageID.getText());
    	clearPackages();
    }


    // PACKAGE OTHER FUNCTIONS //
        
    // clear input boxes and table selections 
    private void clearPackages() {
    	inputNewPackage.setText("" + Database.getLastPackageID());
    	inputNewPackageName.setText("");
    	inputPackageID.setText("");
    	inputPackageName.setText("");
    	inputPackagePrice.setText("");
    	inputPackageSingleID.setText("");
    	inputPackageSingleID2.setText("");
    	tablePackages.clearSelection();
    	tablePackageSingle.clearSelection();
    	tablePackageItem.clearSelection();
    	model = (DefaultTableModel) tablePackageItem.getModel();
    	model.setRowCount(0);
    }
    
    // check if package input boxes are empty
    public boolean isEmptyPackage() {
        if(inputPackageName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User Name is missing");
            return false;
        }
        if(inputPackagePrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "User Password is missing");
            return false;
        }      
        return true;
    } 
    
    // Only numeric inputs for price
    private void inputSinglePriceKeyTyped(java.awt.event.KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    

	////////////MANAGE USERS////////////////////
    // -- CRUD -- //
        
    // display data to table
    private void tableViewUsers(String searchVal) {
        model = (DefaultTableModel) tableUsers.getModel();
        model.setRowCount(0);
        Object[] row = new Object[8];
        for(UserClass u : Database.getUsers()) {
        	if(u.concatDets().contains(searchVal)) {
        		row[0] = u.getId();
            	row[1] = u.getUserName();
            	row[2] = u.getPassword();
            	row[3] = u.getContact();
            	row[4] = u.getRole();
            	row[5] = u.getUserCreated();
            	row[6] = u.getUserUpdated();
            	row[7] = u.getEditedByID();
            	model.addRow(row);
        	}
        }
    }
    
    // fetch data of selected table row
    private void tableUsersMouseClicked(java.awt.event.MouseEvent evt) {
        model = (DefaultTableModel) tableUsers.getModel();
        rowIndex = tableUsers.getSelectedRow();
        
        inputUserID.setText(model.getValueAt(rowIndex, 0).toString());
        inputUserName.setText(model.getValueAt(rowIndex, 1).toString());
        inputUserPass.setText(model.getValueAt(rowIndex, 2).toString());
        inputUserContact.setText(model.getValueAt(rowIndex, 3).toString());
        if(model.getValueAt(rowIndex, 4).toString().equals("ADMIN")) {
            radioUserAdmin.setSelected(true);
            radioUserRegular.setSelected(false);
        } else {
            radioUserAdmin.setSelected(false);
            radioUserRegular.setSelected(true);
        }
    }

    //```buttons ---- ADD USER//
    private void buttonUserAddActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	if(isEmptyUser()) {
    		try {
    			@SuppressWarnings("unused")
				UserClass u = Database.getUserByID(inputUserName.getText());
				JOptionPane.showMessageDialog(this, "Username already exists");
			} catch (UserNotFoundException e) {
				try {
					int choice = JOptionPane.showConfirmDialog(null, "Add User?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
					if(choice == JOptionPane.NO_OPTION) {
						return;
					}
					
					if(radioUserRegular.isSelected()) {
						Database.addUser(new RegularClass("R" + inputUserID.getText(), inputUserName.getText(), inputUserPass.getText(), inputUserContact.getText(), RegularClass.REGULAR_USER, LocalDateTime.now(), LocalDateTime.now(), temp.getId()));
					} else if(radioUserAdmin.isSelected()) {
						Database.addUser(new AdminClass("A" + inputUserID.getText(), inputUserName.getText(), inputUserPass.getText(), inputUserContact.getText(), AdminClass.ADMIN_USER, LocalDateTime.now(), LocalDateTime.now(), temp.getId()));
					}
				} catch (NumberFormatException | SQLException | NameExistsInArrayException ex) {
					JOptionPane.showMessageDialog(this, ex.getMessage());
					System.out.println(ex.getMessage() + " " + ex.getClass());
				}
			} finally {
				clearUser();
		    	tableViewUsers("");
			}
    	}
    }

    //```buttons ---- UPDATE USER//
    private void buttonUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {
    	
        if(isEmptyUser() && noDupe() == 0) {
        	int choice = JOptionPane.showConfirmDialog(null, "Update User?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
    		if(choice == JOptionPane.NO_OPTION) {
    			return;
    		} 
        	try {
        		if(radioUserAdmin.isSelected()) {
        			Database.updateUser(inputUserID.getText(), inputUserName.getText(), inputUserPass.getText(), inputUserContact.getText(), AdminClass.ADMIN_USER, temp.getId());
        		} else {
        			Database.updateUser(inputUserID.getText(), inputUserName.getText(), inputUserPass.getText(), inputUserContact.getText(), RegularClass.REGULAR_USER, temp.getId());
        		}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
        } else {
        	JOptionPane.showMessageDialog(this, "Username exists");
        }
        clearUser();
        tableViewUsers("");
    }

    //```buttons ---- REMOVE USER//
    private void buttonUserRemoveActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	
    	int choice = JOptionPane.showConfirmDialog(null, "Remove User?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.NO_OPTION) {
			return;
		} 
		try {
			UserClass u = Database.getUserByID(inputUserID.getText());
			Database.removeUser(u);
		} catch (UserNotFoundException | SQLException e) {
			System.out.println(e.getMessage() + " " + e.getClass());
		} finally {
			clearUser();			
			tableViewUsers("");
		}
    }
    
    //```buttons ---- CLEAR USER//
    private void buttonUserClearActionPerformed(java.awt.event.ActionEvent evt) {
    	clearUser();
    }

    //```buttons ---- PRINT USER//
    private void buttonUserPrintActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            MessageFormat header = new MessageFormat("ALL USERS");
            MessageFormat footer = new MessageFormat("Page {0, number, integer}");
            tableUsers.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(AdminClassFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //```buttons ---- SEARCH USER//
    private void buttonUserSearchActionPerformed(java.awt.event.ActionEvent evt) {
    	    	
        if(inputUserSearch.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Input is empty");
        } else {
            tableViewUsers(inputUserSearch.getText());
        }
        clearUser();
    }

    //```buttons ---- REFRESH USER//
    private void buttonUserRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        tableViewUsers("");
        inputUserSearch.setText(null);
        clearUser();
    }
    
    
    // USER OTHER FUNCTIONS //
    
    // clear input boxes and table selections
    private void clearUser() {
        inputUserID.setText("" + Database.getLastUserID());
        inputUserName.setText(null);
        inputUserPass.setText(null);
        inputUserContact.setText(null);
        radioUserRegular.setSelected(true); 
        tableUsers.getSelectionModel().clearSelection();
    }
    
    // check if input boxes are empty
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
    
    // Only numeric inputs for contact
    private void inputUserContactKeyTyped(java.awt.event.KeyEvent evt) {
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }
    
    // check it exists
    private int noDupe() { 	
        String id = null;
        
        for (UserClass user : Database.getUsers()) {
            if (inputUserName.getText().equals(user.getUserName())) {
                id = user.getId();
                break;
            }
        }    
        return (id != null && !id.equals(inputUserID.getText())) ? 1 : 0;
    }
    
    
    
	////////////MANAGE FEEDBACK////////////////////
    
    private void tableViewFeedbacks() {
    	model = (DefaultTableModel) tableFeedback.getModel();
    	model.setRowCount(0);
    	Object[] row = new Object[4];
    	for(Feedbacks f : Database.getFeedback()) {     	
    		row[0] = f.getId();
    		row[1] = f.getMessage();
    		row[2] = f.getDateAdded();
    		row[3] = f.getUserID();
    		model.addRow(row);
    	}
    }
    
    
    private void tableFeedbackMouseClicked(java.awt.event.MouseEvent evt) {
    	model = (DefaultTableModel) tableFeedback.getModel();
    	rowIndex = tableFeedback.getSelectedRow();
    	UserClass u;
		try {
			u = Database.getUserByID(model.getValueAt(rowIndex, 3).toString());
	    	
	    	labelFeedID.setText("FEEDBACK ID :              " + model.getValueAt(rowIndex, 0));
	    	labelFeedSender.setText("FEEDBACK SENDER :   " + model.getValueAt(rowIndex, 3).toString() + " | " + u.getUserName());
	    	labelFeedDate.setText("SENT ON :                   " + model.getValueAt(rowIndex, 2));
	    	textFeedArea.setText(model.getValueAt(rowIndex, 1).toString());
	    	
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    
    
 
    private javax.swing.JButton buttonAddNewItem;
    private javax.swing.JButton buttonClearInputItem;
    private javax.swing.JButton buttonItemPrint;
    private javax.swing.JButton buttonItemRemove;
    private javax.swing.JButton buttonItemSearch;
    private javax.swing.JButton buttonItemTableRefresh;
    private javax.swing.JButton buttonItemUpdate;
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JButton buttonPackageAdd;
    private javax.swing.JButton buttonPackageItemAdd;
    private javax.swing.JButton buttonPackageItemRemove;
    private javax.swing.JButton buttonPackageRemove;
    private javax.swing.JButton buttonPackageUpdate;
    private javax.swing.JButton buttonUserAdd;
    private javax.swing.JButton buttonUserClear;
    private javax.swing.JButton buttonUserPrint;
    private javax.swing.JButton buttonUserRefresh;
    private javax.swing.JButton buttonUserRemove;
    private javax.swing.JButton buttonUserSearch;
    private javax.swing.JButton buttonUserUpdate;
    private javax.swing.JTextField inputItemID;
    private javax.swing.JTextField inputNewPackage;
    private javax.swing.JTextField inputNewPackageName;
    private javax.swing.JTextField inputPackageID;
    private javax.swing.JTextField inputPackageName;
    private javax.swing.JTextField inputPackagePrice;
    private javax.swing.JTextField inputPackageSingleID;
    private javax.swing.JTextField inputPackageSingleID2;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelFeedDate;
    private javax.swing.JLabel labelFeedID;
    private javax.swing.JLabel labelFeedSender;
    private javax.swing.JRadioButton radioUserAdmin;
    private javax.swing.JRadioButton radioUserRegular;
    private javax.swing.JTable tableFeedback;
    private javax.swing.JTable tableItems;
    private javax.swing.JTable tablePackageItem;
    private javax.swing.JTable tablePackageSingle;
    private javax.swing.JTable tablePackages;
    private javax.swing.JTable tableUsers;
    private javax.swing.JTextArea textFeedArea;
}
