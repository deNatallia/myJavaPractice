package com.roxoft.sellcompany.threads;

import java.util.concurrent.Semaphore;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LoadingCar implements Runnable  {
	private final static Logger LOGGER = LogManager.getLogger(LoadingCar.class);
	Semaphore sem;
	String name;
	int palletsNum;
	
	public LoadingCar(Semaphore sem, String name, int palletsNum){
		this.sem=sem;
		this.name=name;
		this.palletsNum=palletsNum;
	}
	
	@Override
	public void run()
	{
		try {
			LOGGER.info(name + " waiting for loading");
			sem.acquire();
					
			for (int i=1; i<palletsNum; i++){
				LOGGER.info(name + ": " + i + " pallet is loading of " + palletsNum);
				Thread.sleep(100);
			}
			
		}
		catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally{
			LOGGER.info(name + " has been already loaded");
			sem.release();
		}
	}
	
	
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(3);
		new Thread(new LoadingCar(
				sem,"Car1",10)
		).start();
		new Thread(new LoadingCar(
				sem,"Car2",5)
		).start();
		new Thread(new LoadingCar(
				sem,"Car3",8)
		).start();
		new Thread(new LoadingCar(
				sem,"Car4",3)
		).start();
	}
}
