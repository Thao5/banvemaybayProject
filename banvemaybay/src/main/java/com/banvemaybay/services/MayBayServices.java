package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				MayBay mb = new MayBay(rs.getInt("id"),rs.getString("name"), rs.getInt("so_ghe"),rs.getLong("nam_san_xuat"), rs.getInt("chuyenbay_id"));
				mayBays.add(mb);
			}
		}
		return mayBays;
	}
	
	public void themMB(MayBay mb) {
		try(Connection conn = DatabaseConnection.getDatabaseConnection()){
			String sql = "insert into may_bay(name, so_ghe, nam_san_xuat, chuyenbay_id) values(?,?,?,?)";
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setString(1, mb.getName());
			stat.setInt(2, mb.getSo_ghe());
			stat.setLong(3, mb.getNam_san_xuat());
			stat.setInt(4, mb.getChuyenbay_id());
			
			stat.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
