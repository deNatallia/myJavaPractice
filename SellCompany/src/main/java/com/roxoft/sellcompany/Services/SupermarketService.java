package com.roxoft.sellcompany.Services;

import com.roxoft.sellcompany.DAO.JDBCAddressDAO;
import com.roxoft.sellcompany.DAO.JDBCSupermarketDAO;
import com.roxoft.sellcompany.models.shop.Supermarket;
import com.roxoft.sellcompany.threads.ConnectionPool;

public class SupermarketService {
	JDBCAddressDAO adao;
	JDBCSupermarketDAO smdao;
	
	public SupermarketService(ConnectionPool conpool){
		adao = new JDBCAddressDAO();
		smdao = new JDBCSupermarketDAO();
		adao.setConpool(conpool);
		smdao.setConpool(conpool);
	}
	
	public void addSupermarket(Supermarket s){		
		adao.insertAddress(s.getAddress());
		smdao.insertSupermarket(s);
	}
	
	public Supermarket getSupermarket(int id){
		Supermarket sm = smdao.getSupermarketById(id);
		sm.setAddress(adao.getAddressById(smdao.getIdAddress(id)));
		return sm;
	}
	
	public void updateThisSupermarket(Supermarket s,int id){
		int idAddress = smdao.getIdAddress(id);
		smdao.updateSupermarket(s,id);
		adao.updateAddress(s.getAddress(),idAddress);
	}
	public void deleteThisSupermarket(int id){
		int idAddress = smdao.getIdAddress(id);
		smdao.deleteSupermarket(id);
		adao.deleteAddress(idAddress);
	}
}
