package com.roxoft.sellcompany.models.shop;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.models.Shop;
import com.roxoft.sellcompany.models.ShopType;

public class Pavilion extends Shop{
	@JsonProperty
	private int placeNum;
	
	public Pavilion(){};
	
	public Pavilion(String name, Address address, ShopType shopType, int staffNum, Date newArrivalDate, int placeNum) {
		super(name, address, shopType, staffNum, newArrivalDate);
	}
	
	@Override
	public void clean() {	
	}

	@Override
	public void work() {	
	}

	@Override
	public void sell() {	
	}

	@Override	
	public String toString(){
		return "Company name: " + getName() + "; ShopType: " + getShopType() + "; Number of staff: " + getStaffNum() + "; Day of new arrival: " + getNewArrivalDate();
	}
	
	public int getPlaceNum() {
		return placeNum;
	}
	
	@XmlElement
	@JsonSetter
	public void setPlaceNum(int placeNum) {
		this.placeNum = placeNum;
	}

}
