package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banvemaybay.model.Ve;

public class VeServices {
	public List<Ve> getVes() throws SQLException{
		List<Ve> ves = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM ve");
			while(rs.next()) {
				Ve ve = new Ve(rs.getInt("id"),rs.getDouble("gia_tien"), rs.getTimestamp("ngay_xuat_ve").toLocalDateTime(), rs.getBoolean("trang_thai_ve"), rs.getInt("chuyenbay_id"), rs.getInt("booking_id"));
				ves.add(ve);
			}
		}
		return ves;
	}
	
	public void themVe(Ve v) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "insert into ve(gia_tien, ngay_xuat_ve, trang_thai_ve, chuyenbay_id, booking_id) values(?,?,?,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setDouble(1, v.getGia_tien());
			stat.setString(2, v.getNgay_xuat_ve().toString());
			stat.setBoolean(3, v.isTrang_thai_ve());
			stat.setInt(4, v.getChuyenbay_id());
			stat.setInt(5, v.getBooking_id());
			
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
