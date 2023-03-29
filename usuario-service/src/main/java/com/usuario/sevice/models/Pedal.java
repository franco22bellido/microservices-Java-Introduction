package com.usuario.sevice.models;

public class Pedal {

	private String efects;
	private String tradeMark;
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEfects() {
		return efects;
	}
	public void setEfects(String efects) {
		this.efects = efects;
	}
	public String getTradeMark() {
		return tradeMark;
	}
	public void setTradeMark(String tradeMark) {
		this.tradeMark = tradeMark;
	}
	public Pedal() {
		super();
	}
	
	
}
