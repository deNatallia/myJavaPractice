package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.models.shop.Supermarket;

public class JDBCSupermarketDAO extends AbstractDAO implements ISupermarketDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCSupermarketDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void insertSupermarket(Supermarket supermarket) {
		String sql = "INSERT into supermarkets (NAME,STAFF_NUM,NEW_ARRIVAL_DATE,SECTION_NUM,SQUARE,ADDRESSES_ID) VALUES (?,?,?,?,?,?)";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,supermarket.getName());
			ps.setInt(2,supermarket.getStaffNum());
			ps.setDate(3, new java.sql.Date(supermarket.getNewArrivalDate().getTime()));
			ps.setInt(4,supermarket.getSectionNum());
			ps.setInt(5,supermarket.getSquare());
			ps.setInt(6,(supermarket.getAddress()).getId());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			if (rs.next()){
				supermarket.setId(rs.getInt(1));
			}
			LOGGER.info(supermarket.toString() + " was successfully added to Supermarkets table");
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
	public void updateSupermarket(Supermarket supermarket) {
		String sql = "UPDATE supermarkets SET NAME=?,STAFF_NUM=?,NEW_ARRIVAL_DATE=?,SECTION_NUM=?,SQUARE=? WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,supermarket.getName());
			ps.setInt(2,supermarket.getStaffNum());
			ps.setDate(3, new java.sql.Date(supermarket.getNewArrivalDate().getTime()));
			ps.setInt(4,supermarket.getSectionNum());
			ps.setInt(5,supermarket.getSquare());
			ps.setInt(6,supermarket.getId());
			ps.executeUpdate();
			LOGGER.info(supermarket.toString() + " was updated at Supermarkets table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}

	@Override
	public void deleteSupermarket(int id) {
		String sql = "DELETE from supermarkets WHERE id=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			LOGGER.info("Supermarket with id "+id + " was deleted from Supermarkets table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}

	@Override
	public Supermarket getSupermarketById(int id) {
		String sql = "SELECT NAME,STAFF_NUM,NEW_ARRIVAL_DATE,SECTION_NUM,SQUARE from supermarkets WHERE id=?";
		Supermarket sm = new Supermarket();
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        sm.setName(rs.getString("NAME"));
	        sm.setStaffNum(rs.getInt("STAFF_NUM"));
	        sm.setNewArrivalDate(rs.getDate("NEW_ARRIVAL_DATE"));
	        sm.setSectionNum(rs.getInt("SECTION_NUM"));
	        sm.setSquare(rs.getInt("SQUARE"));
	    } catch (SQLException | InterruptedException | InvalidValueException e) {
	    	LOGGER.error(e.getMessage());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return sm;
	}
	@Override
	public int getIdAddress(int id) {
		String sql = "SELECT ADDRESSES_ID from supermarkets WHERE id=?";
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
