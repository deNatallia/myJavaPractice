package com.roxoft.sellcompany.xmljson;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.City;
import com.roxoft.sellcompany.Country;
import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.models.ShopType;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.models.shop.Pavilion;
import com.roxoft.sellcompany.models.shop.Supermarket;
import com.roxoft.sellcompany.models.storehouse.FactoryStore;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DomXmlParser {
	private final static Logger LOGGER = LogManager.getLogger(DomXmlParser.class);
	
	public static ShopType takeShopType(Element t){
		return ShopType.valueOf(t.getElementsByTagName("shopType").item(0).getTextContent());
	}
	public static String takeName(Element t){
		return t.getElementsByTagName("name").item(0).getTextContent();
	}
	public static int takeSquare(Element t){
		return Integer.parseInt(t.getElementsByTagName("square").item(0).getTextContent());
	}
	public static int takeStaffNum(Element t){
		return Integer.parseInt(t.getElementsByTagName("staffNum").item(0).getTextContent());
	}
	
	public static int takeSectionNum(Element t){
		return Integer.parseInt(t.getElementsByTagName("sectionNum").item(0).getTextContent());
	}
	public static Date takeDate(Element t) throws DOMException, ParseException{
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
		Date nd = sf.parse(t.getElementsByTagName("newArrivalDate").item(0).getTextContent());
		return nd;
	}
	public static String takeSite(Element t){
		return t.getElementsByTagName("site").item(0).getTextContent();
	}
	public static int takeManagersNum(Element t){
		return Integer.parseInt(t.getElementsByTagName("managersNum").item(0).getTextContent());
	}
	public static int takePlaceNum(Element t){
		return Integer.parseInt(t.getElementsByTagName("placeNum").item(0).getTextContent());
	}
	public static int takeLoaderNum(Element t){
		return Integer.parseInt(t.getElementsByTagName("loadersNum").item(0).getTextContent());
	}
	
	public static LinkedList<String> takeProducers(Element t){
		LinkedList<String> prList = new LinkedList<>();
		NodeList pList = t.getElementsByTagName("producer");
		for (int j=0; j<pList.getLength(); j++){
			Node pNode = pList.item(j);
			Element ep =(Element)pNode;
			prList.add(ep.getTextContent());
		}
		return prList;
	}
	
	public static LinkedList<String> takeGoods(Element t){
		LinkedList<String> goodsList = new LinkedList<>();
		NodeList gList = t.getElementsByTagName("good");
		for (int j=0; j<gList.getLength(); j++){
			Node gNode = gList.item(j);
			Element eg =(Element)gNode;
			goodsList.add(eg.getTextContent());
		}
		return goodsList;
	}
	
	public static Address takeAddress(Element t){
		Address ads = new Address();
		ads.setCountry(Country.valueOf(t.getElementsByTagName("country").item(0).getTextContent()));
		ads.setCity(City.valueOf(t.getElementsByTagName("city").item(0).getTextContent()));
		ads.setStreet(t.getElementsByTagName("street").item(0).getTextContent());
		ads.setHouseNum(Integer.parseInt(t.getElementsByTagName("houseNum").item(0).getTextContent()));
		return ads;
	}
	
	public static void main(String[] args) throws ParseException, InvalidValueException{
			
		List<Supermarket> smList = new ArrayList<Supermarket>();
		List<OnlineShop> osList = new ArrayList<OnlineShop>();
		List<Pavilion> pvList = new ArrayList<Pavilion>();
		List<LogisticStore> lsList = new ArrayList<LogisticStore>();
		List<FactoryStore> fsList = new ArrayList<FactoryStore>();
		
		try {
			File file = new File("src/main/resources/com/roxoft/sellcompany/sellingcompany.xml");
			DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = f.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();
			
			NodeList smNList = root.getElementsByTagName("supermarket");
			for (int i=0; i<smNList.getLength(); i++){
				Node smNode = smNList.item(i);
				Supermarket smk = new Supermarket();
				if (smNode.getNodeType() == Node.ELEMENT_NODE){
					Element el =(Element)smNode;
					smk.setShopType(takeShopType(el));
					smk.setName(takeName(el));
					smk.setAddress(takeAddress(el));
					smk.setSquare(takeSquare(el));
					smk.setStaffNum(takeStaffNum(el));
					smk.setSectionNum(takeSectionNum(el));
					smk.setNewArrivalDate(takeDate(el));	
				}
				if (smk != null){
					smList.add(smk);
				}
			}
			for (Supermarket s: smList){
				LOGGER.info(s.toString());
			}
			
			NodeList osNList = root.getElementsByTagName("onlineShop");
			for (int i=0; i<osNList.getLength(); i++){
				Node osNode = osNList.item(i);
				OnlineShop osh = new OnlineShop();
				if(osNode.getNodeType() == Node.ELEMENT_NODE){
					Element el =(Element)osNode;
					osh.setName(takeName(el));
					osh.setAddress(takeAddress(el));
					osh.setSite(takeSite(el));
					osh.setStaffNum(takeStaffNum(el));
					osh.setManagersNum(takeManagersNum(el));
					osh.setNewArrivalDate(takeDate(el));
				}
				if (osh != null){
					osList.add(osh);
				}
			}
			for (OnlineShop s: osList){
				LOGGER.info(s.toString());
			}
			
			NodeList pavNList = root.getElementsByTagName("pavilion");
			for (int i=0; i<pavNList.getLength(); i++){
				Node pavNode = pavNList.item(i);
				Pavilion pav = new Pavilion();
				if(pavNode.getNodeType() == Node.ELEMENT_NODE){
					Element el =(Element)pavNode;
					pav.setName(takeName(el));
					pav.setAddress(takeAddress(el));
					pav.setStaffNum(takeStaffNum(el));
					pav.setPlaceNum(takePlaceNum(el));
					pav.setNewArrivalDate(takeDate(el));
				}
				if (pav != null){
					pvList.add(pav);
				}
			}
			for (Pavilion s: pvList){
				LOGGER.info(s.toString());
			}
			
			NodeList lsNList = root.getElementsByTagName("logisticStore");
			for (int i=0; i<lsNList.getLength(); i++){
				Node lsNode = lsNList.item(i);
				LogisticStore ls = new LogisticStore();
				if(lsNode.getNodeType() == Node.ELEMENT_NODE){
					Element el =(Element)lsNode;
					ls.setName(takeName(el));
					ls.setAddress(takeAddress(el));
					ls.setSquare(takeSquare(el));
					ls.setLoaderNum(takeLoaderNum(el));
					ls.setNewArrivalDate(takeDate(el));
					ls.setProducers(takeProducers(el));
				}
				if (ls != null){
					lsList.add(ls);
				}
			}
			for (LogisticStore s: lsList){
				LOGGER.info(s.toString());
			}
			
			NodeList fsNList = root.getElementsByTagName("factoryStore");
			for (int i=0; i<fsNList.getLength(); i++){
				Node fsNode = fsNList.item(i);
				FactoryStore fs = new FactoryStore();
				if(fsNode.getNodeType() == Node.ELEMENT_NODE){
					Element el =(Element)fsNode;
					fs.setName(takeName(el));
					fs.setAddress(takeAddress(el));
					fs.setSquare(takeSquare(el));
					fs.setLoaderNum(takeLoaderNum(el));
					fs.setGoods(takeGoods(el));
				}
				if (fs != null){
					fsList.add(fs);
				}
			}
			for (FactoryStore s: fsList){
				LOGGER.info(s.toString());
			}

		}
		catch (Exception e){
			LOGGER.info(e.getMessage());
		}
	}
		

}
