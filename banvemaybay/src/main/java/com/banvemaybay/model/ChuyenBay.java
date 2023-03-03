package com.banvemaybay.model;

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

public class ChuyenBay {
	//DateTimeFormatter myF = DateTimeFormatter.ofPattern("E, MMM dd yyyy, HH:mm:ss");
	private int id;
	private String name;
	private LocalDateTime thoi_gian_xuat_phat;
	private LocalDateTime thoi_gian_den;
	private int ghe_trong;
	private String diem_di;
	private String diem_den;
	private double gia_tien;
	private int sanbaydi_id;
	private int sanbayden_id;
	
	public ChuyenBay() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ChuyenBay(String name, LocalDateTime thoi_gian_xuat_phat, LocalDateTime thoi_gian_den, int ghe_trong,
			String diem_di, String diem_den, double gia_tien, int sanbaydi_id, int sanbayden_id) {
		super();
		this.name = name;
		this.thoi_gian_xuat_phat = thoi_gian_xuat_phat;
		this.thoi_gian_den = thoi_gian_den;
		this.ghe_trong = ghe_trong;
		this.diem_di = diem_di;
		this.diem_den = diem_den;
		this.gia_tien = gia_tien;
		this.sanbaydi_id = sanbaydi_id;
		this.sanbayden_id = sanbayden_id;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getThoi_gian_xuat_phat() {
		return thoi_gian_xuat_phat;
	}
	public void setThoi_gian_xuat_phat(LocalDateTime thoi_gian_xuat_phat) {
		this.thoi_gian_xuat_phat = thoi_gian_xuat_phat;
	}
	public LocalDateTime getThoi_gian_den() {
		return thoi_gian_den;
	}
	public void setThoi_gian_den(LocalDateTime thoi_gian_den) {
		this.thoi_gian_den = thoi_gian_den;
	}
	public int getGhe_trong() {
		return ghe_trong;
	}
	public void setGhe_trong(int ghe_trong) {
		this.ghe_trong = ghe_trong;
	}
	public String getDiem_di() {
		return diem_di;
	}
	public void setDiem_di(String diem_di) {
		this.diem_di = diem_di;
	}
	public String getDiem_den() {
		return diem_den;
	}
	public void setDiem_den(String diem_den) {
		this.diem_den = diem_den;
	}
	public double getGia_tien() {
		return gia_tien;
	}
	public void setGia_tien(double gia_tien) {
		this.gia_tien = gia_tien;
	}
	public int getSanbaydi_id() {
		return sanbaydi_id;
	}
	public void setSanbaydi_id(int sanbaydi_id) {
		this.sanbaydi_id = sanbaydi_id;
	}
	public int getSanbayden_id() {
		return sanbayden_id;
	}
	public void setSanbayden_id(int sanbayden_id) {
		this.sanbayden_id = sanbayden_id;
	}
	
}
