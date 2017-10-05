package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCGoodDAO extends AbstractDAO implements IGoodDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCGoodDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private static int generatedKeys;
	
	@Override
	public boolean insertGood(String good) {
		String sql = "INSERT into goods (GOOD_NAME,AMOUNT) VALUES (?,?)";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			int i=0;
				ps.setString(1,good);
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
		LOGGER.info(good + " was successfully added to Goods table");
		return true;	
	}

	@Override
	public boolean updateGood(String good,int id) {
		String sql = "UPDATE goods SET GOOD_NAME=? WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,good);
			ps.setInt(2,id);
			int i = ps.executeUpdate();
			if (i==1) {
				LOGGER.info(good + " was updated at Goods table");
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
	public boolean deleteGood(int id) {
		String sql = "DELETE from goods WHERE id=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if (i==1) {
				LOGGER.info("good with id="+id + " was deleted from Goods table");
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
	public String getGoodById(int id) {
		String sql = "SELECT GOOD_NAME FROM goods g WHERE g.ID = ?";
		String good="";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        good = rs.getString("GOOD_NAME");
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getCause());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return good;
		
	}

	public static int getGeneratedKeys() {
		return generatedKeys;
	}

	public static void setGeneratedKeys(int generatedKeys) {
		JDBCGoodDAO.generatedKeys = generatedKeys;
	}

}
