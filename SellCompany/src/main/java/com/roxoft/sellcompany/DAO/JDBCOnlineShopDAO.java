package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.models.shop.OnlineShop;

public class JDBCOnlineShopDAO extends AbstractDAO implements IOnlineShopDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCAddressDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public boolean insertOnlineShop(OnlineShop onlineshop) {
		String sql = "INSERT into onlineshops (NAME,STAFF_NUM,NEW_ARRIVAL_DATE,SITE,MANAGERS_NUM,ADDRESSES_ID) VALUES (?,?,?,?,?,?)";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,onlineshop.getName());
			ps.setInt(2,onlineshop.getStaffNum());
			ps.setDate(3, new java.sql.Date(onlineshop.getNewArrivalDate().getTime()));
			ps.setString(4,onlineshop.getSite());
			ps.setInt(5,onlineshop.getManagersNum());
			ps.setInt(6,JDBCAddressDAO.getGeneratedKey());
			int i = ps.executeUpdate();
			
			if (i==1) {
				LOGGER.info(onlineshop.toString() + " was successfully added to Onlineshops table");
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
	public boolean updateOnlineShop(OnlineShop onlineshop,int id) {
		String sql = "UPDATE onlineshops SET NAME=?,STAFF_NUM=?,NEW_ARRIVAL_DATE=?,SITE=?,MANAGERS_NUM=? WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,onlineshop.getName());
			ps.setInt(2,onlineshop.getStaffNum());
			ps.setDate(3, new java.sql.Date(onlineshop.getNewArrivalDate().getTime()));
			ps.setString(4,onlineshop.getSite());
			ps.setInt(5,onlineshop.getManagersNum());
			ps.setInt(6,id);
			int i = ps.executeUpdate();
			if (i==1) {
				LOGGER.info(onlineshop.toString() + " was updated at Onlineshops table");
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
	public boolean deleteOnlineShop(int id) {
		String sql = "DELETE from onlineshops WHERE id=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if (i==1) {
				LOGGER.info("Onlineshop with " + id + " was deleted from Onlineshops table");
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
	public OnlineShop getOnlineShopById(int id) {
		String sql = "SELECT NAME,STAFF_NUM,NEW_ARRIVAL_DATE,SITE,MANAGERS_NUM from onlineshops WHERE id=?";
		OnlineShop os = new OnlineShop();
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        os.setName(rs.getString("NAME"));
	        os.setStaffNum(rs.getInt("STAFF_NUM"));
	        os.setNewArrivalDate(rs.getDate("NEW_ARRIVAL_DATE"));
	        os.setManagersNum(rs.getInt("MANAGERS_NUM"));
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getCause());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return os;
	}
	@Override
	public int getIdAddress(int id) {
		String sql = "SELECT ADDRESSES_ID from onlineshops WHERE id=?";
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
