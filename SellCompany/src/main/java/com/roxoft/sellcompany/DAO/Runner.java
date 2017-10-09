package com.roxoft.sellcompany.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.City;
import com.roxoft.sellcompany.Country;
import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.Services.FactoryStoreService;
import com.roxoft.sellcompany.Services.LogisticStoreService;
import com.roxoft.sellcompany.Services.OnlineShopService;
import com.roxoft.sellcompany.Services.SupermarketService;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.models.shop.Supermarket;
import com.roxoft.sellcompany.models.storehouse.FactoryStore;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;
import com.roxoft.sellcompany.threads.ConnectionPool;

public class Runner {
	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) throws InvalidValueException, ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		ConnectionPool conpool= ConnectionPool.getInstance();
			
//		Address a1=new Address();
//		a1.setCountry(Country.POLAND);
//		a1.setCity(City.WARSAW);
//		a1.setStreet("Korolya");
//		a1.setHouseNum(12);
//		
//		Supermarket k = new Supermarket();
//		k.setName("MediaMarkt");
//		k.setAddress(a1);
//		k.setStaffNum(34);
//		k.setSquare(700);
//		k.setSectionNum(10);
//		k.setNewArrivalDate(formatter.parse("2017-10-12"));
//		
//		SupermarketService smservice = new SupermarketService(conpool);
//		smservice.addSupermarket(k);
//		LOGGER.info(smservice.getSupermarket(15).toString());
//		smservice.updateThisSupermarket(k);
//		smservice.deleteThisSupermarket(20);
//		
//		Address a2=new Address();
//		a2.setCountry(Country.BELARUS);
//		a2.setCity(City.MINSK);
//		a2.setStreet("Gintovta");
//		a2.setHouseNum(41);
//		
//		OnlineShop o = new OnlineShop();
//		o.setName("TopShop");
//		o.setAddress(a2);
//		o.setStaffNum(78);
//		o.setSite("topshop.de");
//		o.setManagersNum(8);
//		o.setNewArrivalDate(formatter.parse("2017-10-25"));
//		
//		OnlineShopService oshservice = new OnlineShopService(conpool);
//		oshservice.addOnlineShop(o);
//		LOGGER.info(oshservice.getOnlineShop(5).toString());
//		oshservice.updateThisOnlineShop(o);
//		oshservice.deleteThisOnlineShop(12);
//		
//		Address a3=new Address();
//		a3.setCountry(Country.BELARUS);
//		a3.setCity(City.MINSK);
//		a3.setStreet("Gothe");
//		a3.setHouseNum(151);
//		
//		LogisticStore l = new LogisticStore();
//		l.setName("GermanyCars");
//		l.setAddress(a3);
//		l.setLoaderNum(65);
//		l.setSquare(1800);
//		l.setNewArrivalDate(formatter.parse("2017-10-17"));
//		
//		LinkedList<String> producers = new LinkedList<String>();
//		producers.add("audi");
//		producers.add("bmw");
//		producers.add("wf");
//		l.setProducers(producers);
//		
//		LogisticStoreService logservice = new LogisticStoreService(conpool);
//		logservice.addLogisticStore(l);
//		LOGGER.info(logservice.getLogisticStore(7).toString());
//		logservice.updateThisLogisticStore(l);
//		logservice.deleteThisLogisticStore(7);
//		
		Address a4=new Address();
		a4.setCountry(Country.POLAND);
		a4.setCity(City.WARSAW);
		a4.setStreet("Napoleona");
		a4.setHouseNum(101);
		
		FactoryStore fs = new FactoryStore();
		fs.setName("ItalianCheese");
		fs.setAddress(a4);
		fs.setLoaderNum(15);
		fs.setSquare(500);
		
		LinkedList<String> goods = new LinkedList<String>();
		goods.add("mazarella");
		goods.add("parmezan");
		goods.add("mascarpone");
		fs.setGoods(goods);
		
		FactoryStoreService factservice = new FactoryStoreService(conpool);
		factservice.addFactoryStore(fs);
//		LOGGER.info(factservice.getFactoryStore(5).toString());
//		factservice.updateThisFactoryStore(fs);
//		factservice.deleteThisFactoryStore(6);
	}
	
}
