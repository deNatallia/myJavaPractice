package com.roxoft.sellcompany.models;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="shopType")
@XmlEnum(String.class)
public enum ShopType {
	SUPERMARKET, KIOSK, INTERNET, EXPRESS, HOMEGOODS, PAVILION
}
