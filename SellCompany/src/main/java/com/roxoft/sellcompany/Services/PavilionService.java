package com.roxoft.sellcompany.Services;

import com.roxoft.sellcompany.DAO.JDBCAddressDAO;
import com.roxoft.sellcompany.DAO.JDBCPavilionDAO;
import com.roxoft.sellcompany.models.shop.Pavilion;
import com.roxoft.sellcompany.threads.ConnectionPool;

public class PavilionService {
	JDBCAddressDAO adao;
	JDBCPavilionDAO pvdao;
	
	public PavilionService(ConnectionPool conpool){
		adao = new JDBCAddressDAO();
		pvdao = new JDBCPavilionDAO();
		adao.setConpool(conpool);
		pvdao.setConpool(conpool);
	}
	
	public void addPavilion(Pavilion pv){		
		adao.insertAddress(pv.getAddress());
		pvdao.insertPavilion(pv);
	}
	
	public Pavilion getPavilion(int id){
		Pavilion pv = pvdao.getPavilionById(id);
		pv.setAddress(adao.getAddressById(pvdao.getIdAddress(id)));
		return pv;
	}
	
	public void updateThisPavilion(Pavilion pv){
		int idAddress = pv.getId();
		pvdao.updatePavilion(pv);
		adao.updateAddress(pv.getAddress());
	}
	public void deleteThisPavilion(int id){
		int idAddress = pvdao.getIdAddress(id);
		pvdao.deletePavilion(id);
		adao.deleteAddress(idAddress);
	}
}
