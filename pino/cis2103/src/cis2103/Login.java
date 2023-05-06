
package cis2103;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import exceptions.UserNotFoundException;
import model.AdminClass;
import model.Database;
import model.UserClass;

public class Login extends javax.swing.JFrame {

    public Login() {
		boolean connected = false;
		while (!connected) {
	        try {
	            Database.loadUsersFromDatabase();
	            //Database.loadMenuFromDatabase();
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

    }


    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inputLoginUN = new javax.swing.JTextField();
        inputLoginUP = new javax.swing.JPasswordField();
        buttonLogin = new javax.swing.JButton();
        labelUN = new javax.swing.JLabel();
        labelUP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(15, 4, 76));
        setMaximumSize(new java.awt.Dimension(1020, 600));
        setMinimumSize(new java.awt.Dimension(1020, 600));
        setPreferredSize(new java.awt.Dimension(1020, 570));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(15, 4, 76));
        jPanel3.setMaximumSize(new java.awt.Dimension(1020, 600));
        jPanel3.setMinimumSize(new java.awt.Dimension(1020, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 588));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 588));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 588));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setText("WELCOME");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("LOGIN TO ENTER THE SYSTEM");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Username :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Password :");

        buttonLogin.setText("LOGIN");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        labelUN.setText("Username is empty");

        labelUP.setText("Password is empty");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(173, 173, 173))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelUN)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(inputLoginUN)
                                .addComponent(inputLoginUP, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                            .addComponent(labelUP)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputLoginUN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUN)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputLoginUP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUP)
                .addGap(53, 53, 53)
                .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    
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
					AdminClassFrame a = new AdminClassFrame(temp);
					a.setVisible(true);
					a.setLocationRelativeTo(null);
					this.dispose();
				}else {
					new RegularClassFrame().setVisible(true);
					this.dispose();
				}
			} catch (UserNotFoundException e) {
				JOptionPane.showMessageDialog(this, "Credentials incorrect. Please contact administrator.");
			}
        }
    }
    
    public UserClass loginUser(String username, String password) throws UserNotFoundException {
        for (UserClass user : Database.getUsers()) {
        	if(user.getUserName().equals(username) && user.getPassword().equals(password)) {
        		return user;
        	}
        }
        throw new UserNotFoundException("User not found.");
    }
    
    
    public static void main(String[] args) {
		
    	try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    	
    	Login log = new Login();
    	log.setVisible(true);
    	log.setLocationRelativeTo(null);
	}


    private javax.swing.JButton buttonLogin;
    private javax.swing.JTextField inputLoginUN;
    private javax.swing.JPasswordField inputLoginUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelUN;
    private javax.swing.JLabel labelUP;

}
