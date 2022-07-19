package com.vtiger.comcast.GENERICUTILITY;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @return
	 * @throws IOException 
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws IOException  
	{
   	 FileInputStream fis = new FileInputStream("CommonData/commondata.properties");
   	 Properties pobj = new Properties();
   	 pobj.load(fis);
   	 String value=pobj.getProperty(key);
	 return value;
	
	}

}
