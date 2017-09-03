package com.roxoft.sellcompany.xmljson;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.models.storehouse.FactoryStore;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

@XmlRootElement(name="storeHouses")
public class StoreHouses {
	@JsonProperty
	private List<LogisticStore> logisticStores = new ArrayList<LogisticStore>();
	@JsonProperty
	private List<FactoryStore> factoryStores = new ArrayList<FactoryStore>();
	
	public List<LogisticStore> getLogisticStores() {
		return logisticStores;
	}
	@XmlElementWrapper(name="logisticStores")
	@XmlElement (type = LogisticStore.class, name="logisticStore", required=true)
	@JsonSetter
	public void setLogisticStores(List<LogisticStore> logisticStores) {
		this.logisticStores = logisticStores;
	}
	public List<FactoryStore> getFactoryStores() {
		return factoryStores;
	}
	@XmlElementWrapper(name="factoryStores")
	@XmlElement (type = FactoryStore.class, name="factoryStore",required=true)
	@JsonSetter
	public void setFactoryStores(List<FactoryStore> factoryStores) {
		this.factoryStores = factoryStores;
	}
}
