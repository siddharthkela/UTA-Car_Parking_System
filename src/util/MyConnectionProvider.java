package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionProvider implements MyProvider {
static 	Connection dbConnection = null;	 
public static Connection getDBConnection() {	

	try {	 
		Class.forName("com.mysql.jdbc.Driver");
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {	 
	}
return dbConnection;
}
}



