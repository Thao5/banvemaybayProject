package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banvemaybay.model.MayBay;

public class MayBayServices {
	public List<MayBay> getMayBays() throws SQLException{
		List<MayBay> mayBays = new ArrayList<>();
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM may_bay");
			while(rs.next()) {
				MayBay mb = new MayBay(rs.getString("name"), rs.getInt("so_ghe"),rs.getLong("nam_san_xuat"), rs.getInt("chuyenbay_id"));
				mayBays.add(mb);
			}
		}
		return mayBays;
	}
}
