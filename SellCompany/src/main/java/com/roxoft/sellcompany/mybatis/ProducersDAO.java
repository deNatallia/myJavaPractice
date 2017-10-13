package com.roxoft.sellcompany.mybatis;

import java.util.LinkedList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.mybatis.IProducerDAO;

public class ProducersDAO implements IProducerDAO{
	private final static Logger LOGGER = LogManager.getLogger(ProducersDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public ProducersDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	@Override
	public void insertProducers(LinkedList<String> producers) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("com.roxoft.sellcompany.mappings.ProducerMapper.insertProducer", producers);
        } finally {
            session.commit();
            session.close();
        }
        LOGGER.info(producers.toString() + " were successfully added to Produceres table");
	}

//	@Override
//	public LinkedList<String> getProducersById(int id) {
//		LinkedList<String> producer;
//		SqlSession session = sqlSessionFactory.openSession(); 
//        try {
//        	producer = (LinkedList<String>) session.selectOne("com.roxoft.sellcompany.mappings.ProducerMapper.getProducerById", id);
//        } finally {
//            session.commit();
//            session.close();
//        }
//        return producer;
//	}

	@Override
	public void updateProducers(LinkedList<String> producers) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.ProducerMapper.updateProducer", producers);
        } finally {
            session.commit();
            session.close();
        }
	}

	@Override
	public void deleteProducers(int id) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.ProducerMapper.deleteProducers", id);
        } finally {
            session.commit();
            session.close();
        }
	}


}
