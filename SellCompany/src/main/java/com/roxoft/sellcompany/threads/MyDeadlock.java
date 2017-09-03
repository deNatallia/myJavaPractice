package com.roxoft.sellcompany.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyDeadlock extends Thread{
	private final static Logger log = LogManager.getLogger(MyDeadlock.class);
	private String str1;
    private String str2;
    
    public MyDeadlock(String str1, String str2) {
    	this.str1=str1;
    	this.str2=str2;
	}


	@Override
    public void run(){
    	synchronized(str2){
    		log.info(str1 +  " locks " + str2);         
        }
    	synchronized(str1){
    		log.info(str2 +  " locks " + str1);         
        }
    };
     
     
    public static void main(String a[]){
        MyDeadlock mdl = new MyDeadlock("Cat", "Mouse");
        mdl.start();
    }
}
