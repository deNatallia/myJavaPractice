package com.roxoft.sellcompany;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * This is an abstract class for Selling Companies
 * @author natalia.m
 * @version 1.0
 * @see Address#Constructor(Country,City,String,int,int)
 * @see #sell()
 */
@JsonTypeName("sellCompany")
public abstract class SellCompany {
	@JsonProperty
	private String name;
	@JsonProperty
	private Address address;
	
	public SellCompany(){}
	
	public SellCompany(String name, Address address){
		this.name=name;
		this.address=address;
	}

	public Address getAddress() {
		return address;
	}
	
	@XmlElement(name = "address")
	@JsonSetter
	public void setAddress(Address address) {
		this.address = address;
	}


	public String getName() {
		return name;
	}
	
	@XmlElement
	@JsonSetter
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void sell();
	
}
