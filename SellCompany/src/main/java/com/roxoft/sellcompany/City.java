package com.roxoft.sellcompany;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType (name="city")
@XmlEnum(String.class)
public enum City {
	MINSK,BREST,GRODNO,GOMEL,MOGILEV,KIEV,LVIV,ODESSA,KHARKOV
}
