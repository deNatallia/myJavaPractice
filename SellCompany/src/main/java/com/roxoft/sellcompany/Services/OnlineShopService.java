package com.roxoft.sellcompany.Services;

import com.roxoft.sellcompany.DAO.JDBCAddressDAO;
import com.roxoft.sellcompany.DAO.JDBCOnlineShopDAO;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.threads.ConnectionPool;

public class OnlineShopService {
	JDBCAddressDAO adao;
	JDBCOnlineShopDAO osdao;
	
	public OnlineShopService(ConnectionPool conpool){
		adao = new JDBCAddressDAO();
		osdao = new JDBCOnlineShopDAO();
		adao.setConpool(conpool);
		osdao.setConpool(conpool);
	}
	
	public void addOnlineShop(OnlineShop s){		
		adao.insertAddress(s.getAddress());
		osdao.insertOnlineShop(s);
	}
	
	public OnlineShop getOnlineShop(int id){
		OnlineShop os = osdao.getOnlineShopById(id);
		os.setAddress(adao.getAddressById(osdao.getIdAddress(id)));
		return os;
	}
	
	public void updateThisOnlineShop(OnlineShop s,int id){
		int idAddress = osdao.getIdAddress(id);
		osdao.updateOnlineShop(s,id);
		adao.updateAddress(s.getAddress(),idAddress);
	}
	
	public void deleteThisOnlineShop(int id){
		int idAddress = osdao.getIdAddress(id);
		osdao.deleteOnlineShop(id);
		adao.deleteAddress(idAddress);
	}
}
