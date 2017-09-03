package com.roxoft.sellcompany.threads;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ConnThread extends Thread{
	private final static Logger LOGGER = LogManager.getLogger(ConnThread.class.getName());
	private ConnectionPool pool; 
	
	ConnThread(ConnectionPool pool){
		this.pool = pool;
	}
	
	@Override
	public void run()
	{
		Connection conn = null;
		try {
			conn = pool.getConnection();
			LOGGER.info(this + " is connected");
			Thread.sleep(300);
		}
		catch (InterruptedException e) {
			LOGGER.error("connection error");
		}
		finally{
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
