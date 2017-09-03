package com.roxoft.sellcompany.xmljson;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.models.shop.Pavilion;
import com.roxoft.sellcompany.models.shop.Supermarket;

@XmlRootElement(name="shops")
public class Shops {
	@JsonProperty
	private List<Supermarket> supermarkets = new ArrayList<Supermarket>();
	@JsonProperty
	private List<OnlineShop> onlineshops = new ArrayList<OnlineShop>();
	@JsonProperty
	private List<Pavilion> pavilions = new ArrayList<Pavilion>();
	
	public List<Supermarket> getSupermarkets() {
		return supermarkets;
	}
	@XmlElementWrapper(name="supermarkets")
	@XmlElement (name="supermarket")
	@JsonSetter
	public void setSupermarkets(List<Supermarket> supermarkets) {
		this.supermarkets = supermarkets;
	}
	public List<OnlineShop> getOnlineshops() {
		return onlineshops;
	}
	@XmlElementWrapper(name="onlineShops")
	@XmlElement (name="onlineShop")
	@JsonSetter
	public void setOnlineshops(List<OnlineShop> onlineshops) {
		this.onlineshops = onlineshops;
	}
	public List<Pavilion> getPavilions() {
		return pavilions;
	}
	@XmlElementWrapper(name="pavilions")
	@XmlElement (name="pavilion")
	@JsonSetter
	public void setPavilions(List<Pavilion> pavilions) {
		this.pavilions = pavilions;
	}
}
