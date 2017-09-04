package com.roxoft.sellcompany.xmljson;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.models.shop.Pavilion;
import com.roxoft.sellcompany.models.shop.Supermarket;

@XmlRootElement(name="shops")
@JsonIgnoreProperties("shops")
public class Shops {
	@JsonProperty
	private List<Supermarket> supermarkets = new ArrayList<Supermarket>();
	@JsonProperty
	private List<OnlineShop> onlineShops = new ArrayList<OnlineShop>();
	@JsonProperty
	private List<Pavilion> pavilions = new ArrayList<Pavilion>();
	
	public List<Supermarket> getSupermarkets() {
		return supermarkets;
	}
	@XmlElementWrapper(name="supermarkets")
	@XmlElement (name="supermarket")
	@JsonSetter("supermarkets")
	public void setSupermarkets(List<Supermarket> supermarkets) {
		this.supermarkets = supermarkets;
	}
	public List<OnlineShop> getOnlineshops() {
		return onlineShops;
	}
	@XmlElementWrapper(name="onlineShops")
	@XmlElement (name="onlineShop")
	@JsonSetter("onlineShops")
	public void setOnlineshops(List<OnlineShop> onlineshops) {
		this.onlineShops = onlineshops;
	}
	public List<Pavilion> getPavilions() {
		return pavilions;
	}
	@XmlElementWrapper(name="pavilions")
	@XmlElement (name="pavilion")
	@JsonSetter("pavilions")
	public void setPavilions(List<Pavilion> pavilions) {
		this.pavilions = pavilions;
	}
}
