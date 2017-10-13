package com.roxoft.sellcompany.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.DAO.ILogisticStoreDAO;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

public class LogisticStoreDAO implements ILogisticStoreDAO{
	private final static Logger LOGGER = LogManager.getLogger(LogisticStoreDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public LogisticStoreDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	@Override
	public void insertLogisticStore(LogisticStore logisticstore) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	session.insert("com.roxoft.sellcompany.mappings.AddressMapper.insertAddress", logisticstore.getAddress());
            session.insert("com.roxoft.sellcompany.mappings.LogisticStoreMapper.insertLogisticStore", logisticstore);
        } finally {
            session.commit();
            session.close();
        }
        LOGGER.info(logisticstore.toString() + " was successfully added to LogisticStorees table");
	}

	@Override
	public LogisticStore getLogisticStoreById(int id) {
		LogisticStore logisticstore;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	logisticstore = (LogisticStore) session.selectOne("com.roxoft.sellcompany.mappings.LogisticStoreMapper.getLogisticStoreById", id);
        } finally {
            session.commit();
            session.close();
        }
        return logisticstore;
	}

	@Override
	public void updateLogisticStore(LogisticStore logisticstore) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.AddressMapper.updateAddress", logisticstore.getAddress());
        	session.update("com.roxoft.sellcompany.mappings.LogisticStoreMapper.updateLogisticStore", logisticstore);
        } finally {
            session.commit();
            session.close();
        }
	}

	@Override
	public void deleteLogisticStore(int id) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.LogisticStoreMapper.deleteLogisticStore", id);
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
