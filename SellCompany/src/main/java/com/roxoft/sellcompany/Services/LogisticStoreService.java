package com.roxoft.sellcompany.Services;

import java.util.ArrayList;
import java.util.LinkedList;

import com.roxoft.sellcompany.DAO.JDBCAddressDAO;
import com.roxoft.sellcompany.DAO.JDBCLogisticStoreDAO;
import com.roxoft.sellcompany.DAO.JDBCLogisticsHasProducersDAO;
import com.roxoft.sellcompany.DAO.JDBCProducerDAO;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;
import com.roxoft.sellcompany.threads.ConnectionPool;

public class LogisticStoreService {
	private JDBCAddressDAO adao;
	private JDBCLogisticStoreDAO ldao;
	private JDBCProducerDAO pdao;
	private JDBCLogisticsHasProducersDAO lpdao;
	
	public LogisticStoreService(ConnectionPool conpool){
		adao = new JDBCAddressDAO();
		ldao = new JDBCLogisticStoreDAO();
		pdao = new JDBCProducerDAO();
		lpdao = new JDBCLogisticsHasProducersDAO();
		adao.setConpool(conpool);
		ldao.setConpool(conpool);
		pdao.setConpool(conpool);
		lpdao.setConpool(conpool);
	}
	
	public void addLogisticStore(LogisticStore l){		
		adao.insertAddress(l.getAddress());
		ldao.insertLogisticStore(l);
		
		for (String producer:l.getProducers()){
			pdao.insertProducer(producer);
			lpdao.insertLogisticHasProducers(JDBCProducerDAO.getGeneratedKeys(), l.getId());
		}
	}
	
	public LogisticStore getLogisticStore(int id){
		LogisticStore ls = ldao.getLogisticStoreById(id);
		ls.setAddress(adao.getAddressById(ldao.getIdAddress(id)));
		LinkedList<String> producers = new LinkedList<String>();
		ArrayList<Integer> allProducers = lpdao.getAllProducersId(id);
		for (int i:allProducers){
			producers.add(pdao.getProducerById(i));
		}
		ls.setProducers(producers);
		return ls;
	}
	
	public void updateThisLogisticStore(LogisticStore l){
		adao.updateAddress(l.getAddress());
		ArrayList<Integer> allProducersId = lpdao.getAllProducersId(l.getId());
		int i = 0;
		while (i < allProducersId.size()-1){
			for (String producer:l.getProducers()){
				pdao.updateProducer(producer, allProducersId.get(i));
				i++;
			}
		}
		ldao.updateLogisticStore(l);
	}
	
	public void deleteThisLogisticStore(int id){
		int idAddress = ldao.getIdAddress(id);
		ArrayList<Integer> allProducersId = lpdao.getAllProducersId(id);
		ldao.deleteLogisticStore(id);
		for (int producerId : allProducersId){
			pdao.deleteProducer(producerId);
		}
		adao.deleteAddress(idAddress);
	}
}
