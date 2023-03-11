package com.banvemaybay.model;

import java.time.LocalDateTime;

public class Booking {
	private int id;
	private LocalDateTime ngay_dat;
	private boolean trang_thai_dat;
	private int user_id;
	private int chuyen_id;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Booking(int id, LocalDateTime ngay_dat, boolean trang_thai_dat, int user_id, int chuyen_id) {
		super();
		this.id = id;
		this.ngay_dat = ngay_dat;
		this.trang_thai_dat = trang_thai_dat;
		this.user_id = user_id;
		this.chuyen_id = chuyen_id;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getNgay_dat() {
		return ngay_dat;
	}
	public void setNgay_dat(LocalDateTime ngay_dat) {
		this.ngay_dat = ngay_dat;
	}
	public boolean isTrang_thai_dat() {
		return trang_thai_dat;
	}
	public void setTrang_thai_dat(boolean trang_thai_dat) {
		this.trang_thai_dat = trang_thai_dat;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getChuyen_id() {
		return chuyen_id;
	}
	public void setChuyen_id(int chuyen_id) {
		this.chuyen_id = chuyen_id;
	}
	
}
