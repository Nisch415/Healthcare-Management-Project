package Project;
import java.sql.*;

public class ConnectBloodBank {
	public static Connection getCon()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbank","root","projpass04");
			return con;
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
