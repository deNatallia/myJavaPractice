package com.roxoft.sellcompany.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.City;
import com.roxoft.sellcompany.Country;
import com.roxoft.sellcompany.models.shop.Pavilion;

public class PavilionRunner {
	private final static Logger LOGGER = LogManager.getLogger(PavilionRunner.class);
	
	public static void main(String[] args) throws IOException, ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		SqlSessionFactory sf = MybatisConnectionFactory.getSqlSessionFactory();
		AddressDAO ad = new AddressDAO(sf);
		PavilionDAO pd = new PavilionDAO(sf);
		Address a1=new Address();
		a1.setCountry(Country.BELARUS);
		a1.setCity(City.MINSK);
		a1.setStreet("Pushkina");
		a1.setHouseNum(42);
		ad.insertAddress(a1);
		ad.getAddressById(5);
		Pavilion pv = new Pavilion();
		pv.setName("KidsThings");
		pv.setAddress(a1);
		pv.setStaffNum(3);
		pv.setPlaceNum(8);
		pv.setNewArrivalDate(formatter.parse("2017-10-29"));
		LOGGER.info(a1.getId());
		pd.insertPavilion(pv);
//		pd.getPavilionById(2);
	}
}
