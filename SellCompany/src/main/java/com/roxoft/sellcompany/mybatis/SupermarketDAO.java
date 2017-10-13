package com.roxoft.sellcompany.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.DAO.ISupermarketDAO;
import com.roxoft.sellcompany.models.shop.Supermarket;

public class SupermarketDAO implements ISupermarketDAO{
	private final static Logger LOGGER = LogManager.getLogger(SupermarketDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public SupermarketDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	@Override
	public void insertSupermarket(Supermarket supermarket) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	session.insert("com.roxoft.sellcompany.mappings.AddressMapper.insertAddress", supermarket.getAddress());
            session.insert("com.roxoft.sellcompany.mappings.SupermarketMapper.insertSupermarket", supermarket);
        } finally {
            session.commit();
            session.close();
        }
        LOGGER.info(supermarket.toString() + " was successfully added to Supermarketes table");
	}

	@Override
	public Supermarket getSupermarketById(int id) {
		Supermarket supermarket;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	supermarket = (Supermarket) session.selectOne("com.roxoft.sellcompany.mappings.SupermarketMapper.getSupermarketById", id);
        } finally {
            session.commit();
            session.close();
        }
        return supermarket;
	}

	@Override
	public void updateSupermarket(Supermarket supermarket) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.AddressMapper.updateAddress", supermarket.getAddress());
        	session.update("com.roxoft.sellcompany.mappings.SupermarketMapper.updateSupermarket", supermarket);
        } finally {
            session.commit();
            session.close();
        }
	}

	@Override
	public void deleteSupermarket(int id) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.SupermarketMapper.deleteSupermarket", id);
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
