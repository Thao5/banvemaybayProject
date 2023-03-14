package com.banvemaybay.services;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.banvemaybay.model.Booking;
import com.banvemaybay.model.User;

public class userServices {
	public List<User> getUsers() throws SQLException{
		List<User> users = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM user");
			while(rs.next()) {
				User user = new User(rs.getInt("id"),rs.getString("lastname"), rs.getString("name"), rs.getString("sdt"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getBoolean("admin"));
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
	
	public List<User> getUsers(String key){
		List<User> listuser = new ArrayList<>();
		userServices userserv = new userServices();
		if(key == "") {
			try {
				return userserv.getUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "select * from user where id = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1, ChuyenBayServices.tryParse(key));
			
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				
			
				do{
					User u = new User(rs.getInt("id"), rs.getString("lastname"), rs.getString("name"), rs.getString("sdt"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getBoolean("admin"));
					listuser.add(u);
				}while(rs.next()) ;
				return listuser;
			}
				sql = "select * from user where name = ?";
				stat = conn.prepareStatement(sql);
				
				stat.setString(1, key);
				
				rs = stat.executeQuery();
				if(rs.next()) {
					
					
					do{
						User u = new User(rs.getInt("id"), rs.getString("lastname"), rs.getString("name"), rs.getString("sdt"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getBoolean("admin"));
						listuser.add(u);
					}while(rs.next());
					return listuser;
				}
					sql = "select * from user where username = ?";
					stat = conn.prepareStatement(sql);
					
					stat.setString(1, key);
					
					rs = stat.executeQuery();
					if(rs.next()) {
						
						
						do{
							User u = new User(rs.getInt("id"), rs.getString("lastname"), rs.getString("name"), rs.getString("sdt"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getBoolean("admin"));
							listuser.add(u);
						}while(rs.next()) ;
						return listuser;
					}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listuser;
	}
	
	public User timUser(int i) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "select * from user where id = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, i);
			
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				return new User(rs.getInt("id"), rs.getString("lastname"), rs.getString("name"), rs.getString("sdt"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getBoolean("admin"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void xoaUser(User u) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			List<Booking> book = new ArrayList<>();
			String sql = "select * from booking where user_id = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setInt(1, u.getId());
			
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				book.add(new Booking(rs.getTimestamp("ngay_dat").toLocalDateTime(), rs.getBoolean("trang_thai_dat"), rs.getInt("user_id"), rs.getInt("chuyenbay_id")));
			}
			
			for(Booking b : book) {
				sql = "delete from ve where booking_id = ?";
				stat = conn.prepareStatement(sql);
				stat.setInt(1, b.getId());
				stat.executeUpdate();
			}
			
			sql = "delete from booking where user_id = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, u.getId());
			stat.executeUpdate();
			
			sql = "delete from user where id = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, u.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
