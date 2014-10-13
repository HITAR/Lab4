package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {
	private String url = "jdbc:mysql://127.0.0.1:3306/bookdb";
	private String username = "root";
	private String  password = "123456";
	public Connection  GetConn() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
