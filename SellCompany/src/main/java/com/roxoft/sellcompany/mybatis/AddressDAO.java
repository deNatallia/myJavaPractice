package com.roxoft.sellcompany.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.DAO.IAddressDAO;

public class AddressDAO implements IAddressDAO{
	private final static Logger LOGGER = LogManager.getLogger(AddressDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;
	
    public AddressDAO(SqlSessionFactory sqlSessionFactory){
    	this.sqlSessionFactory = sqlSessionFactory;
    }
	
	@Override
	public void insertAddress(Address address) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("com.roxoft.sellcompany.mappings.AddressMapper.insertAddress", address);
        } finally {
            session.commit();
            session.close();
        }
        LOGGER.info(address.toString() + " was successfully added to Addresses table");
	}

	@Override
	public Address getAddressById(int id) {
		Address address;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	address = (Address) session.selectOne("com.roxoft.sellcompany.mappings.AddressMapper.getAddressById", id);
        } finally {
            session.commit();
            session.close();
        }
        return address;
	}

	@Override
	public void updateAddress(Address address) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("com.roxoft.sellcompany.mappings.AddressMapper.updateAddress", address);
        } finally {
            session.commit();
            session.close();
        }
	}

	@Override
	public void deleteAddress(int id) {
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	session.update("mapLink.deleteAddress", id);
        } finally {
            session.commit();
            session.close();
        }
	}
}
