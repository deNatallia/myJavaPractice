package com.roxoft.sellcompany.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.DAO.IPavilionDAO;
import com.roxoft.sellcompany.models.shop.Pavilion;

public class PavilionDAO implements IPavilionDAO{
	private final static Logger LOGGER = LogManager.getLogger(PavilionDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public PavilionDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	@Override
	public void insertPavilion(Pavilion pavilion) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	session.insert("com.roxoft.sellcompany.mappings.AddressMapper.insertAddress", pavilion.getAddress());
            session.insert("com.roxoft.sellcompany.mappings.PavilionMapper.insertPavilion", pavilion);
        } finally {
            session.commit();
            session.close();
        }
        LOGGER.info(pavilion.toString() + " was successfully added to Paviliones table");
	}

	@Override
	public Pavilion getPavilionById(int id) {
		Pavilion pavilion;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	pavilion = (Pavilion) session.selectOne("com.roxoft.sellcompany.mappings.PavilionMapper.getPavilionById", id);
        } finally {
            session.commit();
            session.close();
        }
        return pavilion;
	}

	@Override
	public void updatePavilion(Pavilion pavilion) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.AddressMapper.updateAddress", pavilion.getAddress());
        	session.update("com.roxoft.sellcompany.mappings.PavilionMapper.updatePavilion", pavilion);
        } finally {
            session.commit();
            session.close();
        }
	}

	@Override
	public void deletePavilion(int id) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.PavilionMapper.deletePavilion", id);
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
