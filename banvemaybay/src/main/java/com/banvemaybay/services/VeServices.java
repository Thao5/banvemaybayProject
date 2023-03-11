package com.banvemaybay.services;

import java.sql.Connection;
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
}
