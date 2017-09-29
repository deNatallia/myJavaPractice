package com.roxoft.sellcompany.xmljson;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.models.shop.Pavilion;
import com.roxoft.sellcompany.models.shop.Supermarket;
import com.roxoft.sellcompany.models.storehouse.FactoryStore;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

public class JacksonParser {
	private final static Logger LOGGER = LogManager.getLogger(JacksonParser.class);
			
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			File f = new File("src/main/resources/com/roxoft/sellcompany/sellingcompany.json");

			SellingCompany sc = mapper.readValue(f, SellingCompany.class);
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
			
		}
		catch (Exception e){
			LOGGER.error(e.getMessage());
		}
	}

}
