package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


import model.Parking;
import util.MyConnectionProvider;

public class ParkingDAO {
	

static PreparedStatement ps;
	public static void StoreListinDB(Parking parking) {
		Statement stmt = null;		
		Connection conn = MyConnectionProvider.getDBConnection();
		try {
			stmt = conn.createStatement();
			String q1="INSERT INTO PARKINGAREAS (parking_area,capacity,floor,type,cart,camera,history)"; 
			String insertParking = q1 + " VALUES ('"  
					+ parking.getParking_area()  + "','"
					+ parking.getCapacity() + "','"		
					+ parking.getFloor() + "','"
					+ parking.getType() + "','"
					+ parking.getCart() + "','"
					+ parking.getCamera() + "','"
					+ parking.getHistory()+"')";
			stmt.executeUpdate(insertParking);	
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}};
	}
	
	

}
