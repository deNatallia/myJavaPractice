package com.roxoft.sellcompany;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Address {
	@JsonProperty
	private int id;	
	@JsonProperty
	private Country country;
	@JsonProperty
	private City city;
	@JsonProperty
	private String street;
	@JsonProperty
	private int houseNum;
	
	public int getId() {
		return id;
	}
	
	@XmlElement
	@JsonSetter
	public void setId(int id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}
	
	@XmlElement
	@JsonSetter
	public void setCity(City city) {
		this.city = city;
	}
	
	public Country getCountry() {
		return country;
	}
	
	@XmlElement
	@JsonSetter
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}
	
	@XmlElement
	@JsonSetter
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getHouseNum() {
		return houseNum;
	}
	
	@XmlElement
	@JsonSetter
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	
	@Override	
	public String toString(){
		return country + ", " + city + ", "+ street + ", " + houseNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + houseNum;
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city != other.city)
			return false;
		if (country != other.country)
			return false;
		if (houseNum != other.houseNum)
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	
}
