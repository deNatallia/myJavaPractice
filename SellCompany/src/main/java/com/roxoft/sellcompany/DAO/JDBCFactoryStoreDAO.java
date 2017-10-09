package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.models.storehouse.FactoryStore;

public class JDBCFactoryStoreDAO extends AbstractDAO implements IFactoryStoreDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCFactoryStoreDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void insertFactoryStore(FactoryStore factorystore) {
		String sql = "INSERT into FactoryStores (NAME,LOADER_NUM,SQUARE,ADDRESSES_ID) VALUES (?,?,?,?)";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,factorystore.getName());
			ps.setInt(2,factorystore.getLoaderNum());
			ps.setInt(3,factorystore.getSquare());
			ps.setInt(4,(factorystore.getAddress()).getId());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			if (rs.next()){
				factorystore.setId(rs.getInt(1));
				LOGGER.info(factorystore.toString() + " was successfully added to FactoryStores table");
			}
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
	public void updateFactoryStore(FactoryStore factorystore) {
		String sql = "UPDATE factorystores SET NAME=?,LOADER_NUM=?,SQUARE=? WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,factorystore.getName());
			ps.setInt(2,factorystore.getLoaderNum());
			ps.setInt(3,factorystore.getSquare());
			ps.setInt(4,factorystore.getId());
			ps.executeUpdate();
			LOGGER.info(factorystore.toString() + " was updated FactoryStores table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}

	@Override
	public void deleteFactoryStore(int id) {
		String sql = "DELETE from factorystores WHERE id=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			LOGGER.info("Factorystore with " +id+ " was deleted from FactoryStores table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}

	@Override
	public FactoryStore getFactoryStoreById(int id) {
		String sql = "SELECT NAME,LOADER_NUM,SQUARE from factorystores WHERE id=?";
		FactoryStore fs = new FactoryStore();
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        fs.setName(rs.getString("NAME"));
	        fs.setLoaderNum(rs.getInt("LOADER_NUM"));
	        fs.setSquare(rs.getInt("SQUARE"));
	    } catch (SQLException | InterruptedException | InvalidValueException e) {
			LOGGER.error(e.getCause());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return fs;
	}
	@Override
	public int getIdAddress(int id) {
		String sql = "SELECT ADDRESSES_ID from factorystores WHERE id=?";
		int addressId=0;
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        addressId = rs.getInt("ADDRESSES_ID");
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getCause());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return addressId;
	}
}
