package org.tyss.sales_and_inventory_Generic_script;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DButility {

/*Conversation opened. 1 read message. 

//Skip to content
/Using Gmail with screen readers
in:spam 
Enable desktop notifications for Gmail.
   OK  No, thanks
2 of 52
7 items
Spam
prem kumar <premraj.pk77@outlook.com>
Attachments
18:23 (3 hours ago)
to me

Why is this message in spam? It is similar to messages that were identified as spam in the past.
Report as not spam
 

 

Sent from Mail for Windows

 

6
 Attachments
  • Scanned by Gmail
DataBase Utility:
------------------

/**
 * This class is used to get connection to database and get data or set data to database
 * @author PREM KUMAR R
 *
 */
public class DB_Utility {
	private Connection connection;
	/**
	 * this method is used to get connection to the database 
	 * @param url
	 * @param Db_un
	 * @param Db_pwd
	 * @return
	 */
	public Connection getConnection(String url,String Db_un,String Db_pwd )
	{
		Driver dbdriver=null;
		try {
			dbdriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//step2--> register the driver instance to the jdbc
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//step3--> get/establish the database connection
		try {
			connection = DriverManager.getConnection(url, Db_un, Db_pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * this method is used to get data from database
	 * @param query
	 * @param colname
	 * @return
	 */
	public List<String> getDataFromDb(String query, String colname)
	{
		Statement statement=null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//step5--> execute the query 
		ResultSet result=null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> arr = new ArrayList<String>();
	    //step6-->verify or iterate or fetch the data
		try {
			while(result.next()) {
			arr.add(result.getString(colname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	/**
	 * this method is used to close the connection of database
	 */
	public void closeConnection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to validate the database data with expected value
	 * @param query1
	 * @param colname1
	 * @param expectedvalue
	 * @return
	 */
	public boolean verifyDataInsideDatabase(String query1, String colname1, String expectedvalue)
	{
		List<String> arr = getDataFromDb(query1, colname1);
		boolean flag=false;
		for(String s:arr)
		{
			if(s.equalsIgnoreCase(expectedvalue))
			{
				flag=true;
				break;
			}
		}
		return flag;
		
	}
	
	public void setDataToDataBase(String query1)
	{
		Statement statement=null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		int result=0;
		try {
			result = statement.executeUpdate(query1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result==1) {
			System.out.println(result+"dataupdated succesfully");
		}
	}
}
public class Get_and_SetDataInto_DB {

	public void main(String[] args) {
		DB_Utility DBU = new DB_Utility();
		DBU.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		List<String> arr = DBU.getDataFromDb("select * from sdet40;", "Emp_name");
		for(String d:arr)
		{
			System.out.println(d);
		}
		DBU.setDataToDataBase("insert into sdet40 values(901,'raju', 41785236,'bagalkot');");
		List<String> brr = DBU.getDataFromDb("select * from sdet40;", "Emp_name");
		for(String b:brr)
		{
			System.out.println(b);
		}
		boolean result = DBU.verifyDataInsideDatabase("select * from sdet40;", "Emp_name", "raju");
		System.out.println(result);
		DBU.closeConnection();
	}

}
}
