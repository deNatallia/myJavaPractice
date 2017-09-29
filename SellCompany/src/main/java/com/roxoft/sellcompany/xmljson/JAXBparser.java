package com.roxoft.sellcompany.xmljson;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.models.shop.Pavilion;
import com.roxoft.sellcompany.models.shop.Supermarket;
import com.roxoft.sellcompany.models.storehouse.FactoryStore;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class JAXBparser {

	private final static Logger LOGGER = LogManager.getLogger(JAXBparser.class);
	
	public static void main(String[] args) throws Exception{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SellingCompany.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			File xml = new File("src/main/resources/com/roxoft/sellcompany/sellingcompany.xml");
			
			SellingCompany sc = (SellingCompany)unmarshaller.unmarshal(xml);
			for (Shops s: sc.getShops()){
				for (Supermarket sm: s.getSupermarkets()){
					LOGGER.info(sm.toString());
				}
				for (OnlineShop os: s.getOnlineshops()){
					LOGGER.info(os.toString());
				}
				for (Pavilion pv: s.getPavilions()){
					LOGGER.info(pv.toString());
				}
			}
			for (StoreHouses s: sc.getStoreHouses()){
				for (LogisticStore ls: s.getLogisticStores()){
					LOGGER.info(ls.toString());
				}
				for (FactoryStore fs: s.getFactoryStores()){
					LOGGER.info(fs.toString());
				}
			}
			
		} catch (JAXBException e) {
			LOGGER.error("JAXBException accured", e.getCause());
		}
	
		
}
}
