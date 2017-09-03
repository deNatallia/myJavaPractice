package com.roxoft.sellcompany.models.shop;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.models.Shop;
import com.roxoft.sellcompany.models.ShopType;

public class OnlineShop extends Shop{
	private final static Logger LOGGER = LogManager.getLogger(OnlineShop.class.getName());
	@JsonProperty
	private String site;
	@JsonProperty
	private int managersNum;
	
	public OnlineShop(){
	}
	
	public OnlineShop(String name, Address address, ShopType shopType, int staffNum, Date newArrivalDate, String site, int managersNum){
		super(name,address,shopType,staffNum,newArrivalDate);
		this.site=site;
		this.managersNum=managersNum;
	}
	
	@Override
	public void sell(){
		LOGGER.info("online selling");
	}
	
	public void saleOut(){
		LOGGER.info("Begin online sale!");
	}
	
	public void takeOrder(){
		LOGGER.info("taking orders");
	}
	public void delivery(){
		LOGGER.info("delivering");
	}
	
	@Override
	public void clean(){
		LOGGER.info("Cleaning by Mrs Green");
	};
	
	@Override
	public void work(){
		LOGGER.info("We take orders 24 hours 7 days a week.");
	};
	
	@Override	
	public String toString(){
		return "Company name: " + getName() + "; ShopType: " + getShopType() + "; Site: " + getSite() + "; Number of staff: " + getStaffNum() + "; Day of new arrival: " + getNewArrivalDate();
	}
	
	public String getSite() {
		return site;
	}
	
	@XmlElement
	@JsonSetter
	public void setSite(String site) {
		this.site = site;
	}

	public int getManagersNum() {
		return managersNum;
	}
	
	@XmlElement
	@JsonSetter
	public void setManagersNum(int managersNum) {
		this.managersNum = managersNum;
	}
	
}
