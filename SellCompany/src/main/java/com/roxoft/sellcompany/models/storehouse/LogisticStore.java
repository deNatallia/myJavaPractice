package com.roxoft.sellcompany.models.storehouse;

import java.util.Date;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.models.StoreHouse;
import com.roxoft.sellcompany.xmljson.JaxbDateAdapter;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement (name="logisticStore")
public class LogisticStore extends StoreHouse {
	private final static Logger LOGGER = LogManager.getLogger(LogisticStore.class);
	@JsonProperty
	private LinkedList<String> producers;
	@JsonProperty
	private Date newArrivalDate;
	
	public LogisticStore() {	
	}
	public LogisticStore(String name, Address address, int loaderNum, int square, LinkedList<String> producers, Date newArrivalDate) {
		super(name, address, loaderNum, square);	
	}
	
	@Override
	public void sell(){
		LOGGER.info("selling");
	}
	
	public void loadCar(){
		LOGGER.info("loadingCar");
	}
	@Override
	public void transportIn() {
		LOGGER.info("Transportation from producers");
	}
	@Override
	public void transportOut() {
		LOGGER.info("Transportation to customs");
	}
	
	@Override
	public void clean(){
		LOGGER.info("Cleaning by cleaning company");
	}

	@Override
	public void work() {
		LOGGER.info("Works 24 hours");
		
	};

	@Override	
	public String toString(){
		return "Company name: " + getName()+ "; Address: " + getAddress() + "; Number of loaders: " + getLoaderNum() + "; Producers: " + getProducers();
	}
	
	public LinkedList<String> getProducers() {
		return producers;
	}

	@XmlElementWrapper(name="producers")
	@XmlElement(name = "producer")
	@JsonSetter
	public void setProducers(LinkedList<String> producers) {
		this.producers = producers;
	}
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public Date getNewArrivalDate() {
		return newArrivalDate;
	}
	@XmlElement
	@XmlJavaTypeAdapter(JaxbDateAdapter.class)
	@JsonSetter
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public void setNewArrivalDate(Date newArrivalDate) {
		this.newArrivalDate = newArrivalDate;
	}

//	public String getNewArrivalDate() {
//		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
//		return sf.format(newArrivalDate);
//	}
//	@XmlElement
//	@JsonSetter
//	public void setNewArrivalDate(String newDate) throws ParseException {
//		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
//		this.newArrivalDate = sf.parse(newDate);		
//	}
}
