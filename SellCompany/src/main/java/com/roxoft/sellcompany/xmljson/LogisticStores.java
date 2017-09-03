package com.roxoft.sellcompany.xmljson;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement (name="logisticStores")
public class LogisticStores {

	private ArrayList<LogisticStore> logstores;

	public ArrayList<LogisticStore> getLogstores() {
		return logstores;
	}
	@XmlElementWrapper(name = "logisticStores")
	@XmlElement (name = "logisticStore")
	public void setLogstores(ArrayList<LogisticStore> logstores) {
		this.logstores = logstores;
	}
	
	public static void main(String[] args) throws Exception{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(LogisticStores.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			File xml = new File("src/com/roxoft/sellcompany/xmljson/sellingcompany.xml");

			LogisticStores sc = (LogisticStores) unmarshaller.unmarshal(xml);
			System.out.println(sc.getLogstores());
//			for (Supermarket s: lsm.getSupermarkets()){
//				System.out.println(s.getName());
//			}
			
//			LogisticStores lls = (LogisticStores) unmarshaller.unmarshal(xml);
//			for (LogisticStore s: lls.getLogstores()){
//				System.out.println(s.getName());
//			}
			
		} catch (JAXBException e) {
			//log.error("JAXBException accured");
			e.printStackTrace();
		}
		
		
	}
}
