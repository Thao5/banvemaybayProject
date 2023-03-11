package com.banvemaybay.model;

public class User {
	private int id;
	private String lastname;
	private String name;
	private String sdt;
	private String email;
	private String username;
	private String password;
	private boolean admin;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(int id, String lastname, String name, String sdt, String email, String username, String password,
			boolean admin) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.name = name;
		this.sdt = sdt;
		this.email = email;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	
	public User(String lastname, String name, String sdt, String email, String username, String password,
			boolean admin) {
		super();
		this.lastname = lastname;
		this.name = name;
		this.sdt = sdt;
		this.email = email;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
