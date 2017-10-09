package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCLogisticsHasProducersDAO extends AbstractDAO implements ILogisticHasProducersDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCLogisticsHasProducersDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void insertLogisticHasProducers(int idProducer, int idLogistics) {
		String sql = "INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (?,?)";
			try {
				connection = getConpool().getConnection();
				ps = connection.prepareStatement(sql);
				ps.setInt(1,idLogistics);
				ps.setInt(2,idProducer);
				ps.executeUpdate();			
			} catch (SQLException | InterruptedException e) {
				LOGGER.error(e.getMessage());
			}
			finally {
				closePrStatement(ps);
				getConpool().returnConnection(connection);
			}
			LOGGER.info("idProducer " + idProducer + " and "+ "idLogisticStore " + idLogistics +" was successfully added to Producers table");
	}
	
	@Override
	public void updateLogisticHasProducers(int idProducer, int idLogistics) {
		String sql = "UPDATE logisticstores_has_producers SET PRODUCERS_ID=? WHERE LOGISTICSTORES_ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1,idProducer);
			ps.setInt(2,idLogistics);
			ps.executeUpdate();			
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		LOGGER.info("idProducer " + idProducer + " at "+ "idLogisticStore " + idLogistics +" was successfully updated");	
	}

	@Override
	public ArrayList<Integer> getAllProducersId(int idLogistics) {
		ArrayList<Integer> allProducersId = new ArrayList<Integer>();
		String sql = "SELECT PRODUCERS_ID from logisticstores_has_producers WHERE LOGISTICSTORES_ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, idLogistics);
	        rs = ps.executeQuery();
	        while (rs.next()){
	        	allProducersId.add(rs.getInt(1));
	        }   
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return allProducersId;
	}
}
