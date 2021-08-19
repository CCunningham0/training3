package revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conn = null;
	private ConnectionFactory() {};
	
	public static Connection getConnection() {
		if (conn == null) {
			String url = "jdbc:mysql://localhost:3306/day27Exercise";
			String username = "root";
			String password = "root";

			try {
				// **Fixes "no suitable driver..." error
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
}
