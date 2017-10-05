package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.models.shop.Pavilion;

public class JDBCPavilionDAO extends AbstractDAO implements IPavilionDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCAddressDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public boolean insertPavilion(Pavilion pavilion) {
		String sql = "INSERT into pavilions (NAME,STAFF_NUM,NEW_ARRIVAL_DATE,PLACE_NUM,ADDRESSES_ID) VALUES (?,?,?,?,?)";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,pavilion.getName());
			ps.setInt(2,pavilion.getStaffNum());
			ps.setDate(3, new java.sql.Date(pavilion.getNewArrivalDate().getTime()));
			ps.setInt(4,pavilion.getPlaceNum());
			ps.setInt(5,JDBCAddressDAO.getGeneratedKey());
			int i = ps.executeUpdate();
			
			if (i==1) {
				LOGGER.info(pavilion.toString() + " was successfully added to Pavilions table");
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
	public boolean updatePavilion(Pavilion pavilion,int id) {
		String sql = "UPDATE pavilions SET NAME=?,STAFF_NUM=?,NEW_ARRIVAL_DATE=?,PLACE_NUM=? WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,pavilion.getName());
			ps.setInt(2,pavilion.getStaffNum());
			ps.setDate(3, new java.sql.Date(pavilion.getNewArrivalDate().getTime()));
			ps.setInt(4,pavilion.getPlaceNum());
			ps.setInt(5,id);
			int i = ps.executeUpdate();
			if (i==1) {
				LOGGER.info(pavilion.toString() + " was updated at Pavilions table");
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
	public boolean deletePavilion(int id) {
		String sql = "DELETE from pavilions WHERE id=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if (i==1) {
				LOGGER.info("Pavilion with " +id + " was deleted from Pavilions table");
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
	public Pavilion getPavilionById(int id) {
		String sql = "SELECT NAME,STAFF_NUM,NEW_ARRIVAL_DATE,PLACE_NUM from pavilions WHERE id=?";
		Pavilion pv = new Pavilion();
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        pv.setName(rs.getString("NAME"));
	        pv.setStaffNum(rs.getInt("STAFF_NUM"));
	        pv.setNewArrivalDate(rs.getDate("NEW_ARRIVAL_DATE"));
	        pv.setPlaceNum(rs.getInt("PLACE_NUM"));
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getCause());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return pv;
	}
	@Override
	public int getIdAddress(int id) {
		String sql = "SELECT ADDRESSES_ID from pavilions WHERE id=?";
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
