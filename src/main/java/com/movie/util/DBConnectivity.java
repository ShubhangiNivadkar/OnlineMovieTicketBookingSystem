package com.movie.util;
import java.sql.*;

public class DBConnectivity {

	public static Connection getConnection() {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/movieproject?user=root&password=root";
			con=DriverManager.getConnection(url);
			
//show create table movie
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
}
