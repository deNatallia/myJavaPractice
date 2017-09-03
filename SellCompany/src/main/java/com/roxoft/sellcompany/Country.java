package com.roxoft.sellcompany;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="country")
@XmlEnum(String.class)
public enum Country {
	BELARUS, UKRAINE
}
