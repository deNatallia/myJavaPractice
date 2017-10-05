package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.models.storehouse.LogisticStore;

public class JDBCLogisticsHasProducersDAO extends AbstractDAO implements ILogisticHasProducersDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCAddressDAO.class);

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public boolean insertLogisticHasProducers(int idProducer, int idLogistics) {
		String sql = "INSERT into logisticstores_has_producers (LOGISTICSTORES_ID,PRODUCERS_ID) VALUES (?,?)";
			try {
				connection = getConpool().getConnection();
				ps = connection.prepareStatement(sql);
				int i=0;
				ps.setInt(1,idLogistics);
				ps.setInt(2,idProducer);
				i = ps.executeUpdate();
				if (i==0) {
					return false;
				}				
			} catch (SQLException | InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				closePrStatement(ps);
				getConpool().returnConnection(connection);
			}
			LOGGER.info("idProducer " + idProducer + " and "+ "idLogisticStore " + idLogistics +" was successfully added to Producers table");
			return true;	
	}
	
	@Override
	public boolean updateLogisticHasProducers(int idProducer, int idLogistics) {
		String sql = "UPDATE logisticstores_has_producers SET PRODUCERS_ID=? WHERE LOGISTICSTORES_ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			int i=0;
			ps.setInt(1,idProducer);
			ps.setInt(2,idLogistics);
			i = ps.executeUpdate();
			if (i==0) {
				return false;
			}				
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		LOGGER.info("idProducer " + idProducer + " at "+ "idLogisticStore " + idLogistics +" was successfully updated");
		return true;	
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
			LOGGER.error(e.getCause());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return allProducersId;
	}
}
