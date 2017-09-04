package com.roxoft.sellcompany.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.SellCompany;
import com.roxoft.sellcompany.xmljson.JaxbDateAdapter;

/**
 * This is an abstract class for Shops
 * @author natalia.m
 * @version 1.0
 * @see SellCompany
 * @see IClean#clean()
 * @see IWork#work()
 */
public abstract class Shop extends SellCompany implements IClean, IWork{
	@JsonProperty
	private ShopType shopType;
	@JsonProperty
	private int staffNum;
	@JsonProperty
	private Date newArrivalDate;
	
	public Shop(){};
	
	public Shop(String name, Address address, ShopType shopType, int staffNum, Date newArrivalDate){
		super(name, address);
	}

	public void saleOut(){
		System.out.println("Begin sale!");
	}
	
	public ShopType getShopType() {
		return shopType;
	}
	
	@XmlElement
	@JsonSetter
	public void setShopType(ShopType shopType) {
		this.shopType = shopType;
	}
	public int getStaffNum() {
		return staffNum;
	}
	@XmlElement
	@JsonSetter
	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public Date getNewArrivalDate() {
		return newArrivalDate;
	}
	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	@JsonSetter
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public void setNewArrivalDate(Date newArrivalDate) {
		this.newArrivalDate = newArrivalDate;
	}
//	/** Get date of new arrival of goods in set format
//	 * @return String newArrivalDate in dd-MM-yyyy
//	 */
//	public String getNewArrivalDate() {
//		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
//		return sf.format(newArrivalDate);
//	}
//	/**
//	 * Set the date of new arrival with handling exception
//	 * @param newDate - String date of new arrivals
//	 * @throws ParseException
//	 */
//	@XmlElement
//	@JsonSetter
//	public void setNewArrivalDate(String newDate) throws ParseException {
//		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
//		this.newArrivalDate = sf.parse(newDate);		
//	}

}
