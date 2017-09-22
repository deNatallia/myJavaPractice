package com.roxoft.sellcompany;

import com.roxoft.sellcompany.models.ShopType;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.models.shop.Supermarket;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.*;

import com.roxoft.sellcompany.models.Shop;

public class Runner {
	private final static Logger LOGGER = LogManager.getLogger(Runner.class);
	
	public static void main(String[] args) throws ParseException, InvalidValueException{
		Supermarket m1 = new Supermarket(null, null, null, 0, null, 0, 0);
		Address m1Address=new Address();
		m1Address.setCountry(Country.BELARUS);
		m1Address.setCity(City.MINSK);
		m1Address.setStreet("Kolosa");
		m1Address.setHouseNum(10);
		m1.setName("Mila");
		m1.setShopType(ShopType.HOMEGOODS);
		m1.setSquare(15);
		m1.setStaffNum(15);
		m1.setSectionNum(3);
//		m1.setNewArrivalDate("15-10-2017");
		
		Supermarket m2 = new Supermarket(null, null, null, 0, null, 0, 0);
		Address m2Address=new Address();
		m2Address.setCountry(Country.BELARUS);
		m2Address.setCity(City.MINSK);
		m2Address.setStreet("Kolosa");
		m2Address.setHouseNum(10);
		m2.setName("Sosedi");
		m2.setShopType(ShopType.SUPERMARKET);
		m2.setSquare(150);
		m2.setStaffNum(35);
		m2.setSectionNum(9);
//		m2.setNewArrivalDate("17-08-2017");
		
		Shop m3 = new Supermarket(null, null, null, 0, null, 0, 0);				//  type redefining
		Address m3Address=new Address();
		m3Address.setCountry(Country.BELARUS);
		m3Address.setCity(City.MINSK);
		m3Address.setStreet("9Maya");
		m3Address.setHouseNum(10);
		m3.setName("Kosmo");
		m3.setShopType(ShopType.SUPERMARKET);
		((Supermarket)m3).setSquare(30);
		m3.setStaffNum(5);
		((Supermarket)m3).setSectionNum(2);
//		m3.setNewArrivalDate("01-01-2018");
		
		
		SellCompany m4 = new OnlineShop(null, null, null, 0, null, null, 0);		 //  type redefining
		((OnlineShop)m4).setName("1K");
//		((OnlineShop)m4).setNewArrivalDate("11-11-2017");
		Shop shop=new OnlineShop(null, null, null, 0, null, null, 0);				//  type redefining
		if (shop instanceof OnlineShop){
			OnlineShop m5 = (OnlineShop)shop;
			shop.sell();
			m5.sell();
		}
		else {LOGGER.info("\n");}
		
		LOGGER.info("\n");
		
		m1.sell();
		LOGGER.info(m1);
		LOGGER.info(m3);
		LOGGER.info("\n");
		
		m1.layOutGoods();
		((Supermarket)m3).layOutGoods();		//  type redefining
	
		m1.saleOut();
		m3.saleOut();
		((Shop)m4).saleOut();		//  type redefining
		
		System.out.println();
		
		m4.sell();
		System.out.println();
		((Shop)m4).sell();
		System.out.println();
		((OnlineShop)m4).takeOrder();			// redefining type
		
		LOGGER.info("\n");
		LOGGER.info("HashCodes of " + m1.getName() + ":" + m1.hashCode() + " and "+ m2.getName() + ":" + m2.hashCode());

		if (m1Address.equals(m2Address)){
			LOGGER.info("Shops " + m1.getName() + " and " + m2.getName() + " are situated at the same address");
		}
		else {
			LOGGER.info("Shops " + m1.getName() + " and " + m2.getName() + " are situated at different places");
		}
	
		if (m1Address.getCity().equals(m2Address.getCity())){
			LOGGER.info("Shops " + m1.getName() + " and " + m2.getName() + " are situated at the same town");
		}
		else {
			LOGGER.info("Shops " + m1.getName() + " and " + m2.getName() + " are situated at different towns");
		}
		LOGGER.info("\n");
		//work with String
		StringBuilder cont = new StringBuilder();
		cont.append("Company name: ").append(m1.getName()).append(". ").append("Shop type: ").append(m1.getShopType()).append(". ").append("Number of sections: ").append(m1.getSectionNum()).append(".");
		LOGGER.info(cont.toString());
		LOGGER.info(cont.substring(0,18));
		
		StringBuffer adr= new StringBuffer();
		adr.append("We are situated at ").append(m1Address).append(".");
		LOGGER.info(adr.toString());
		
		LOGGER.info(StringUtils.substring(m2.getName(),0,4));
		LOGGER.info(StringUtils.substring(m2.getName(),-2));
		
		LOGGER.info("IsBlank(null): " + StringUtils.isBlank(null));
		LOGGER.info("IsEmpty(null): " + StringUtils.isEmpty(null));
		LOGGER.info("IsBlank(''): " + StringUtils.isBlank(""));
		LOGGER.info("IsEmpty(''): " + StringUtils.isEmpty(""));
		LOGGER.info("IsBlank(' '): " + StringUtils.isBlank(" "));
		LOGGER.info("IsEmpty(' '): " + StringUtils.isEmpty(" "));
		LOGGER.info("IsBlank('m1'): " + StringUtils.isBlank(m1.getName()));
		LOGGER.info("IsEmpty('m1'): " + StringUtils.isEmpty(m1.getName()));
		LOGGER.info("IsBlank(' a '): " + StringUtils.isBlank(" a "));
		LOGGER.info("IsEmpty(' a '): " + StringUtils.isEmpty(" a "));
		
		m1.clean();
		((OnlineShop)m4).clean();
		m1.work();
		((OnlineShop)m4).work();
		
		//work with Date
		LogisticStore Logi = new LogisticStore(null, m3Address, 0, 0, null, null);
		Logi.setName("Logi");
//		Logi.setNewArrivalDate("10-12-2018");
		
		LOGGER.info("New arrivals in " + Logi.getName() + " at: " + Logi.getNewArrivalDate());
		LOGGER.info("New arrivals in " + m1.getName() + " at: " + m1.getNewArrivalDate());
		LOGGER.info("New arrivals in " + m2.getName() + " at: " + m2.getNewArrivalDate());
		LOGGER.info("New arrivals in " + m3.getName() + " at: " + m3.getNewArrivalDate());
		LOGGER.info("New arrivals in " + m4.getName() + " at: " + ((OnlineShop)m4).getNewArrivalDate());
		
		//work with File
		File xfile = new File("src/main/resources/com/roxoft/sellcompany/inheritance.txt");
		try {
			String mytext = FileUtils.readFileToString(xfile,"UTF-8");
			LOGGER.info(mytext);
			String textWithoutTokens = StringUtils.replaceEachRepeatedly(mytext,new String[]{".",",","(", ")"},new String[]{"","","",""});
			String arr[] = StringUtils.split(StringUtils.uncapitalize(textWithoutTokens), " ");
			StringBuilder newStr = new StringBuilder();
			for (int i=0; i<arr.length; i++){
				if (!StringUtils.contains(newStr,arr[i])){
					int wordNum = StringUtils.countMatches(mytext,arr[i]);
					newStr.append(StringUtils.capitalize(arr[i])).append(" repeats ").append(wordNum).append(" times. ").append("\n");
				}
			}
			LOGGER.info(newStr.toString());
			File myfile = new File("src/com/roxoft/sellcompany/myfile.txt");
			FileUtils.writeStringToFile(myfile,newStr.toString(),"UTF-8");
		} catch (IOException e) {
			LOGGER.error("Something is wrong with file");
		} 
	
		TreeSet<Double> tSet = new TreeSet<Double>();
		for (int i=0; i<10; i++){
			tSet.add((double) (Math.random()*10));
		}
		Iterator<Double> treeIterator=tSet.iterator();
		while (treeIterator.hasNext()){
			LOGGER.info(treeIterator.next()+" ");
		}
		tSet.add(3.2);
		treeIterator=tSet.iterator();
		while (treeIterator.hasNext()){
			LOGGER.info(treeIterator.next()+" ");
		}
		
		System.out.println();
		
		// My Tree Collection		
		Tree theTree = new Tree();
		List<Double> numbers = Arrays.asList(1.5, 1.2, 1.7, 1.9, 0.5, 2.2, 1.3, 5.2, 3.7, 2.5, 0.1);
		numbers.stream()																				//stream
			.map((s) -> s+1)
			.forEach(value -> theTree.addItem(value));													
		theTree.printTree();
		
		theTree.delItem(3.2);
		theTree.delItem(2.3);
		
		theTree.printTree();
		
		LOGGER.info("\n");
		
		// ArrayList vs LinkedList
		List<Supermarket> alist = new ArrayList<Supermarket>();
		List<Supermarket> llist = new LinkedList<Supermarket>();
		
		long startAlist = System.nanoTime();
		for (int i=0; i<51; i++){
			alist.add(alist.size()/2, new Supermarket());
		}
		
		long timeAlist = System.nanoTime() - startAlist;
		
		long startLlist = System.nanoTime();
		for (int i=0; i<51; i++){
			llist.add(llist.size()/2, new Supermarket());
		}
		long timeLlist = System.nanoTime() - startLlist;
		
		LOGGER.info("Adding Time of ArrayList - " +  timeAlist + ". Adding Time of LinkedList - " +  timeLlist + ".");
		

		
		
	}
}
