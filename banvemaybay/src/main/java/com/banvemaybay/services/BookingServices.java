package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public void themBooking(Booking book) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "insert into booking(ngay_dat, trang_thai_dat, user_id, chuyenbay_id) values(?,?,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setString(1, book.getNgay_dat().toString());
			stat.setBoolean(2, book.isTrang_thai_dat());
			stat.setInt(3, book.getUser_id());
			stat.setInt(4, book.getChuyen_id());
			
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
