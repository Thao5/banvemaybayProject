package com.banvemaybay.services;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.banvemaybay.model.User;

public class userServices {
	public List<User> getUsers() throws SQLException{
		List<User> users = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM user");
			while(rs.next()) {
				User user = new User(rs.getString("lastname"), rs.getString("name"), rs.getString("sdt"), rs.getString("email"), rs.getString("username"), rs.getString("password"), false);
				users.add(user);
			}
		}
		return users;
	}
	
	public void signUpUser(User u) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "INSERT INTO user(lastname, name, sdt, email, username, password, admin) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement stat = conn.prepareCall(sql);
			stat.setString(1, u.getLastname());
			stat.setString(2, u.getName());
			stat.setString(3, u.getSdt());
			stat.setString(4, u.getEmail());
			stat.setString(5, u.getUsername());
			stat.setString(6, u.getPassword());
			stat.setBoolean(7, u.isAdmin());
			
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
