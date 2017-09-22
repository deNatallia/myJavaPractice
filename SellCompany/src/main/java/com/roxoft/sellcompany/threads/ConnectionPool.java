package com.roxoft.sellcompany.threads;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
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
	private final static int MAX_CONN = 3;
	private static ConnectionPool instance;
	private BlockingQueue<Connection> availableConn = new ArrayBlockingQueue<Connection>(MAX_CONN);
	private int usingConnNum = 0;
	
	private static Properties prop = new Properties();
	try {
		InputStream ist = new FileInputStream("src/main/resources/env.properties");
		prop.load(ist);
	}
	catch (Exception ie) {
		LOGGER.error("file not found");
	}
	private static final String driver = prop.getProperty("jdbc.driver");
	private static final String host = prop.getProperty("jdbc.host");
	private static final String user = prop.getProperty("jdbc.user");
	private static final String pass = prop.getProperty("jdbc.password");
	
	try {
		Class.forName(driver);
	}
	catch (ClassNotFoundException e){
		LOGGER.error(e.getStackTrace());
	}
	
//	private final String host = "jdbc:mysql://localhost:3306/sellcompany";
//	private final String user = "root";
//	private final String pass = "1234";
//	try {
//		Class.forName("com.mysql.jdbc.Driver");
//	}
//	catch (Exception e) {
//		LOGGER.error(e.getStackTrace());
//	}
	
	
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
		Connection conn = null;
		if (availableConn.size()!=0) {
			try {
				conn = availableConn.poll(200, TimeUnit.MILLISECONDS);
			}
			catch (InterruptedException e) {
				LOGGER.error("InterruptedException");
			}
		}
		else if (usingConnNum < MAX_CONN){
			try{
				conn = DriverManager.getConnection(host,user,pass);
			}
			catch (SQLException e){
				LOGGER.error(e.getSQLState());
			}
		}
		else {
			this.getConnection();
		}
		usingConnNum++;
		return conn;
	}
	
	public void returnConnection(Connection c) throws NullPointerException{
		if (c != null && availableConn.size() < MAX_CONN) {
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
