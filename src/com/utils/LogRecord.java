package com.utils;

import org.apache.log4j.Logger;

public class LogRecord {
	 private static Logger info = Logger.getLogger("InfoLogger");  
	    private static Logger error = Logger.getLogger("ErrorLogger");  
	    public LogRecord(){}  
	      
	    /** 
	     * һ�������¼��/logs/infoLog.txt 
	     */  
	    public static void info(String infomation){  
	        info.info(infomation);  
	    }  
	      
	    /** 
	     * ������Ϣ��¼��/logs/errorLog.txt 
	     */  
	    public static void error(String infomation){  
	        error.error(infomation);  
	    }  
}
