package com.roxoft.sellcompany.threads;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
	private final static Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
	private final static int MAX_CONN = 10;
	private static ConnectionPool instance;
	private BlockingQueue<Connection> availableConn = new ArrayBlockingQueue<Connection>(MAX_CONN);
	private volatile int usingConnNum = 0;
	private String driver;
	private String host;
	private String user;
	private String password;
	private Properties prop;
	
	private ConnectionPool(){
		prop = new Properties();
		try {
			InputStream ist = new FileInputStream("src/main/resources/com/roxoft/sellcompany/env.properties");
			prop.load(ist);
		}
		catch (Exception e) {
			LOGGER.error("file not found", e.getMessage());
		}
	}
	
	public static ConnectionPool getInstance(){
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			if (instance == null) {
				instance = new ConnectionPool();
			}
			return instance;
		}
		finally {
			lock.unlock();
		}
	}
	
	public Connection getConnection() throws InterruptedException{
		driver = prop.getProperty("jdbc.driver");
		host = prop.getProperty("jdbc.host");
		user = prop.getProperty("jdbc.user");
		password = prop.getProperty("jdbc.password");
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e){
			LOGGER.error(e.getStackTrace());
		}
		Connection conn = null;
		if (availableConn.isEmpty() && usingConnNum < MAX_CONN){
			try{
				conn = DriverManager.getConnection(host,user,password);
			}
			catch (SQLException e){
				LOGGER.error(e.getSQLState());
			}
		}
		else if (availableConn.size()!=0) {
			try {
				conn = availableConn.poll(200, TimeUnit.MILLISECONDS);
			}
			catch (InterruptedException e) {
				LOGGER.error("InterruptedException");
			}
		}
		else {
			getConnection();
		}
		usingConnNum++;
		return conn;
	}
	
	public void returnConnection(Connection c) throws NullPointerException{
		if (c != null) {
			usingConnNum--;
	        availableConn.add(c);		
	    }
	}
	
	public void closeConnection(Connection c) throws NullPointerException{
		if (c != null ) {
	            availableConn.remove(c);
	    } else {
	    	LOGGER.error("Available Connections doesn't contain this Connection");			
	    }
	}

	public int getUsingConnNum() {
		return usingConnNum;
	}

	public void setUsingConnNum(int usingConnNum) {
		this.usingConnNum = usingConnNum;
	}
	

}
