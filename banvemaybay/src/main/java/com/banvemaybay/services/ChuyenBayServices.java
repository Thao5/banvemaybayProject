package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.banvemaybay.model.ChuyenBay;
import com.mysql.cj.xdevapi.Result;

public class ChuyenBayServices {
	public List<ChuyenBay> getChuyenBays() throws SQLException{
		List<ChuyenBay> cbs = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM chuyen_bay");
			while(rs.next()) {
				ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
				cbs.add(cb);
			}
		}
		return cbs;
	}
	
	public List<ChuyenBay> getChuyenBays(String diem_di, String diem_den, String ngay_xuat_phat){
		List<ChuyenBay> cbs = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			if(diem_di != "" && diem_den != "" && ngay_xuat_phat != "") {
	//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	//			LocalDateTime dateTime = LocalDateTime.parse(ngay_xuat_phat, formatter);
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where thoi_gian_xuat_phat = ? and diem_di = ? and diem_den = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, ngay_xuat_phat);
				stat.setString(2, diem_di);
				stat.setString(3, diem_den);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_di != "" && diem_den != "" && ngay_xuat_phat == "") {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_di = ? and diem_den = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_di);
				stat.setString(2, diem_den);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_di != "" && diem_den == "" && ngay_xuat_phat != "") {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_di = ? and thoi_gian_xuat_phat = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_di);
				stat.setString(2, ngay_xuat_phat);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_di == "" && diem_den != "" && ngay_xuat_phat != "") {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_den = ? and thoi_gian_xuat_phat = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_den);
				stat.setString(2, ngay_xuat_phat);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_di != "") {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_di = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_di);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_den != "") {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_den = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_den);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(ngay_xuat_phat != "") {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where thoi_gian_xuat_phat = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, ngay_xuat_phat);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else {
				ChuyenBayServices s= new ChuyenBayServices();
				cbs = s.getChuyenBays();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cbs;
	}
	
	public String getSBNameAdmin(int id) {
		String res = "";
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "select name from san_bay where id = ?";
			PreparedStatement stml = conn.prepareStatement(sql);
			stml.setInt(id, id);
			
			ResultSet rs = stml.executeQuery();
			while(rs.next()) {
				res = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public List<ChuyenBay> getChuyenBays(String key){
		List<ChuyenBay> listcb = new ArrayList<>();
		ChuyenBayServices cbser = new ChuyenBayServices();
		if(key == "")
			try {
				return cbser.getChuyenBays();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "select * from chuyen_bay where id = ?";
			PreparedStatement stml = conn.prepareStatement(sql);
			stml.setInt(1, tryParse(key));
			
			ResultSet rs = stml.executeQuery();
			while(rs.next()) {
				ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
				listcb.add(cb);
			}
			if(!rs.next()) {
				sql = "select * from chuyen_bay where name = ?";
				stml = conn.prepareStatement(sql);
				stml.setString(1, key);
				
				rs = stml.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					listcb.add(cb);
				}
				if(!rs.next()) {
					sql = "select * from chuyen_bay where diem_di = ?";
					stml = conn.prepareStatement(sql);
					stml.setString(1, key);
					
					rs = stml.executeQuery();
					while(rs.next()) {
						ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
						listcb.add(cb);
					}
					if(!rs.next()) {
						sql = "select * from chuyen_bay where diem_den = ?";
						stml = conn.prepareStatement(sql);
						stml.setString(1, key);
						
						rs = stml.executeQuery();
						while(rs.next()) {
							ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
							listcb.add(cb);
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listcb;
	}
	
	public static Integer tryParse(String text) {
		  try {
		    return Integer.parseInt(text);
		  } catch (NumberFormatException e) {
		    return -1;
		  }
		}
}
