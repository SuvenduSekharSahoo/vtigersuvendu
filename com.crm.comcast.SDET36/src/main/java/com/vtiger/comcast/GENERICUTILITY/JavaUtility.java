package com.vtiger.comcast.GENERICUTILITY;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random r=new Random();
		int intRandom=r.nextInt(1000);
		return intRandom;
	}

	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString(); 
	}
	
	public String getCurrentDate(String strategy) {
		return new SimpleDateFormat(strategy).format(new Date());
	}
}
