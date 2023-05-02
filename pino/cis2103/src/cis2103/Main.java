package cis2103;

import java.sql.SQLException;

import model.Database;

public class Main {
	public static void main(String[] args) {
		boolean connected = false;
		while (!connected) {
	        try {
	            Database.loadUsersFromDatabase();
	            connected = true;
	        } catch (SQLException e) {
	            String[] options = {"Try Again", "Exit"};
	            int choice = javax.swing.JOptionPane.showOptionDialog(null, "Database Error. Try again once connected.", "Database Error", javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

	            if (choice == 1) {
	                // User clicked "Exit"
	                return;
	            }
	        }
	    }
		
		
		new Login().setVisible(true);
	
	
	}
	
	
}
