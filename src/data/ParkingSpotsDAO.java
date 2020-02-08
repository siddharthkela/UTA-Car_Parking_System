package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import util.MyConnectionProvider;

import model.*;


public class ParkingSpotsDAO {
	
	static PreparedStatement ps;
	public static void StoreListinDB(String parkingarea,String parkingnumber,String membershiptype) {
		Statement stmt = null;		
		Connection conn = MyConnectionProvider.getDBConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Update parkingspots set isavailable=? where parking_Area=? AND parking_Number=? AND membership_type=? ");
			ps.setString(1,"0");
			ps.setString(2,parkingarea);
			ps.setInt(3, Integer.parseInt(parkingnumber));
			ps.setString(4,membershiptype);
			
			
				
			ps.executeUpdate();	
			 
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
