package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCProducerDAO extends AbstractDAO implements IProducerDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCProducerDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private volatile static int generatedKeys;
	
	@Override
	public boolean insertProducer(String producer) {
		String sql = "INSERT into producers (PRODUCER_NAME,ORDERS_NUM) VALUES (?,?)";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			int i=0;
				ps.setString(1,producer);
				ps.setInt(2,5);
				i = ps.executeUpdate();
				rs=ps.getGeneratedKeys();
				if (i==0) {
					return false;
				}
			
				if (rs.next()){
				    this.setGeneratedKeys(rs.getInt(1));
				}    
			
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		LOGGER.info(producer + " was successfully added to Producers table");
		return true;	
	}

	@Override
	public boolean updateProducer(String producer,int id) {
		String sql = "UPDATE producers SET PRODUCER_NAME=? WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,producer);
			ps.setInt(2,id);
			int i = ps.executeUpdate();
			if (i==1) {
				LOGGER.info(producer + " was updated in Producers table");
				return true;
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return false;
		
	}

	@Override
	public boolean deleteProducer(int id) {
		String sql = "DELETE from producers WHERE id=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if (i==1) {
				LOGGER.info("producer with id= " + id + " was deleted from Producers table");
				return true;
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return false;
	}

	@Override
	public String getProducerById(int id) {
		String sql = "SELECT PRODUCER_NAME FROM producers p WHERE p.ID = ?";
		String producer="";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        producer = rs.getString("PRODUCER_NAME");
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getCause());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return producer;
		
	}

	public static int getGeneratedKeys() {
		return generatedKeys;
	}

	public static void setGeneratedKeys(int generatedKeys) {
		JDBCProducerDAO.generatedKeys = generatedKeys;
	}

}
