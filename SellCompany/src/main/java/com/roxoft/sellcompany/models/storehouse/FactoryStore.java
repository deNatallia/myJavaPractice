package com.roxoft.sellcompany.models.storehouse;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.models.StoreHouse;

public class FactoryStore extends StoreHouse {
	private final static Logger LOGGER = LogManager.getLogger(StoreHouse.class);
	@JsonProperty
	private LinkedList<String> goods;
	
	public FactoryStore() {
	}
	public FactoryStore(String name, Address address, int loaderNum, int square, LinkedList<String> goods) {
		super(name, address, loaderNum, square);	
	}

	@Override
	public void sell(){
		LOGGER.info("selling");
	}
	
	public void loadCar(){
		LOGGER.info("loadingCar");
	}
	
	@Override
	public void transportIn() {
		LOGGER.info("Transportation from factory");
	}
	
	@Override
	public void transportOut() {
		LOGGER.info("Transportation to customs");
	}
	
	@Override
	public void clean(){
		LOGGER.info("Cleaning by Mr Johns");
	};

	@Override
	public void work() {
		LOGGER.info("Working hours from 8a.m. to 5p.m.");	
	}
	
	@Override	
	public String toString(){
		return "Company name: " + getName()+ "; Address: " + getAddress() + "; Number of loaders: " + getLoaderNum() + "; Goods: " + getGoods();
	}
	
	public LinkedList<String> getGoods() {
		return goods;
	}

	@XmlElementWrapper(name="goods")
	@XmlElement(name = "good")
	@JsonSetter
	public void setGoods(LinkedList<String> goods) {
		this.goods = goods;
	}

	
}
