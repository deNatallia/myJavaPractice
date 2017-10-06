package com.roxoft.sellcompany.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.Address;

public class AddressDAO implements IAddressMapper{
	private final static Logger LOGGER = LogManager.getLogger(AddressDAO.class);
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public AddressDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	@Override
	public int createAddress(Address address) {
		int row = -1;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            row = session.insert("com.roxoft.sellcompany.mybatis.AddressMapper.createAddress", address);
        } finally {
            session.commit();
            session.close();
        }
        LOGGER.info(address.toString() + " was successfully added to Addresses table");
        return row;
	}

	@Override
	public Address getAddressById(int id) {
		Address address;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	address = (Address) session.selectOne("Address.getAddressById", id);
        } finally {
            session.commit();
            session.close();
        }
        return address;
	}

	@Override
	public int updateAddress(Address address) {
		int row = -1;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	row = session.update("Address.updateAddress", address);
        } finally {
            session.commit();
            session.close();
        }
        return row;
	}

	@Override
	public int deleteAddress(int id) {
		int row = -1;
		SqlSession session = sqlSessionFactory.openSession(); 
        try {
        	row = session.update("Address.deleteAddress", id);
        } finally {
            session.commit();
            session.close();
        }
        return row;
	}

}
