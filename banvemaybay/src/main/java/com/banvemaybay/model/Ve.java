package com.banvemaybay.model;

import java.time.LocalDateTime;

public class Ve {
	private int id;
	private double gia_tien;
	private LocalDateTime ngay_xuat_ve;
	private boolean trang_thai_ve;
	private int chuyenbay_id;
	private int booking_id;
	
	public Ve() {
		// TODO Auto-generated constructor stub
	}
	
	public Ve(int id, double gia_tien, LocalDateTime ngay_xuat_ve, boolean trang_thai_ve, int chuyenbay_id, int booking_id) {
		super();
		this.id = id;
		this.gia_tien = gia_tien;
		this.ngay_xuat_ve = ngay_xuat_ve;
		this.trang_thai_ve = trang_thai_ve;
		this.chuyenbay_id = chuyenbay_id;
		this.booking_id = booking_id;
	}
	
	public Ve(double gia_tien, LocalDateTime ngay_xuat_ve, boolean trang_thai_ve, int chuyenbay_id, int booking_id) {
		super();
		this.gia_tien = gia_tien;
		this.ngay_xuat_ve = ngay_xuat_ve;
		this.trang_thai_ve = trang_thai_ve;
		this.chuyenbay_id = chuyenbay_id;
		this.booking_id = booking_id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGia_tien() {
		return gia_tien;
	}
	public void setGia_tien(double gia_tien) {
		this.gia_tien = gia_tien;
	}
	public LocalDateTime getNgay_xuat_ve() {
		return ngay_xuat_ve;
	}
	public void setNgay_xuat_ve(LocalDateTime ngay_xuat_ve) {
		this.ngay_xuat_ve = ngay_xuat_ve;
	}
	public boolean isTrang_thai_ve() {
		return trang_thai_ve;
	}
	public void setTrang_thai_ve(boolean trang_thai_ve) {
		this.trang_thai_ve = trang_thai_ve;
	}
	public int getChuyenbay_id() {
		return chuyenbay_id;
	}
	public void setChuyenbay_id(int chuyenbay_id) {
		this.chuyenbay_id = chuyenbay_id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	
}
