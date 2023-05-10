
package cis2103;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import exceptions.MenuNotFoundException;
import model.Database;
import model.Feedbacks;
import model.Menu;
import model.Order;
import model.Package;
import model.RegularClass;
import model.UserClass;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class RegularClassFrame extends javax.swing.JFrame {

    ArrayList<Menu> oi = new ArrayList<>();
    private DefaultTableModel model;
    int rowIndex1, rowIndex2, rowIndex3;
    Order o = new Order();
    private static RegularClass temp;

    
    public RegularClassFrame(UserClass user) {
        initComponents();
//        

        tableViewRegOne();
        tableViewRegTwo();
        tableViewRegItem();
        tableViewFeedbacks();
        
        
        ButtonGroup custOrderBG = new ButtonGroup();
        custOrderBG.add(radioRegDigital);
        custOrderBG.add(radioRegPhysical);
        ButtonGroup custModeBG = new ButtonGroup();
        custModeBG.add(radioRegPickup);
        custModeBG.add(radioRegDeliver);
        
        try {
			inputRegTrans.setText(String.valueOf(Database.getNextOIID()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        inputRegTrans.setEditable(false);
        inputRegTotal.setEditable(false);
        inputRegChange.setEditable(false); 
        
        temp = (RegularClass) user;
    }


    @SuppressWarnings("unchecked")
                         
    private void initComponents() {
    	
    	jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRegItems = new javax.swing.JTable();
        buttonRegUpdate = new javax.swing.JButton();
        buttonRegRemove = new javax.swing.JButton();
        inputRegTemp = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegOne = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRegTwo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputRegTrans = new javax.swing.JTextField();
        inputRegName = new javax.swing.JTextField();
        inputRegAdd = new javax.swing.JTextField();
        inputRegNum = new javax.swing.JTextField();
        radioRegDigital = new javax.swing.JRadioButton();
        radioRegPhysical = new javax.swing.JRadioButton();
        radioRegPickup = new javax.swing.JRadioButton();
        radioRegDeliver = new javax.swing.JRadioButton();
        spinnerOne = new javax.swing.JSpinner();
        inputRegOne = new javax.swing.JTextField();
        spinnerTwo = new javax.swing.JSpinner();
        inputRegTwo = new javax.swing.JTextField();
        buttonRegAddOne = new javax.swing.JButton();
        buttonRegAddTwo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inputRegTotal = new javax.swing.JTextField();
        inputRegAmount = new javax.swing.JTextField();
        inputRegChange = new javax.swing.JTextField();
        buttonRegPay = new javax.swing.JButton();
        buttonRegPrint = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textFeedArea = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableFeedbacks = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        buttonFeedSend = new javax.swing.JButton();

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

        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SYSTEM | REGULAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1720, 762));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1720, 762));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1720, 762));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1720, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("WELCOME", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(20, 30, 97));

        tableRegItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "QUANTITY", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegItems.setRowHeight(40);
        tableRegItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegItemsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableRegItems);

        buttonRegUpdate.setText("UPDATE");
        buttonRegUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegUpdateActionPerformed(evt);
            }
        });

        buttonRegRemove.setText("REMOVE");
        buttonRegRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(inputRegTemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(buttonRegUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonRegRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputRegTemp)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(buttonRegUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonRegRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(20, 30, 97));

        tableRegOne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MENU ID", "ID", "NAME", "VALUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegOne.setRowHeight(40);
        tableRegOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegOneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRegOne);

        tableRegTwo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "QUANTITY", "VALUE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegTwo.setRowHeight(40);
        tableRegTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegTwoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableRegTwo);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Order # :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Customer Name :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Address :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Contact # :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Ordered :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Mode :");

//        inputRegNum.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyTyped(java.awt.event.KeyEvent evt) {
//                inputRegNumKeyTyped(evt);
//            }
//        });
        
        inputRegNum.addKeyListener(new java.awt.event.KeyAdapter() {
        	public void keyPressed(java.awt.event.KeyEvent evt) {
        		inputRegAmountKeyPressed(evt);
        	}
        });

        radioRegDigital.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioRegDigital.setText("DIGITAL");

        radioRegPhysical.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioRegPhysical.setText("PHYSICAL");

        radioRegPickup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioRegPickup.setText("PICK-UP");

        radioRegDeliver.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radioRegDeliver.setText("DELIVERY");

        buttonRegAddOne.setText("ADD");
        buttonRegAddOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegAddOneActionPerformed(evt);
            }
        });

        buttonRegAddTwo.setText("ADD");
        buttonRegAddTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegAddTwoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("TOTAL");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("AMOUNT");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("CHANGE");
        
        inputRegTotal.setText("0.00");

        inputRegAmount.setText("0.00");

        inputRegChange.setText("0.00");

        buttonRegPay.setText("PAY");
        buttonRegPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegPayActionPerformed(evt);
            }
        });

        buttonRegPrint.setText("PRINT");
        buttonRegPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4Layout.setHorizontalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addGap(48)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3)
        				.addComponent(jLabel4)
        				.addComponent(jLabel5)
        				.addComponent(jLabel6)
        				.addComponent(jLabel7))
        			.addGap(25)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(inputRegTrans)
        					.addComponent(inputRegName)
        					.addComponent(inputRegAdd)
        					.addComponent(inputRegNum, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(radioRegDigital)
        						.addComponent(radioRegPickup))
        					.addGap(41)
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(radioRegDeliver)
        						.addComponent(radioRegPhysical))))
        			.addGap(12)
        			.addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addGap(41)
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(jPanel4Layout.createSequentialGroup()
        							.addComponent(jLabel8)
        							.addGap(40)
        							.addComponent(inputRegTotal, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
        						.addGroup(jPanel4Layout.createSequentialGroup()
        							.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jLabel9)
        								.addComponent(jLabel10))
        							.addGap(18)
        							.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(inputRegAmount)
        								.addComponent(inputRegChange))))
        					.addGap(30)
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(buttonRegPay, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonRegPrint, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)))
        			.addGap(20))
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addGap(595)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(buttonRegAddOne, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        				.addComponent(inputRegOne))
        			.addGap(18)
        			.addComponent(spinnerOne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(147)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(buttonRegAddTwo, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        				.addComponent(inputRegTwo))
        			.addGap(18)
        			.addComponent(spinnerTwo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(0, 577, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addGap(62)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(inputRegTrans, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(inputRegName, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(inputRegAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(inputRegNum, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(radioRegDigital)
        				.addComponent(radioRegPhysical))
        			.addGap(18)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(radioRegPickup)
        				.addComponent(radioRegDeliver))
        			.addContainerGap(358, Short.MAX_VALUE))
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel8)
        						.addComponent(inputRegTotal, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addGap(10)
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(spinnerOne, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        						.addComponent(inputRegOne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(inputRegTwo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(spinnerTwo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(buttonRegAddOne, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        						.addComponent(buttonRegAddTwo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addGap(18, 18, Short.MAX_VALUE)
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel9)
        						.addComponent(inputRegAmount, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonRegPay, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel10)
        						.addComponent(inputRegChange, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(buttonRegPrint, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))))
        			.addGap(43))
        );
        jPanel4.setLayout(jPanel4Layout);

        jTabbedPane1.addTab("SYSTEM", jPanel4);
        
        
        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel11.setText("SEND A FEEDBACK");

        textFeedArea.setColumns(20);
        textFeedArea.setRows(5);
        jScrollPane4.setViewportView(textFeedArea);

        jPanel8.setBackground(new java.awt.Color(20, 30, 97));

        tableFeedbacks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MESSAGE", "SENT ON"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFeedbacks.setRowHeight(40);
        jScrollPane5.setViewportView(tableFeedbacks);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("ENTER YOUR MESSAGE :");

        buttonFeedSend.setText("SEND");
        buttonFeedSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFeedSendActionPerformed(evt);
            }
        });
        

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(buttonFeedSend, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonFeedSend, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SEND FEEDBACK", jPanel7);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	int out = JOptionPane.showConfirmDialog(this, "Do you want to log out?", "SELECT", JOptionPane.YES_NO_OPTION);
        if(out == 0) {
            Login log = new Login();
        	log.setVisible(true);
        	log.setLocationRelativeTo(null);
        	this.dispose();
        }
    }
    
    private void tableViewRegOne() {
    	model = (DefaultTableModel) tableRegOne.getModel();
    	Object[] row = new Object[4];
    	    	
    	for(Menu i : Database.getMenu()) {
			row[0] = i.getMenuID();
    		row[1] = i.getId();
			row[2] = i.getName();
			row[3] = i.getPrice();
			model.addRow(row);
		}
    }
    
    private void tableViewRegTwo() {
        model = (DefaultTableModel) tableRegTwo.getModel();   
    	Object[] row = new Object[3];
    	
    	for(Package p : Database.getPack()) {
    		row[0] = p.getId();
    		row[1] = p.getName();
    		row[2] = p.getPrice();
    		model.addRow(row);
    	}
    }
    
    private void tableViewRegItem() {
        
        model = (DefaultTableModel) tableRegItems.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];

        for(Menu m : oi) {
        	row[0] = m.getName();
        	row[1] = m.getQuantity();
        	row[2] = m.getPrice() * m.getQuantity();
        	model.addRow(row);
        }
    }
    
    private void tableRegOneMouseClicked(java.awt.event.MouseEvent evt) {                                            
        model = (DefaultTableModel) tableRegOne.getModel();
        rowIndex1 = tableRegOne.getSelectedRow();

        inputRegOne.setText(model.getValueAt(rowIndex1, 1).toString());
        spinnerOne.setValue(1);        
        inputRegTwo.setText("");
        spinnerTwo.setValue(0);
        tableRegTwo.clearSelection();
        tableRegOne.clearSelection();
    }                                           

    private void tableRegTwoMouseClicked(java.awt.event.MouseEvent evt) {                                             
        model = (DefaultTableModel) tableRegTwo.getModel();
        rowIndex2 = tableRegTwo.getSelectedRow();
        
        inputRegTwo.setText(model.getValueAt(rowIndex2, 1).toString());
        spinnerTwo.setValue(1);       
        inputRegOne.setText("");
        spinnerOne.setValue(0);
        tableRegOne.clearSelection();
        tableRegItems.clearSelection();
    }                                            

    private void tableRegItemsMouseClicked(java.awt.event.MouseEvent evt) {                                           
        
        model = (DefaultTableModel) tableRegItems.getModel();
        rowIndex3 = tableRegItems.getSelectedRow();
        
        jSpinner1.setValue(model.getValueAt(rowIndex3, 1));
        inputRegTemp.setText(model.getValueAt(rowIndex3, 0).toString());   
        inputRegTwo.setText("");
        spinnerTwo.setValue(0);
        inputRegOne.setText("");
        spinnerOne.setValue(0);
        tableRegOne.clearSelection();
        tableRegTwo.clearSelection();
    }      
    
    private void clearReg() {
    	
        inputRegTwo.setText("");
        spinnerTwo.setValue(0);
        inputRegOne.setText("");
        spinnerOne.setValue(0);
        inputRegTemp.setText("");
        jSpinner1.setValue(0);
        tableRegOne.clearSelection();
        tableRegTwo.clearSelection();
	    tableRegItems.clearSelection();
    }

    private void buttonRegAddOneActionPerformed(java.awt.event.ActionEvent evt) {                                              

    	model = (DefaultTableModel) tableRegOne.getModel();
    	int i, exist = 0;
    	int tempQty = Integer.parseInt(spinnerOne.getValue().toString());
    	try {
    	    
       		o.setId(Integer.parseInt(inputRegTrans.getText()));
    		o.setMenuOrders(oi);			
    		Menu temp = Database.getMenuByID((model.getValueAt(rowIndex1, 1).toString()));
    		
            for(i = 0; i < oi.size(); i++) {
                if(temp.getName().equals(oi.get(i).getName())) {
                    exist = 1;
                    break;
                } else {
                    exist = 0;
                }
            }
            
            if(exist == 1) {
            	oi.get(i).setQuantity(oi.get(i).getQuantity() + tempQty);
            } else {
            	temp.setQuantity(tempQty);
            	oi.add(temp);
            }
           
		} catch (NumberFormatException | MenuNotFoundException e) {
			e.printStackTrace();
		}
    	
    	tableViewRegItem();
	    inputRegTotal.setText(Float.toString(currentTotal()));
	    inputRegChange.setText(Float.toString(showChange()));
	    clearReg();
	
    }                                             

    private void buttonRegAddTwoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
//        int i, exist = 0;
//        model = (DefaultTableModel) tableRegTwo.getModel();
//        SaleItem si = new SaleItem();
//        
//        si.itemName = inputRegTwo.getText();
//        si.itemQty = Integer.parseInt(spinnerTwo.getValue().toString());
//        si.itemPrice = Float.parseFloat(model.getValueAt(rowIndex2, 2).toString());
//        si.subTotal = si.itemQty * si.itemPrice;
//                
//        for(i = 0; i < saleitems.size(); i++) {
//            if(saleitems.get(i).itemName.equals(si.itemName)) {
//                exist = 1;
//                break;
//            } else {
//                exist = 0;
//            }
//        }
//        
//        if(exist == 1) {
//            saleitems.get(i).itemQty += si.itemQty;
//            saleitems.get(i).subTotal += si.subTotal;
//        } else {
//            saleitems.add(si);
//        }
//
//        model = (DefaultTableModel) tableRegItems.getModel();
//        model.setRowCount(0);
//        Object[] rowData = new Object[3];
//        for(i = 0; i < saleitems.size(); i++) {
//            rowData[0] = saleitems.get(i).itemName;
//            rowData[1] = saleitems.get(i).itemQty;
//            rowData[2] = saleitems.get(i).subTotal;
//            model.addRow(rowData);
//        }
//        
//        inputRegTotal.setText(Float.toString(currentTotal()));
//        inputRegChange.setText(Float.toString(showChange()));
//        tableRegOne.clearSelection();
//        tableRegTwo.clearSelection();
//        tableRegItems.clearSelection(); 
    }                                             

    private void buttonRegUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
    	int choice = JOptionPane.showConfirmDialog(null, "Update Order Item?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.NO_OPTION) {
			return;
		} 
        String tempName = model.getValueAt(rowIndex3, 0).toString();
        int tempQty = Integer.parseInt(jSpinner1.getValue().toString());

        for(Menu m : oi) {
        	if(m.getName().equals(tempName)) {
        		m.setQuantity(tempQty);        		
        	}
        } 
        tableViewRegItem();
        inputRegTotal.setText(Float.toString(currentTotal()));
        inputRegChange.setText(Float.toString(showChange()));
        clearReg();
        
    }                                               

    private void buttonRegRemoveActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	int choice = JOptionPane.showConfirmDialog(null, "Remove Order Item?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.NO_OPTION) {
			return;
		} 
		
        model = (DefaultTableModel) tableRegItems.getModel();
        String tempName = model.getValueAt(rowIndex3, 0).toString();
        for(Menu m : oi) {
        	if(m.getName().equals(tempName)) {
        		oi.remove(m);
        		break;
        	}
        } 
        
        tableViewRegItem();
        clearReg();
        inputRegTotal.setText(Float.toString(currentTotal()));
        inputRegChange.setText(Float.toString(showChange()));
    
    }                                               

    private void buttonRegPayActionPerformed(java.awt.event.ActionEvent evt) {                                             

//
//	    if(radioRegDigital.isSelected()) {
//	    	o.setOrderMethod(Order.ONLINE);
//	    } if(radioRegPhysical.isSelected()) {
//	    	o.setOrderMethod(Order.PHYSICAL);
//	    }
//	    if(radioRegPickup.isSelected()) {
//	    	o.setDeliveryMethod(Order.PICKUP);
//	    } else if(radioRegDeliver.isSelected()) {
//	    	o.setDeliveryMethod(Order.DELIVER);
//	    }
//
//    	try {
//    		o.setId(Integer.parseInt(inputRegTrans.getText()));
//    		o.setTotal(Float.parseFloat(inputRegTotal.getText()));
//    		o.setMenuOrders(oi);
//			Database.addOrder(o);
//			for(Menu m : oi) {
//				Database.addOrderItems(o, m.getMenuID());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
    }                                            

    private void buttonRegPrintActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void inputRegAmountKeyPressed(java.awt.event.KeyEvent evt) {                                          
        try {
        	if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                inputRegChange.setText(Float.toString(showChange()));
        	}
        } catch (Exception e) {
            System.out.println("lawl");
        }
    }                                         

    public boolean isEmpty() {
        if(inputRegName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Customer Name is missing");
            return false;
        }
        if(inputRegAdd.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Customer Address is missing");
            return false;
        }
        if(inputRegNum.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Customer Number is missing");
            return false;
        }
        return true;
    }
    
    public float currentTotal() {
        int i;
        float total = 0;
        for(i = 0; i < oi.size(); i++) {
            total += oi.get(i).getPrice();
        }
        return total;
    }
    
    public float showChange() {
        float change = 0;
        float amount = Float.parseFloat(inputRegAmount.getText());
        float total = currentTotal();
        if(inputRegAmount.getText().equals("")) {
            inputRegChange.setText(Float.toString(change));
        } else {
            change = amount - total;
        }
        return change;
    }
    
    
    
	////////////SEND A FEEDBACK////////////////////
    
    private void tableViewFeedbacks() {
    	model = (DefaultTableModel) tableFeedbacks.getModel();
    	model.setRowCount(0);
    	Object[] row = new Object[3];
    	for(Feedbacks f : Database.getFeedback()) {     	
    		row[0] = f.getId();
    		row[1] = f.getMessage();
    		row[2] = f.getDateAdded();
    		model.addRow(row);
    	}
    	
    }
    
    private void buttonFeedSendActionPerformed(java.awt.event.ActionEvent evt) {  
    	Feedbacks feed;
		try {
	    	int choice = JOptionPane.showConfirmDialog(null, "Send Message?", "Add Confirmation", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.NO_OPTION) {
				return;
			} 
			feed = new Feedbacks(Database.getLastFeedbackID(), temp.getId(), textFeedArea.getText(), LocalDateTime.now());
	    	Database.addFeedback(feed);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableViewFeedbacks();
    } 
    
                   
    private javax.swing.JButton buttonFeedSend;
    private javax.swing.JButton buttonRegAddOne;
    private javax.swing.JButton buttonRegAddTwo;
    private javax.swing.JButton buttonRegPay;
    private javax.swing.JButton buttonRegPrint;
    private javax.swing.JButton buttonRegRemove;
    private javax.swing.JButton buttonRegUpdate;
    private javax.swing.JTextField inputRegAdd;
    private javax.swing.JTextField inputRegAmount;
    private javax.swing.JTextField inputRegChange;
    private javax.swing.JTextField inputRegName;
    private javax.swing.JTextField inputRegNum;
    private javax.swing.JTextField inputRegOne;
    private javax.swing.JTextField inputRegTemp;
    private javax.swing.JTextField inputRegTotal;
    private javax.swing.JTextField inputRegTrans;
    private javax.swing.JTextField inputRegTwo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radioRegDeliver;
    private javax.swing.JRadioButton radioRegDigital;
    private javax.swing.JRadioButton radioRegPhysical;
    private javax.swing.JRadioButton radioRegPickup;
    private javax.swing.JSpinner spinnerOne;
    private javax.swing.JSpinner spinnerTwo;
    private javax.swing.JTable tableFeedbacks;
    private javax.swing.JTable tableRegItems;
    private javax.swing.JTable tableRegOne;
    private javax.swing.JTable tableRegTwo;
    private javax.swing.JTextArea textFeedArea;            
}
