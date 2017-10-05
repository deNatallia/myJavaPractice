package com.roxoft.sellcompany.Services;

import java.util.ArrayList;
import java.util.LinkedList;

import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.DAO.JDBCAddressDAO;
import com.roxoft.sellcompany.DAO.JDBCFactoryHasGoodsDAO;
import com.roxoft.sellcompany.DAO.JDBCFactoryStoreDAO;
import com.roxoft.sellcompany.DAO.JDBCGoodDAO;
import com.roxoft.sellcompany.models.storehouse.FactoryStore;
import com.roxoft.sellcompany.threads.ConnectionPool;

public class FactoryStoreService {
	JDBCAddressDAO adao;
	JDBCFactoryStoreDAO fdao;
	JDBCGoodDAO gdao;
	JDBCFactoryHasGoodsDAO fgdao;
	
	public FactoryStoreService(ConnectionPool conpool){
		adao = new JDBCAddressDAO();
		fdao = new JDBCFactoryStoreDAO();
		gdao = new JDBCGoodDAO();
		fgdao = new JDBCFactoryHasGoodsDAO();
		adao.setConpool(conpool);
		fdao.setConpool(conpool);
		gdao.setConpool(conpool);
		fgdao.setConpool(conpool);
	}
	
	public void addFactoryStore(FactoryStore l){		
		adao.insertAddress(l.getAddress());
		fdao.insertFactoryStore(l);
		
		for (String Good:l.getGoods()){
			gdao.insertGood(Good);
			fgdao.insertFactoryHasGoods(JDBCGoodDAO.getGeneratedKeys(), JDBCFactoryStoreDAO.getGeneratedKeys());
		}
	}
	
	public FactoryStore getFactoryStore(int id){
		FactoryStore fs = fdao.getFactoryStoreById(id);
		int idAddress= fdao.getIdAddress(id);
		Address a = adao.getAddressById(idAddress);
		System.out.println(idAddress + a.toString());
		fs.setAddress(a);
		System.out.println(fs.getAddress().toString());
		LinkedList<String> goods = new LinkedList<String>();
		ArrayList<Integer> allGoods = fgdao.getAllGoodsId(id);
		for (int i:allGoods){
			goods.add(gdao.getGoodById(i));
		}
		System.out.println(goods.toString());
		fs.setGoods(goods);
//		System.out.println(fs.toString());
		return fs;
	}
	
	public void updateThisFactoryStore(FactoryStore l,int id){
		System.out.println(fdao.getIdAddress(id));
		adao.updateAddress(l.getAddress(),fdao.getIdAddress(id));
		ArrayList<Integer> allGoodsId = fgdao.getAllGoodsId(id);
		System.out.println(allGoodsId.toString());
		int i = 0;
		while (i < allGoodsId.size()-1){
			for (String Good:l.getGoods()){
				System.out.println(Good + i);
				gdao.updateGood(Good, allGoodsId.get(i));
				i++;
			}
		}
		fdao.updateFactoryStore(l,id);
	}
	public void deleteThisFactoryStore(int id){
		int idAddress = fdao.getIdAddress(id);
		ArrayList<Integer> allGoodsId = fgdao.getAllGoodsId(id);
		System.out.println(idAddress + allGoodsId.toString());
		fdao.deleteFactoryStore(id);
		for (int GoodId : allGoodsId){
			gdao.deleteGood(GoodId);
		}

		adao.deleteAddress(idAddress);
	}
}
