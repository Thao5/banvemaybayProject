package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banvemaybay.model.SanBay;

public class SanBayServices {
	public List<SanBay> getSanBays() throws SQLException{
		List<SanBay> sanBays = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery("SELECT * FROM san_bay");
			while(rs.next()) {
				SanBay sanBay = new SanBay(rs.getInt("id"),rs.getString("name"), rs.getString("dia_chi"), rs.getString("lien_lac"));
				sanBays.add(sanBay);
			}
		}
		return sanBays;
	}
	
	public List<String> loadAddressSanBay(){
		List<String> name = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery("SELECT dia_chi FROM san_bay");
			while(rs.next()) {
				name.add(rs.getString("dia_chi"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public List<String> loadNameSB(){
		List<String> name = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery("SELECT name FROM san_bay");
			while(rs.next()) {
				name.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public int findID(String key) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "select id from san_bay where name = ?";
			PreparedStatement stml = conn.prepareStatement(sql);
			stml.setString(1, key);
			
			ResultSet rs =  stml.executeQuery();
			while(rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 0;
	}
	
	public void themSB(SanBay sb) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "insert into san_bay(name, dia_chi, lien_lac) values(?,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setString(1, sb.getName());
			stat.setString(2, sb.getDia_chi());
			stat.setString(3, sb.getLien_lac());
			
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		SanBayServices sbs = new SanBayServices();
//		List<String> address = sbs.loadAddressSanBay();
//		for(String a : address) {
//			System.out.println(a);
//		}
//	}
}
