package com.roxoft.sellcompany.models;

public abstract class Transport implements ITrans{
	private int tonnage;
	private int carNum;
	
	@Override
	public void transportIn(){
		System.out.println("From producers");
	};
	
	@Override
	public void transportOut(){
		System.out.println("To customs");
	};

	public int getTonnage() {
		return tonnage;
	}

	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}

	public int getCarNum() {
		return carNum;
	}

	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	
	
}
