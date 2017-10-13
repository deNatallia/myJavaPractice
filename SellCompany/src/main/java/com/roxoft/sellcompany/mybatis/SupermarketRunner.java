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
import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.models.shop.Supermarket;

public class SupermarketRunner {
	private final static Logger LOGGER = LogManager.getLogger(SupermarketRunner.class);
	
	public static void main(String[] args) throws IOException, ParseException, InvalidValueException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		SqlSessionFactory sf = MybatisConnectionFactory.getSqlSessionFactory();
		AddressDAO ad = new AddressDAO(sf);
		SupermarketDAO od = new SupermarketDAO(sf);
		Address a1=new Address();
		a1.setCountry(Country.POLAND);
		a1.setCity(City.WARSAW);
		a1.setStreet("Milosza");
		a1.setHouseNum(2);
//		ad.insertAddress(a1);
//		ad.updateAddress(a1);
		ad.getAddressById(5);
		Supermarket os = new Supermarket();
		os.setName("Bi1");
		os.setSquare(700);
		os.setAddress(a1);
		os.setStaffNum(32);
		os.setSectionNum(8);
		os.setNewArrivalDate(formatter.parse("2017-10-29"));
		LOGGER.info(a1.getId());
		od.insertSupermarket(os);
//		od.updateSupermarket(os);
		od.getSupermarketById(2);
	}
}
