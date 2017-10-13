package com.roxoft.sellcompany.Services;

import com.roxoft.sellcompany.DAO.JDBCAddressDAO;
import com.roxoft.sellcompany.DAO.JDBCOnlineShopDAO;
import com.roxoft.sellcompany.models.shop.OnlineShop;
import com.roxoft.sellcompany.threads.ConnectionPool;

public class OnlineShopService {
	private JDBCAddressDAO adao;
	private JDBCOnlineShopDAO osdao;
	
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
	
	public void updateThisOnlineShop(OnlineShop s){
		osdao.updateOnlineShop(s);
		adao.updateAddress(s.getAddress());
	}
	
	public void deleteThisOnlineShop(int id){
		int idAddress = osdao.getIdAddress(id);
		osdao.deleteOnlineShop(id);
		adao.deleteAddress(idAddress);
	}
}
