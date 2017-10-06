package com.roxoft.sellcompany.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.models.shop.Pavilion;

public class PavilionDAO implements IPavilionMapper{
	private final static Logger LOGGER = LogManager.getLogger(PavilionDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public PavilionDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	@Override
	public int createPavilion(Pavilion pavilion) {
		int row = -1;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            row = session.insert("Pavilion.createPavilion", pavilion);
        } finally {
            session.commit();
            session.close();
        }
        LOGGER.info(pavilion.toString() + " was successfully added to Paviliones table");
        return row;
	}

	@Override
	public Pavilion getPavilionById(int id) {
		Pavilion pavilion;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	pavilion = (Pavilion) session.selectOne("Pavilion.getPavilionById", id);
        } finally {
            session.commit();
            session.close();
        }
        return pavilion;
	}

	@Override
	public int updatePavilion(Pavilion pavilion) {
		int row = -1;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	row = session.update("Pavilion.updatePavilion", pavilion);
        } finally {
            session.commit();
            session.close();
        }
        return row;
	}

	@Override
	public int deletePavilion(int id) {
		int row = -1;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	row = session.update("Pavilion.deletePavilion", id);
        } finally {
            session.commit();
            session.close();
        }
        return row;
	}

}
