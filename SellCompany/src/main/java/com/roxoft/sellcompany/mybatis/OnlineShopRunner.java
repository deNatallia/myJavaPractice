package com.roxoft.sellcompany.mybatis;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.City;
import com.roxoft.sellcompany.Country;
import com.roxoft.sellcompany.models.shop.OnlineShop;

public class OnlineShopRunner {
	private final static Logger LOGGER = LogManager.getLogger(OnlineShopRunner.class);
	
	public static void main(String[] args) throws IOException, ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		SqlSessionFactory sf = MybatisConnectionFactory.getSqlSessionFactory();
		AddressDAO ad = new AddressDAO(sf);
		OnlineShopDAO od = new OnlineShopDAO(sf);
		Address a1=new Address();
		a1.setCountry(Country.UKRAINE);
		a1.setCity(City.KIEV);
		a1.setStreet("Vasilevskaya");
		a1.setHouseNum(12);
//		ad.insertAddress(a1);
//		ad.getAddressById(5);
		OnlineShop os = new OnlineShop();
		os.setName("FunPets");
		os.setSite("funpets.ua");
		os.setAddress(a1);
		os.setStaffNum(3);
		os.setManagersNum(8);
		os.setNewArrivalDate(formatter.parse("2017-10-18"));
		LOGGER.info(a1.getId());
//		od.insertOnlineShop(os);
		od.getOnlineShopById(2);
	}
}
