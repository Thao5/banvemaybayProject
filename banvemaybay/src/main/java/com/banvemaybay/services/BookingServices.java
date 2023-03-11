package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banvemaybay.model.Booking;

public class BookingServices {
	public List<Booking> getBookings() throws SQLException{
		List<Booking> bookings = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM booking");
			while(rs.next()) {
				Booking bk = new Booking(rs.getInt("id"),rs.getTimestamp("ngay_dat").toLocalDateTime(), rs.getBoolean("trang_thai_dat"), rs.getInt("user_id"), rs.getInt("chuyenbay_id"));
				bookings.add(bk);
			}
		}
		return bookings;
	}
}
