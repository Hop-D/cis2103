
package cis2103;

import java.sql.SQLException;
import javax.swing.JOptionPane;

import exceptions.UserNotFoundException;
import model.Database;
import model.UserClass;

/**
 *
 * @author Janica Nyle Pino
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
		boolean connected = false;
		while (!connected) {
	        try {
	            Database.loadUsersFromDatabase();
	            Database.loadMenuFromDatabase();
	            Database.loadItemsFromDatabase();
	            Database.loadPackageFromDatabase();
	            connected = true;
	        } catch (SQLException e) {
	            String[] options = {"Try Again", "Exit"};
	            int choice = javax.swing.JOptionPane.showOptionDialog(null, "Database Error. Try again once connected.", "Database Error", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	            System.out.println(e.getMessage());
	            if (choice == 1) {
	                return;
	            }
	        }
	    }
		
        initComponents();
        
        labelUN.setVisible(false);
        labelUP.setVisible(false);
//        ArrayList<Item> items = Database.getItems();
//        for(Item i: items) {
//        	System.out.println(i.getId() + " "+ i.getDateAdded() + " " + i.getDateUpdated());
//        }
    }


    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputLoginUN = new javax.swing.JTextField();
        inputLoginUP = new javax.swing.JPasswordField();
        labelUN = new javax.swing.JLabel();
        labelUP = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("LOG IN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("USERNAME");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("PASSWORD");

        labelUN.setText("Input is empty");

        labelUP.setText("Input is empty");

        buttonLogin.setText("LOG IN");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(434, 434, 434)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelUN)
                                .addComponent(labelUP)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inputLoginUP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(86, 86, 86)
                                    .addComponent(inputLoginUN, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(inputLoginUN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUN)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputLoginUP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(labelUP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        
    	
    	
        labelUN.setVisible(false);
        labelUP.setVisible(false);
        
        String username = inputLoginUN.getText();
        String password = String.valueOf(inputLoginUP.getPassword());
        
        if(username.equals("")) {
            labelUN.setVisible(true);
        }

        if(password.equals("")) {
            labelUP.setVisible(true);
        }

        else {
        	try {
				UserClass temp = loginUser(username, password);
				if(temp.getRole().equals(UserClass.ADMIN_USER)) {
					new AdminClassFrame(temp).setVisible(true);
					this.dispose();
				}else {
					new RegularClassFrame().setVisible(true);
					this.dispose();
				}
			} catch (UserNotFoundException e) {
				JOptionPane.showMessageDialog(this, "Credentials incorrect. Please contact administrator.");
			}
        }
    }//GEN-LAST:event_buttonLoginActionPerformed
    
    public UserClass loginUser(String username, String password) throws UserNotFoundException {
        for (UserClass user : Database.getUsers()) {
        	if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
        		return user;
        	}
        }
        throw new UserNotFoundException("User not found.");
    }
    
    
    public static void main(String[] args) {
		
		new Login().setVisible(true);
	
	
	}

    private javax.swing.JButton buttonLogin;
    private javax.swing.JTextField inputLoginUN;
    private javax.swing.JPasswordField inputLoginUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelUN;
    private javax.swing.JLabel labelUP;

}
