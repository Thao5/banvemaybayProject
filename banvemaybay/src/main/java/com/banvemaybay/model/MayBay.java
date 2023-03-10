package com.banvemaybay.model;

public class MayBay {
	private int id;
	private String name;
	private int so_ghe;
	private long nam_san_xuat;
	private int chuyenbay_id;
	
	public int getChuyenbay_id() {
		return chuyenbay_id;
	}

	public void setChuyenbay_id(int chuyenbay_id) {
		this.chuyenbay_id = chuyenbay_id;
	}

	public MayBay() {
		// TODO Auto-generated constructor stub
	}
	
	public MayBay(int id, String name, int so_ghe, long nam_san_xuat, int chuyenbay_id) {
		super();
		this.id = id;
		this.name = name;
		this.so_ghe = so_ghe;
		this.nam_san_xuat = nam_san_xuat;
		this.chuyenbay_id = chuyenbay_id;
	}

	public MayBay(String name, int so_ghe, long nam_san_xuat, int chuyenbay_id) {
		super();
		this.name = name;
		this.so_ghe = so_ghe;
		this.nam_san_xuat = nam_san_xuat;
		this.chuyenbay_id = chuyenbay_id;
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
	public int getSo_ghe() {
		return so_ghe;
	}
	public void setSo_ghe(int so_ghe) {
		this.so_ghe = so_ghe;
	}
	public long getNam_san_xuat() {
		return nam_san_xuat;
	}
	public void setNam_san_xuat(long nam_san_xuat) {
		this.nam_san_xuat = nam_san_xuat;
	}
	
}
