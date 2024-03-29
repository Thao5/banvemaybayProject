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

import com.banvemaybay.model.Booking;
import com.banvemaybay.model.ChuyenBay;
import com.banvemaybay.model.ThongKe;
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
				String sql = "SELECT * from chuyen_bay "
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
				String sql = "SELECT * from chuyen_bay "
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
				String sql = "SELECT * from chuyen_bay "
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
				String sql = "SELECT * from chuyen_bay "
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
				String sql = "SELECT * from chuyen_bay "
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
				String sql = "SELECT * from chuyen_bay "
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
				String sql = "SELECT * from chuyen_bay "
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
			stml.setInt(1, id);
			
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
	
	public boolean themCB(String name, String thoi_gian_xuat_phat, String thoi_gian_den, String ghe_trong, String diem_di, String diem_den, String gia_tien, String san_bay_di, String san_bay_den) {
		if(name == null || thoi_gian_xuat_phat == null || thoi_gian_den == null) return false;
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			SanBayServices sbs = new SanBayServices();
			String sql = "insert into chuyen_bay(name, thoi_gian_xuat_phat, thoi_gian_den, ghe_trong, diem_di, diem_den, gia_tien, sanbaydi_id, sanbayden_id) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement stml = conn.prepareStatement(sql);
			
			stml.setString(1, name);
			stml.setString(2, thoi_gian_xuat_phat);
			stml.setString(3, thoi_gian_den);
			stml.setInt(4, tryParse(ghe_trong));
			stml.setString(5, diem_di);
			stml.setString(6, diem_den);
			stml.setDouble(7, Double.parseDouble(gia_tien));
			stml.setInt(8, sbs.findID(san_bay_di));
			stml.setInt(9, sbs.findID(san_bay_den));
			
			stml.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public List<ThongKe> thongKe(){
		List<ThongKe> thongke = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "select chuyen_bay.name, (select count(*) from ve where ve.chuyenbay_id = chuyen_bay.id) as soluong, (chuyen_bay.gia_tien * (select count(*) from ve where ve.chuyenbay_id = chuyen_bay.id)) as doanhthu from chuyen_bay";
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				thongke.add(new ThongKe(rs.getString("name"), rs.getInt("soluong"), rs.getDouble("doanhthu")));
			}
			return thongke;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thongke;
	}
	
	public ChuyenBay timTheoID(int id) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "select * from chuyen_bay where id = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				ChuyenBay cb = new ChuyenBay(rs.getInt("id"),rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
				return cb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void xoaCB(ChuyenBay cb) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			
			
			List<Booking> book = new ArrayList<>();
			String sql = "select * from booking where chuyenbay_id = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setInt(1, cb.getId());
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				book.add(new Booking(rs.getInt("id"), rs.getTimestamp("ngay_dat").toLocalDateTime(), rs.getBoolean("trang_thai_dat"), rs.getInt("user_id"), rs.getInt("chuyenbay_id")));
			}
			
			for(Booking b : book) {
				sql = "delete from ve where chuyenbay_id = ? or booking_id = ?";
				stat = conn.prepareStatement(sql);
				
				stat.setInt(1, cb.getId());
				stat.setInt(2, b.getId());
				stat.executeUpdate();
				
				sql = "delete from booking where chuyenbay_id = ?";
				stat = conn.prepareStatement(sql);
				
				stat.setInt(1, cb.getId());
				stat.executeUpdate();
			}
			
			
			sql = "delete from may_bay where chuyenbay_id = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setInt(1, cb.getId());
			stat.executeUpdate();
			
			sql = "delete from chuyen_bay where id = ?";
			stat = conn.prepareStatement(sql);
			
			stat.setInt(1, cb.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Integer tryParse(String text) {
		  try {
		    return Integer.parseInt(text);
		  } catch (NumberFormatException e) {
		    return -1;
		  }
		}
}
