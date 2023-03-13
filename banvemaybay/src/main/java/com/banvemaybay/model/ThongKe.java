package com.banvemaybay.model;

public class ThongKe {
	private String name;
	private int soLuongVe;
	private double doanhThu;
	
	
	
	public ThongKe(String name, int soLuongVe, double doanhThu) {
		super();
		this.name = name;
		this.soLuongVe = soLuongVe;
		this.doanhThu = doanhThu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSoLuongVe() {
		return soLuongVe;
	}
	public void setSoLuongVe(int soLuongVe) {
		this.soLuongVe = soLuongVe;
	}
	public double getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
	
}
