package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banvemaybay.model.ChuyenBay;

public class ChuyenBayServices {
	public List<ChuyenBay> getChuyenBays() throws SQLException{
		List<ChuyenBay> cbs = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELEC * FROM chuyen_bay");
			while(rs.next()) {
				ChuyenBay cb = new ChuyenBay(rs.getString("name"), rs.getTimestamp("thoi_gian_xuat_phat").toLocalDateTime(), rs.getTimestamp("thoi_gian_den").toLocalDateTime(), rs.getInt("ghe_trong"), rs.getString("diem_di"), rs.getString("diem_den"), rs.getDouble("gia_tien"), rs.getInt("sanbaydi_id"), rs.getInt("sanbayden_id"));
				cbs.add(cb);
			}
		}
		return cbs;
	}
}
