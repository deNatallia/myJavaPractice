package com.roxoft.sellcompany.threads;

import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

public class ConnThread extends Thread{
	private final static Logger LOGGER = LogManager.getLogger(ConnThread.class);
	private ConnectionPool pool;
	private Statement st;
	private ResultSet rs;
	
	ConnThread(ConnectionPool pool){
		this.pool = pool;
	}
	
	@Override
	public void run()
	{
		Connection conn = null;
		try {
			conn = pool.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from onlineshops where id=1");
			while (rs.next()){
				System.out.println(rs.getString("name"));
			}

		}
		catch (SQLException | InterruptedException e) {
			LOGGER.error("connection error");
		}
		finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
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
		for (int i=1; i<5; i++){
			new ConnThread(conpool).start();	
		}
	}	
}
