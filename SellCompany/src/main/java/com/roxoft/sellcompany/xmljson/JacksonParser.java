package com.roxoft.sellcompany.xmljson;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.models.shop.Pavilion;
import com.roxoft.sellcompany.models.shop.Supermarket;
import com.roxoft.sellcompany.models.storehouse.FactoryStore;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

public class JacksonParser {
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			File f = new File("src/main/resources/com/roxoft/sellcompany/sellingcompany.json");
			TypeReference<List<Supermarket>> mapType = new TypeReference<List<Supermarket>>() {};
	    	List<Supermarket> smList = mapper.readValue(f, mapType);
	    	for (Supermarket sm: smList){
				System.out.println(sm.toString());
			}
//			SellingCompany sc = mapper.readValue(f, SellingCompany.class);
//			for (Shops s: sc.getShops()){
//				for (Supermarket sm: s.getSupermarkets()){
//					System.out.println(sm.toString());
//				}
//				for (OnlineShop os: s.getOnlineshops()){
//					System.out.println(os.toString());
//				}
//				for (Pavilion pv: s.getPavilions()){
//					System.out.println(pv.toString());
//				}
//			}
//			for (StoreHouses s: sc.getStoreHouses()){
//				for (LogisticStore ls: s.getLogisticStores()){
//					System.out.println(ls.toString());
//				}
//				for (FactoryStore fs: s.getFactoryStores()){
//					System.out.println(fs.toString());
//				}
//			}
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}

}
