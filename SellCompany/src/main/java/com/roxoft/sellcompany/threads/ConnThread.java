package com.roxoft.sellcompany.threads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ConnThread extends Thread{
	private final static Logger LOGGER = LogManager.getLogger(ConnThread.class);
	private ConnectionPool pool;
	private PreparedStatement st;
	private ResultSet rs;
	
	ConnThread(ConnectionPool pool){
		this.pool = pool;
	}
	
	public void run()
	{
		st = null;
		rs = null;
		Connection conn = null;
		
		try {
			conn = pool.getConnection();
			st = conn.prepareStatement("select * from onlineshops where id=?");
			st.setInt(1,1);
			rs = st.executeQuery();
			while (rs.next()){
				LOGGER.info(rs.getString("name"));
			}

		}
		catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getCause());
		}
		finally{
			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					LOGGER.error(e.getCause());
				}
			} 
			
			if (st != null){
				try {
					st.close();
				} catch (SQLException e) {
					LOGGER.error(e.getCause());
				}
			}
			if (conn != null){
				pool.returnConnection(conn);
				LOGGER.info(this + " was disconnected");
			}
		}
	}

	public ConnectionPool getPool() {
		return pool;
	}

	public void setPool(ConnectionPool pool) {
		this.pool = pool;
	}
	
	public static void main(String[] args){
		ConnectionPool conpool = ConnectionPool.getInstance();
//		for (int i=1; i<5; i++){
			new ConnThread(conpool).start();	
//		}
	}	
}
