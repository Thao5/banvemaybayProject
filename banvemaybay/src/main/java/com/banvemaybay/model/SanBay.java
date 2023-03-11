package com.banvemaybay.model;

public class SanBay {
	private int id;
	private String name;
	private String dia_chi;
	private String lien_lac;
	
	public SanBay(int id, String name, String dia_chi, String lien_lac) {
		super();
		this.id = id;
		this.name = name;
		this.dia_chi = dia_chi;
		this.lien_lac = lien_lac;
	}

	public SanBay() {
		// TODO Auto-generated constructor stub
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
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getLien_lac() {
		return lien_lac;
	}
	public void setLien_lac(String lien_lac) {
		this.lien_lac = lien_lac;
	}
	
}
