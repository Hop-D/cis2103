
package cis2103;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Janica Nyle Pino
 */
public class RegularClassFrame extends javax.swing.JFrame {

   
    private DefaultTableModel model;
    int rowIndex1, rowIndex2, rowIndex3;
    
    public RegularClassFrame() {
        initComponents();
//        
//        tableViewRegSingle();
//        tableViewRegPackage();
        tableViewRegItem();
        
        ButtonGroup custOrderBG = new ButtonGroup();
        custOrderBG.add(radioRegDigital);
        custOrderBG.add(radioRegPhysical);
        ButtonGroup custModeBG = new ButtonGroup();
        custModeBG.add(radioRegPickup);
        custModeBG.add(radioRegDeliver);
        
    //    inputRegTrans.setText(String.valueOf(reg.getMax()));
        inputRegTotal.setEditable(false);
        inputRegChange.setEditable(false);
    }


    @SuppressWarnings("serial")
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        inputRegtemp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonRegUpdate = new javax.swing.JButton();
        buttonRegRemove = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegSingle = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRegPackage = new javax.swing.JTable();
        buttonRegAddP = new javax.swing.JButton();
        spinnerPackage = new javax.swing.JSpinner();
        inputRegPackage = new javax.swing.JTextField();
        spinnerSingle = new javax.swing.JSpinner();
        inputRegSingle = new javax.swing.JTextField();
        buttonRegAddS = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        inputRegTrans = new javax.swing.JTextField();
        inputRegName = new javax.swing.JTextField();
        inputRegAdd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputRegNum = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        radioRegDigital = new javax.swing.JRadioButton();
        radioRegPhysical = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        radioRegPickup = new javax.swing.JRadioButton();
        radioRegDeliver = new javax.swing.JRadioButton();
        buttonRegPay = new javax.swing.JButton();
        inputRegPrint = new javax.swing.JButton();
        inputRegChange = new javax.swing.JTextField();
        inputRegAmount = new javax.swing.JTextField();
        inputRegTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1400, 700));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("WELCOME", jPanel3);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "QUANTITY", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
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
        jScrollPane3.setViewportView(tableItems);

        inputRegtemp.setText("jTextField4");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Qty");

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

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(inputRegtemp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRegUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRegRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRegtemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(buttonRegUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRegRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 51));

        tableRegSingle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "ITEM NAME", "ITEM PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegSingle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegSingleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRegSingle);

        tableRegPackage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PACKAGE ID", "PACKAGE NAME", "PACKAGE PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRegPackage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegPackageMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableRegPackage);

        buttonRegAddP.setText("ADD");
        buttonRegAddP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegAddPActionPerformed(evt);
            }
        });

        spinnerPackage.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinnerSingle.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        buttonRegAddS.setText("ADD");
        buttonRegAddS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegAddSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonRegAddS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(inputRegSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spinnerSingle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonRegAddP, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(inputRegPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spinnerPackage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputRegPackage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRegAddP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputRegSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRegAddS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Transaction #");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Customer Name");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Contact Number");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Address");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Ordered");

        radioRegDigital.setText("Digital");

        radioRegPhysical.setText("Physical");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Mode");

        radioRegPickup.setText("Pick-up");

        radioRegDeliver.setText("Deliver");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioRegDigital)
                            .addComponent(radioRegPickup))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioRegPhysical)
                            .addComponent(radioRegDeliver))
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputRegName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(inputRegTrans)
                            .addComponent(inputRegAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inputRegNum, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(65, 65, 65))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRegTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRegName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRegAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputRegNum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(radioRegDigital)
                    .addComponent(radioRegPhysical))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(radioRegPickup)
                    .addComponent(radioRegDeliver))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonRegPay.setText("PAY");
        buttonRegPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegPayActionPerformed(evt);
            }
        });

        inputRegPrint.setText("PRINT");
        inputRegPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputRegPrintActionPerformed(evt);
            }
        });

        inputRegChange.setText("0.00");

        inputRegAmount.setText("0.00");
        inputRegAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputRegAmountKeyPressed(evt);
            }
        });

        inputRegTotal.setText("0.00");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("TOTAL");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("AMOUNT");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("CHANGE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputRegTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(inputRegAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(buttonRegPay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(inputRegChange, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(inputRegPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(612, 612, 612)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputRegTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRegPay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputRegAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputRegPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputRegChange, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("SYSTEM", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }                        

//    private void tableViewRegSingle() {
//        reg.getRegSingle(tableRegSingle, "");
//        model = (DefaultTableModel) tableRegSingle.getModel();
//    }
//    
//    private void tableViewRegPackage() {
//        reg.getRegPackage(tableRegPackage, "");
//        model = (DefaultTableModel) tableRegPackage.getModel();   
//    }
    
    private void tableViewRegItem() {
        //reg.getRegItem(tableItems, "");
        
//        model = (DefaultTableModel) tableItems.getModel();
//        Object[] rowData = new Object[3];
//        for(int i = 0; i < saleitems.size(); i++) {
//            rowData[0] = saleitems.get(i).itemName;
//            rowData[1] = saleitems.get(i).itemQty;
//            rowData[2] = saleitems.get(i).subTotal;
//            model.addRow(rowData);
//        }

    }
    
    private void tableRegSingleMouseClicked(java.awt.event.MouseEvent evt) {                                            
        model = (DefaultTableModel) tableRegSingle.getModel();
        rowIndex1 = tableRegSingle.getSelectedRow();
        
        inputRegSingle.setText(model.getValueAt(rowIndex1, 1).toString());
        spinnerSingle.setValue(1);
        
        inputRegPackage.setText("");
        spinnerPackage.setValue(0);
        tableRegPackage.clearSelection();
        tableItems.clearSelection();
    }                                           

    private void tableRegPackageMouseClicked(java.awt.event.MouseEvent evt) {                                             
        model = (DefaultTableModel) tableRegPackage.getModel();
        rowIndex2 = tableRegPackage.getSelectedRow();
        
        inputRegPackage.setText(model.getValueAt(rowIndex2, 1).toString());
        spinnerPackage.setValue(1);
        
        inputRegSingle.setText("");
        spinnerSingle.setValue(0);
        tableRegSingle.clearSelection();
        tableItems.clearSelection();
    }                                            

    private void tableItemsMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // TODO add your handling code here:
        
        model = (DefaultTableModel) tableItems.getModel();
        rowIndex3 = tableItems.getSelectedRow();
        
        jSpinner1.setValue(model.getValueAt(rowIndex3, 1));
        
        inputRegPackage.setText("");
        spinnerPackage.setValue(0);
        inputRegSingle.setText("");
        spinnerSingle.setValue(0);
        tableRegSingle.clearSelection();
        tableRegPackage.clearSelection();
    }                                          

    private void buttonRegAddSActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
//        int i, exist = 0;
//        model = (DefaultTableModel) tableRegSingle.getModel();
//        SaleItem si = new SaleItem();
//        
//        si.itemName = inputRegSingle.getText();
//        si.itemQty = Integer.parseInt(spinnerSingle.getValue().toString());
//        si.itemPrice = Integer.parseInt(model.getValueAt(rowIndex1, 2).toString());
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
//        model = (DefaultTableModel) tableItems.getModel();
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
//        tableRegSingle.clearSelection();
//        tableRegPackage.clearSelection();
//        tableItems.clearSelection();
        
    }                                             

    private void buttonRegAddPActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
//        int i, exist = 0;
//        model = (DefaultTableModel) tableRegPackage.getModel();
//        SaleItem si = new SaleItem();
//        
//        si.itemName = inputRegPackage.getText();
//        si.itemQty = Integer.parseInt(spinnerPackage.getValue().toString());
//        si.itemPrice = Integer.parseInt(model.getValueAt(rowIndex2, 2).toString());
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
//        model = (DefaultTableModel) tableItems.getModel();
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
//        tableRegSingle.clearSelection();
//        tableRegPackage.clearSelection();
//        tableItems.clearSelection(); 
    }                                             

    private void buttonRegUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
//        int i;
//        String tempName = model.getValueAt(rowIndex3, 0).toString();
//        int tempQty = Integer.parseInt(jSpinner1.getValue().toString());
//        
//        for(i = 0; i < saleitems.size(); i++) {
//            if(saleitems.get(i).itemName.equals(tempName)) {
//                saleitems.get(i).itemQty = tempQty;
//                saleitems.get(i).subTotal = saleitems.get(i).itemQty * saleitems.get(i).itemPrice;
//            }
//        }
//        
//        model = (DefaultTableModel) tableItems.getModel();
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
        
    }                                               

    private void buttonRegRemoveActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
//        int i;
//        model = (DefaultTableModel) tableItems.getModel();
//        String tempName = model.getValueAt(rowIndex3, 0).toString();
//        
//        int choice = JOptionPane.showConfirmDialog(this, "Remove item?");
//        
//        if(choice == JOptionPane.OK_OPTION) {
//            for(i = 0; i < saleitems.size(); i++) {
//                if(saleitems.get(i).itemName.equals(tempName)) {
//                    saleitems.remove(i);
//                }
//            }
//        }
//        
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
    
    }                                               

    private void buttonRegPayActionPerformed(java.awt.event.ActionEvent evt) {                                             
//        // TODO add your handling code here:
//        
////        int saleID = reg.getMax();
//        String custName = inputRegName.getText().toString();
//        String custAdd = inputRegAdd.getText().toString();
//        String custNum = inputRegNum.getText().toString();
//        String custOrder = "";
//        if(radioRegDigital.isSelected()) {
//            custOrder = "digital";
//        } if(radioRegPhysical.isSelected()) {
//            custOrder = "physical";
//        }
//        String custMode = "";
//        if(radioRegPickup.isSelected()) {
//            custMode = "pickup";
//        } else if(radioRegDeliver.isSelected()) {
//            custMode = "deliver";
//        }
//        int itemCount = saleitems.size();
//        float total = currentTotal(); 
//        float amount = Float.parseFloat(inputRegAmount.getText());
//        float change = showChange();
//        
//        reg.insertSale(saleID, custName, custAdd, custNum, custOrder, custMode, itemCount, total, amount, change);
//        reg.insertSaleItem(saleitems, saleID);
//
//        saleitems.clear();
//        model = (DefaultTableModel) tableItems.getModel();
//        model.setRowCount(0);
        
    }                                            

    private void inputRegPrintActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void inputRegAmountKeyPressed(java.awt.event.KeyEvent evt) {                                          
        try {
            inputRegChange.setText(Float.toString(showChange()));
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
//        int i;
        float total = 0;
//        for(i = 0; i < saleitems.size(); i++) {
//            total += saleitems.get(i).subTotal;
//        }
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
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegularClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegularClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegularClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegularClassFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegularClassFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton buttonRegAddP;
    private javax.swing.JButton buttonRegAddS;
    private javax.swing.JButton buttonRegPay;
    private javax.swing.JButton buttonRegRemove;
    private javax.swing.JButton buttonRegUpdate;
    private javax.swing.JTextField inputRegAdd;
    private javax.swing.JTextField inputRegAmount;
    private javax.swing.JTextField inputRegChange;
    private javax.swing.JTextField inputRegName;
    private javax.swing.JTextField inputRegNum;
    private javax.swing.JTextField inputRegPackage;
    private javax.swing.JButton inputRegPrint;
    private javax.swing.JTextField inputRegSingle;
    private javax.swing.JTextField inputRegTotal;
    private javax.swing.JTextField inputRegTrans;
    private javax.swing.JTextField inputRegtemp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radioRegDeliver;
    private javax.swing.JRadioButton radioRegDigital;
    private javax.swing.JRadioButton radioRegPhysical;
    private javax.swing.JRadioButton radioRegPickup;
    private javax.swing.JSpinner spinnerPackage;
    private javax.swing.JSpinner spinnerSingle;
    private javax.swing.JTable tableItems;
    private javax.swing.JTable tableRegPackage;
    private javax.swing.JTable tableRegSingle;                  
}
