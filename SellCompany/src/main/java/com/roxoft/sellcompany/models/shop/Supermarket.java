package com.roxoft.sellcompany.models.shop;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.models.Shop;
import com.roxoft.sellcompany.models.ShopType;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="supermarket")
public class Supermarket extends Shop{
	private final static Logger LOGGER = LogManager.getLogger(Supermarket.class);
	@JsonProperty
	private int square;
	@JsonProperty
	private int sectionNum;
	
	public Supermarket(){};
	
	public Supermarket(String name, Address address, ShopType shopType, int staffNum, Date newArrivalDate, int square, int sectionNum) {
		super(name, address, shopType, staffNum, newArrivalDate);
	}
	@Override
	public void sell(){
		LOGGER.info("We sell a lot of goods in " + sectionNum + " sections!");
	}
	
	public void saleOut(){
		LOGGER.info("Begin sale in supermarket!");
	}
	
	public void layOutGoods(){
		LOGGER.info("Lay out new goods!");
	}
	
	@Override
	public void clean(){
		LOGGER.info("Cleaning by cleaning staff");
	};
	
	@Override
	public void work(){
		LOGGER.info("Our supermarket open from 8a.m. to 11p.m.");
	};
	
	@Override	
	public String toString(){
		return "Company name: " + getName()+ "; " + "; Address: " + getAddress() + "; Number of staff: " + getStaffNum() + "; Number of sections: " + sectionNum;
	}
	
	public int getSquare() {
		return square;
	}
	/**
	 * Set the value of shop square with handling exception
	 * @param square - square of the shop
	 * @throws {@link}InvalidValueException - if can't set square it's reported as not valid
	 */
	@XmlElement
	@JsonSetter
	public void setSquare(int square) throws InvalidValueException {
			if (square<10)
			{
				throw new InvalidValueException("not valid", null);
			}
			else {this.square = square;}
	}
	public int getSectionNum() {
		return sectionNum;
	}
	
	@XmlElement
	@JsonSetter
	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

		


}
