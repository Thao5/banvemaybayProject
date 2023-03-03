package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}
