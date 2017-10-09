package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCFactoryHasGoodsDAO extends AbstractDAO implements IFactoryHasGoodsDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCFactoryHasGoodsDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public void insertFactoryHasGoods(int idGood, int idFactory) {
		String sql = "INSERT into factorystores_has_goods (FACTORYSTORES_ID,GOODS_ID) VALUES (?,?)";
			try {
				connection = getConpool().getConnection();
				ps = connection.prepareStatement(sql);
				ps.setInt(1,idFactory);
				ps.setInt(2,idGood);
				ps.executeUpdate();			
			} catch (SQLException | InterruptedException e) {
				LOGGER.error(e.getMessage());
			}
			finally {
				closePrStatement(ps);
				getConpool().returnConnection(connection);
			}
			LOGGER.info("idGood " + idGood + " and "+ "idFactoryStore " + idFactory +" was successfully added to Factorystores_has_Goods table");
	}
	
	@Override
	public void updateFactoryHasGoods(int idGood, int idFactory) {
		String sql = "UPDATE factorystores_has_goods SET GOODS_ID=? WHERE FACTORYSTORES_ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1,idGood);
			ps.setInt(2,idFactory);
			ps.executeUpdate();			
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		LOGGER.info("idGood " + idGood + " at "+ "idFactoryStore " + idFactory +" was successfully updated");
	}
	
	@Override
	public ArrayList<Integer> getAllGoodsId(int idFactory) {
		ArrayList<Integer> allGoodsId = new ArrayList<Integer>();
		String sql = "SELECT GOODS_ID from factorystores_has_goods WHERE FACTORYSTORES_ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, idFactory);
	        rs = ps.executeQuery();
	        while (rs.next()){
	        	allGoodsId.add(rs.getInt(1));
	        }   
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return allGoodsId;
	}
}
