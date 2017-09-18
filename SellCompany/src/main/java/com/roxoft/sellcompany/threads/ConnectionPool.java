package com.roxoft.sellcompany.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
	private final static Logger log = LogManager.getLogger(ConnectionPool.class);
	private final static int MAX_CONN = 3;
	private static ConnectionPool instance;
	private BlockingQueue<Connection> availableConn = new ArrayBlockingQueue<Connection>(MAX_CONN);
	private BlockingQueue<Connection> usingConn = new ArrayBlockingQueue<Connection>(MAX_CONN);
	private final int MAX_TIME=1000;
	private long startTime;
	private long availTime;
		
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
				usingConn.add(conn);
			}
			catch (InterruptedException e) {
				log.error("InterruptedException");
			}
		}
		else if (usingConn.size() < MAX_CONN){
			conn = new Connection();
			usingConn.add(conn);
		}
		else {
			this.getConnection();
		}
		startTime = System.currentTimeMillis();
		return conn;
	}
	
	public void returnConnection(Connection c) throws NullPointerException{
		if (c != null && availableConn.size() < MAX_CONN) {
			usingConn.remove(c);
	        availableConn.add(c);		
	    }
	}
	
	public void closeConnection(Connection c) throws NullPointerException{
		availTime = System.currentTimeMillis()-startTime;
		if (c != null && availTime > MAX_TIME) {
	            availableConn.remove(c);
	    } else {
	    	log.error("Available Connections doesn't contain this Connection");			
	    }
	}
	
}
