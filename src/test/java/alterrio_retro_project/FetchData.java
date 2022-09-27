package alterrio_retro_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.dockerjava.api.model.Driver;

public class FetchData {
	public static void main(String[] args) throws SQLException {
		Driver dbdriver=new Driver();
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmg", "root", "root");
	Statement Statement = connection.createStatement();
	ResultSet result = Statement.executeQuery("Select * from sdet40;");
	while(result.next())
	{
	System.out.println(result.getString("Emp_Name"));	
	}
	}

}
