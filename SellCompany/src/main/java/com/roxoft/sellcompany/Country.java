package com.roxoft.sellcompany;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlType(name="country")
@XmlEnum(String.class)
public enum Country {
	@JsonProperty
	BELARUS,
	@JsonProperty
	UKRAINE
}
