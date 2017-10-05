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
		
		ConnectionPool conpool= new ConnectionPool();
			
		Address a1=new Address();
		a1.setCountry(Country.BELARUS);
		a1.setCity(City.MINSK);
		a1.setStreet("Korolya");
		a1.setHouseNum(27);
		
		Supermarket k = new Supermarket();
		k.setName("Korona");
		k.setAddress(a1);
		k.setStaffNum(78);
		k.setSquare(500);
		k.setSectionNum(8);
		k.setNewArrivalDate(formatter.parse("2017-10-29"));
		
		SupermarketService smservice = new SupermarketService(conpool);
//		smservice.addSupermarket(k);
//		LOGGER.info(smservice.getSupermarket(5).toString());
		smservice.updateThisSupermarket(k,15);
//		smservice.deleteThisSupermarket(16);
//		
//		Address a2=new Address();
//		a2.setCountry(Country.GERMANY);
//		a2.setCity(City.BERLIN);
//		a2.setStreet("Kassel");
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
//		oshservice.updateThisOnlineShop(o,11);
//		oshservice.deleteThisOnlineShop(12);
//		
//		Address a3=new Address();
//		a3.setCountry(Country.POLAND);
//		a3.setCity(City.WARSAW);
//		a3.setStreet("Kostushka");
//		a3.setHouseNum(201);
//		
//		LogisticStore l = new LogisticStore();
//		l.setName("JapanCars");
//		l.setAddress(a3);
//		l.setLoaderNum(78);
//		l.setSquare(800);
//		l.setNewArrivalDate(formatter.parse("2017-10-19"));
//		
//		LinkedList<String> producers = new LinkedList<String>();
//		producers.add("mazda");
//		producers.add("toyota");
//		producers.add("suzuki");
//		l.setProducers(producers);
//		
//		LogisticStoreService logservice = new LogisticStoreService(conpool);
//		logservice.addLogisticStore(l);
//		LOGGER.info(logservice.getLogisticStore(5).toString());
//		logservice.updateThisLogisticStore(l,8);
//		logservice.deleteThisLogisticStore(8);
//		
//		Address a4=new Address();
//		a4.setCountry(Country.ITALY);
//		a4.setCity(City.ROME);
//		a4.setStreet("Napoleona");
//		a4.setHouseNum(101);
//		
//		FactoryStore fs = new FactoryStore();
//		fs.setName("ItalianCheese");
//		fs.setAddress(a4);
//		fs.setLoaderNum(15);
//		fs.setSquare(500);
//		
//		LinkedList<String> goods = new LinkedList<String>();
//		goods.add("mazarella");
//		goods.add("parmezan");
//		goods.add("mascarpone");
//		fs.setGoods(goods);
//		
//		FactoryStoreService factservice = new FactoryStoreService(conpool);
//		factservice.addFactoryStore(fs);
//		LOGGER.info(factservice.getFactoryStore(5).toString());
//		factservice.updateThisFactoryStore(fs,6);
//		factservice.deleteThisFactoryStore(6);
	}
	
}
