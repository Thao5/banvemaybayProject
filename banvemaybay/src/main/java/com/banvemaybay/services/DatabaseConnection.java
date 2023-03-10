package com.banvemaybay.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.banvemaybay.model.User;
import com.mysql.cj.xdevapi.Statement;

public class DatabaseConnection {
	public static Connection getDatabaseConnection() {
		final String url = "jdbc:mysql://localhost:3306/banvemaybay";
		final String user = "root";
		final String password = "123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void CreateDataBase(Connection conn) {
		String sanbay = "CREATE TABLE san_bay(" + "id INT(11) NOT NULL AUTO_INCREMENT," + "name VARCHAR(50) NOT NULL," + "dia_chi VARCHAR(90) NOT NULL," + "lien_lac VARCHAR(12) NOT NULL," + "PRIMARY KEY(id))";
		
		String chuyenbay = "CREATE TABLE chuyen_bay(" + "id INT(11) NOT NULL AUTO_INCREMENT," + "name VARCHAR(50) NOT NULL,"
					+ "thoi_gian_xuat_phat DATETIME NOT NULL," + "thoi_gian_den DATETIME NOT NULL," + "ghe_trong INT(255),"
					+ "diem_di VARCHAR(50) NOT NULL," + "diem_den VARCHAR(50) NOT NULL," + "gia_tien DECIMAL NOT NULL," + "sanbaydi_id INT(11) NOT NULL," + "sanbayden_id INT(11) NOT NULL," + "PRIMARY KEY(id),"
					+ "FOREIGN KEY(sanbaydi_id) REFERENCES san_bay(id)," + "FOREIGN KEY(sanbayden_id) REFERENCES san_bay(id))";
		
		String user = "CREATE TABLE user(" + "id INT(11) NOT NULL AUTO_INCREMENT," + "lastname VARCHAR(50) NOT NULL," + "name VARCHAR(20) NOT NULL," + "sdt VARCHAR(12) NOT NULL,"
						+ "email VARCHAR(50) NOT NULL," + "username VARCHAR(30) NOT NULL," + "password VARCHAR(25) NOT NULL," + "admin BIT NOT NULL," + "PRIMARY KEY(id))";
		
		String booking = "CREATE TABLE booking(" + "id INT(11) NOT NULL AUTO_INCREMENT," + "ngay_dat DATETIME NOT NULL," + "trang_thai_dat BIT NOT NULL," + "user_id INT(11) NOT NULL,"
						+ "chuyenbay_id INT(11) NOT NULL," + "PRIMARY KEY(id)," + "FOREIGN KEY(user_id) REFERENCES user(id)," + "FOREIGN KEY(chuyenbay_id) REFERENCES chuyen_bay(id))";
	
		String ve = "CREATE TABLE ve(" + "id INT(11) NOT NULL AUTO_INCREMENT," + "gia_tien DECIMAL NOT NULL," + "ngay_xuat_ve DATETIME NOT NULL," + "trang_thai_ve BIT NOT NULL,"
					+ "chuyenbay_id INT(11) NOT NULL," + "booking_id INT(11) NOT NULL," + "PRIMARY KEY(id)," + "FOREIGN KEY(booking_id) REFERENCES booking(id)," + "FOREIGN KEY(chuyenbay_id) REFERENCES chuyen_bay(id))";
	
		String maybay = "CREATE TABLE may_bay(" + "id INT(11) NOT NULL AUTO_INCREMENT," + "name VARCHAR(50) NOT NULL," + "so_ghe INT(255) NOT NULL," + "nam_san_xuat BIGINT NOT NULL," + "chuyenbay_id INT(11) NOT NULL,"
						+ "PRIMARY KEY(id)," + "FOREIGN KEY(chuyenbay_id) REFERENCES chuyen_bay(id))";
		
		
		java.sql.Statement statement;
		try {
			statement = conn.createStatement();
			statement.executeUpdate(user);
			statement.executeUpdate(sanbay);
			statement.executeUpdate(chuyenbay);
			statement.executeUpdate(booking);
			statement.executeUpdate(ve);
			statement.executeUpdate(maybay);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void insertdata(Connection conn) {
		String sanbay = "INSERT INTO san_bay(name, dia_chi, lien_lac)" + "VALUES('Nội Bài', 'Hà Nội', '123456789')";
		String user = "INSERT INTO user(lastname, name, sdt, email, username, password, admin)" + "VALUES('Trịnh Minh', 'Hiếu', '123456789', 'hieu@gmail.com', 'hieu', '1', 1)";
		String chuyenbay = "INSERT INTO chuyen_bay(name, thoi_gian_xuat_phat, thoi_gian_den, ghe_trong, diem_di, diem_den, gia_tien, sanbaydi_id, sanbayden_id)" 
							+ "VALUES('Hà Nội-TP.HCM', NOW(), NOW(), 200, 'Tân Sơn Nhất', 'Nội Bài', 1000000, 1, 1)";
		String maybay = "INSERT INTO may_bay(name, so_ghe, nam_san_xuat, chuyenbay_id)" + "VALUES('Boeing', 200, 1975, 1)";
		String booking = "INSERT INTO booking(ngay_dat, trang_thai_dat, user_id, chuyenbay_id)" + "VALUES(NOW(), 1, 1, 1)";
		String ve = "INSERT INTO ve(gia_tien, ngay_xuat_ve, trang_thai_ve, chuyenbay_id, booking_id)"+ "VALUES(1000000, NOW(), 1, 1, 1)";
		
		java.sql.Statement statement;
		try {
			statement = conn.createStatement();
			statement.executeUpdate(user);
			statement.executeUpdate(sanbay);
			statement.executeUpdate(chuyenbay);
			statement.executeUpdate(maybay);
			statement.executeUpdate(booking);
			statement.executeUpdate(ve);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
//		Connection conn = getDatabaseConnection();
//		CreateDataBase(conn);
//		insertdata(conn);
//		if(conn != null) {
//			System.out.println("thanh cong");
//		} else {
//			System.out.println("that bai");
//		}
		
		userServices u = new userServices();
		List<User> users = u.getUsers();
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
}
