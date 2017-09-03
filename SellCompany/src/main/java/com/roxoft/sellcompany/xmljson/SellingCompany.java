package com.roxoft.sellcompany.xmljson;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="sellingCompany")
public class SellingCompany {
	@JsonProperty
	private List<Shops> shops = new ArrayList<Shops>();
	@JsonProperty
	private List<StoreHouses> storeHouses = new ArrayList<StoreHouses>();
	
	public List<Shops> getShops() {
		return shops;
	}
	@XmlElement (name = "shops")
	@JsonSetter
	public void setShops(List<Shops> shops) {
		this.shops = shops;
	}

	public List<StoreHouses> getStoreHouses() {
		return storeHouses;
	}
	@XmlElement (name = "storeHouses")
	@JsonSetter
	public void setStoreHouses(List<StoreHouses> storeHouses) {
		this.storeHouses = storeHouses;
	}

}
