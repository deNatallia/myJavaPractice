package com.roxoft.sellcompany.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.DAO.IOnlineShopDAO;
import com.roxoft.sellcompany.models.shop.OnlineShop;

public class OnlineShopDAO implements IOnlineShopDAO{
	private final static Logger LOGGER = LogManager.getLogger(OnlineShopDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public OnlineShopDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	@Override
	public void insertOnlineShop(OnlineShop onlineShop) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	session.insert("com.roxoft.sellcompany.mappings.AddressMapper.insertAddress", onlineShop.getAddress());
            session.insert("com.roxoft.sellcompany.mappings.OnlineShopMapper.insertOnlineShop", onlineShop);
        } finally {
            session.commit();
            session.close();
        }
        LOGGER.info(onlineShop.toString() + " was successfully added to OnlineShopes table");
	}

	@Override
	public OnlineShop getOnlineShopById(int id) {
		OnlineShop OnlineShop;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	OnlineShop = (OnlineShop) session.selectOne("com.roxoft.sellcompany.mappings.OnlineShopMapper.getOnlineShopById", id);
        } finally {
            session.commit();
            session.close();
        }
        return OnlineShop;
	}

	@Override
	public void updateOnlineShop(OnlineShop onlineShop) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.AddressMapper.updateAddress", onlineShop.getAddress());
        	session.update("com.roxoft.sellcompany.mappings.OnlineShopMapper.updateOnlineShop", onlineShop);
        } finally {
            session.commit();
            session.close();
        }
	}

	@Override
	public void deleteOnlineShop(int id) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.OnlineShopMapper.deleteOnlineShop", id);
        } finally {
            session.commit();
            session.close();
        }
	}

	@Override
	public int getIdAddress(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
