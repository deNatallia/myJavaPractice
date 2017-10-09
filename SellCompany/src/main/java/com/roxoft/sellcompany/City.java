package com.roxoft.sellcompany;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlType (name="city")
@XmlEnum(String.class)
public enum City {
	@JsonProperty
	MINSK(1),
	@JsonProperty
	KIEV(2),
	@JsonProperty
	ODESSA(3),
	@JsonProperty
	KHARKOV(4),
	@JsonProperty
	WARSAW(5),
	@JsonProperty
	BERLIN(6),
	@JsonProperty
	ROME(7),
	@JsonProperty
	BREST(8),
	@JsonProperty
	GRODNO(9),
	@JsonProperty
	GOMEL(10),
	@JsonProperty
	MOGILEV(11),
	@JsonProperty
	LVIV(12);
	
    private int id;
	
	City(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
