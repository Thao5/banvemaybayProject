package com.banvemaybay.services;

import java.sql.Connection;
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
				SanBay sanBay = new SanBay(rs.getString("name"), rs.getString("dia chi"), rs.getString("lien lac"));
				sanBays.add(sanBay);
			}
		}
		return sanBays;
	}
}
