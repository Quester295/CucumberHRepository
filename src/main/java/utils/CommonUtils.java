package utils;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_BASIC_TIME=30;
	
	
public  String getEmailWithTimestamp() { 
		
		Date date =new Date();
		
		return "shaalini"+ date.toString().replace("", "_").replace (":","_")+"@gmail.com";
	}



}