package com.roxoft.sellcompany.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.threads.ConnectionPool;

public abstract class AbstractDAO {
	private final static Logger LOGGER = LogManager.getLogger(AbstractDAO.class);
	private ConnectionPool getConpool;
	
	public void closePrStatement(PreparedStatement ps){
		if (ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				LOGGER.error(e.getCause());
			}
		}
	}
	public void closeRSet(ResultSet rs){
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error(e.getCause());
			}
		} 
	}
	
	public ConnectionPool getConpool() {
		return getConpool;
	}
	public void setConpool(ConnectionPool conpool) {
		this.getConpool = conpool;
	}

}
