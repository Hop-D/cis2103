package model;

import java.time.LocalDateTime;

public abstract class UserClass {
	private String id;
	private String userName;
	private String password;
	private String contact;
	private String role;
	private LocalDateTime userCreated;
	private LocalDateTime userUpdated;
	private UserClass editedBy;
	
	public static final String ADMIN_USER = "ADMIN";
	public static final String REGULAR_USER = "REGULAR";
	
	public UserClass(String id, String userName, String password, String contact, String role) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.contact = contact;
		this.role = role;
	}
	
	public UserClass(String id, String userName, String password, String contact, String role, LocalDateTime userCreated, LocalDateTime userUpdated) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.contact = contact;
		this.role = role;
		this.userCreated = userCreated;
		this.userUpdated = userUpdated;
	}

	public String getId() {
		return id;
	}

	public abstract String setUserID();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(LocalDateTime userCreated) {
		this.userCreated = userCreated;
	}

	public LocalDateTime getUserUpdated() {
		return userUpdated;
	}

	public void setUserUpdated(LocalDateTime userUpdated) {
		this.userUpdated = userUpdated;
	}

	public UserClass getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(UserClass editedBy) {
		this.editedBy = editedBy;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
