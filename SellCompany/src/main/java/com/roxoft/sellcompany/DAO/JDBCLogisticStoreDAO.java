package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

public class JDBCLogisticStoreDAO extends AbstractDAO implements ILogisticStoreDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCLogisticStoreDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void insertLogisticStore(LogisticStore logisticstore) {
		String sql = "INSERT into LogisticStores (NAME,LOADER_NUM,NEW_ARRIVAL_DATE,SQUARE,ADDRESSES_ID) VALUES (?,?,?,?,?)";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,logisticstore.getName());
			ps.setInt(2,logisticstore.getLoaderNum());
			ps.setDate(3, new java.sql.Date(logisticstore.getNewArrivalDate().getTime()));
			ps.setInt(4,logisticstore.getSquare());
			ps.setInt(5,(logisticstore.getAddress()).getId());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			if (rs.next()){
			   	logisticstore.setId(rs.getInt(1));
			}
			LOGGER.info("ID " +logisticstore.getId() + logisticstore.toString() + " was successfully added to LogisticStores table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}

	@Override
	public void updateLogisticStore(LogisticStore logisticstore) {
		String sql = "UPDATE LogisticStores SET NAME=?,LOADER_NUM=?,NEW_ARRIVAL_DATE=?,SQUARE=? WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,logisticstore.getName());
			ps.setInt(2,logisticstore.getLoaderNum());
			ps.setDate(3, new java.sql.Date(logisticstore.getNewArrivalDate().getTime()));
			ps.setInt(4,logisticstore.getSquare());
			ps.setInt(5,logisticstore.getId());
			ps.executeUpdate();
			LOGGER.info(logisticstore.toString() + " was updated at LogisticStores table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}

	@Override
	public void deleteLogisticStore(int id) {
		String sql = "DELETE from logisticstores WHERE id=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			LOGGER.info("Logisticstore with "+id + " was deleted from LogisticStores table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}

	@Override
	public LogisticStore getLogisticStoreById(int id) {
		String sql = "SELECT NAME,LOADER_NUM,NEW_ARRIVAL_DATE,SQUARE from logisticstores WHERE id=?";
		LogisticStore ls = new LogisticStore();
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        ls.setName(rs.getString("NAME"));
	        ls.setLoaderNum(rs.getInt("LOADER_NUM"));
	        ls.setNewArrivalDate(rs.getDate("NEW_ARRIVAL_DATE"));
	        ls.setSquare(rs.getInt("SQUARE"));
	    } catch (SQLException | InterruptedException | InvalidValueException e) {
			LOGGER.error(e.getMessage());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return ls;
	}
	@Override
	public int getIdAddress(int id) {
		String sql = "SELECT ADDRESSES_ID from logisticstores WHERE id=?";
		int addressId=0;
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        addressId = rs.getInt("ADDRESSES_ID");
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return addressId;
	}

}
