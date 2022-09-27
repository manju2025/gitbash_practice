package org.tyss.sales_and_inventory_Generic_script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	private Properties	prop;
	/**
	 * this method is used to fetch the data from Property file
	 * @param PROPERTY_FILE
	 * @param key
	 * @return
	 */
	public String getDataFromProperty(String PROPERTY_FILE,String key) {
		FileInputStream profile=null;
		try {
			profile = new FileInputStream(PROPERTY_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(profile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = property.getProperty(key).trim();
		return value;
	}
	
	/**
	 * this method is used to intialize the property file and all the key and value in hashmap table
	 * @param PROPERTY_FILE1
	 */
	public void intializePropertyFile(String PROPERTY_FILE1)
	{
		FileInputStream	profile1=null;
		try {
		profile1 = new FileInputStream(PROPERTY_FILE1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop=new Properties();
		try {
			prop.load(profile1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * this method is used to get the data from property file based on key specified.
	 * @param key1
	 * @return
	 */
	public String getDataFromPropertyAfterIntialize(String key1)
	{
		String value1 = prop.getProperty(key1);
		return value1;
	}
}
