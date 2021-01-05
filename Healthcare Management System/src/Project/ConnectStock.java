package Project;
import java.sql.*;

public class ConnectStock {
	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StockUnits","root","projpass04");
			return con;
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
