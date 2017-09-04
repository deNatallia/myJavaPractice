package com.roxoft.sellcompany.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlType(name="shopType")
@XmlEnum(String.class)
public enum ShopType {
	@JsonProperty
	SUPERMARKET,
	@JsonProperty
	KIOSK,
	@JsonProperty
	INTERNET,
	@JsonProperty
	EXPRESS,
	@JsonProperty
	HOMEGOODS,
	@JsonProperty
	PAVILION
}
