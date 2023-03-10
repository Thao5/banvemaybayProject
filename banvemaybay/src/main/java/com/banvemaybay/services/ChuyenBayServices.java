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

public class ChuyenBayServices {
	public List<ChuyenBay> getChuyenBays() throws SQLException{
		List<ChuyenBay> cbs = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM chuyen_bay");
			while(rs.next()) {
				ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
				cbs.add(cb);
			}
		}
		return cbs;
	}
	
	public List<ChuyenBay> getChuyenBays(String diem_di, String diem_den, String ngay_xuat_phat){
		List<ChuyenBay> cbs = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			if(diem_di != null && diem_den != null && ngay_xuat_phat != null) {
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
					ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_di != null && diem_den != null && ngay_xuat_phat == null) {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_di = ? and diem_den = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_di);
				stat.setString(2, diem_den);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_di != null && diem_den == null && ngay_xuat_phat != null) {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_di = ? and ngay_xuat_phat = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_di);
				stat.setString(2, ngay_xuat_phat);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_di == null && diem_den != null && ngay_xuat_phat != null) {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_den = ? and ngay_xuat_phat = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_den);
				stat.setString(2, ngay_xuat_phat);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_di != null) {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_di = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_di);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(diem_den != null) {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where diem_den = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, diem_den);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
					cbs.add(cb);
				}
			}
			else if(ngay_xuat_phat != null) {
				String sql = "SELECT thoi_gian_xuat_phat, thoi_gian_den, name, diem_di, diem_den, gia_tien from chuyen_bay "
						+ "where ngay_xuat_phat = ?";
				PreparedStatement stat = conn.prepareStatement(sql);
				stat.setString(1, ngay_xuat_phat);
				
				ResultSet rs = stat.executeQuery();
				while(rs.next()) {
					ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
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
}
