package com.roxoft.sellcompany;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlType(name="country")
@XmlEnum(String.class)
public enum Country {
	@JsonProperty
	BELARUS(1),
	@JsonProperty
	UKRAINE(2),
	@JsonProperty
	POLAND(3),
	@JsonProperty
	GERMANY(4),
	@JsonProperty
	ITALY(5);
	
    private int id;
	
	Country(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
