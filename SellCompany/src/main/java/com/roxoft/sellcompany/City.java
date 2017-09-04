package com.roxoft.sellcompany;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlType (name="city")
@XmlEnum(String.class)
public enum City {
	@JsonProperty
	MINSK,
	@JsonProperty
	BREST,
	@JsonProperty
	GRODNO,
	@JsonProperty
	GOMEL,
	@JsonProperty
	MOGILEV,
	@JsonProperty
	KIEV,
	@JsonProperty
	LVIV,
	@JsonProperty
	ODESSA,
	@JsonProperty
	KHARKOV
}
