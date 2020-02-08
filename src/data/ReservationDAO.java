package data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Reservation;
import model.Reservations;
import util.MyConnectionProvider;

public class ReservationDAO {
	
	static Connection con;
    static PreparedStatement ps;
    
    public static ArrayList<Reservation>  listReservation(String idcomp){
    	ArrayList<Reservation> reservationListInDB = new ArrayList<Reservation>();
    	
    	
    	try {
    		
    		Connection conn = MyConnectionProvider.getDBConnection();	
    		ps=conn.prepareStatement("SELECT * from RESERVATION WHERE RESERVATIONID LIKE '%"+idcomp+"%'");			
    		ResultSet reservationList=ps.executeQuery();
    		while (reservationList.next()) {
    			Reservation reservation = new Reservation(); 
    			reservation.setReservationid(reservationList.getString("reservationid"));
    			reservation.setUsername(reservationList.getString("username"));
    			reservation.setParking_Area(reservationList.getString("parking_Area"));
    			reservation.setParking_Number(reservationList.getString("parking_Number"));
    			reservation.setStarttime_hour(reservationList.getString("starttime_hour"));
    			reservation.setStarttime_minutes(reservationList.getString("starttime_minutes"));
    			reservation.setEndtime_hour(reservationList.getString("endtime_hour"));
    
    			reservation.setEndtime_minutes(reservationList.getString("endtime_minutes"));
    			reservation.setCost(reservationList.getString("cost"));
    			System.out.println(reservation.getReservationid()+" "+reservation.getUsername());
    			reservationListInDB.add(reservation);	
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	
    	}
    	return reservationListInDB;
    }
    
    public static void DeleteReservation(String reservationid)
	{
		
		Statement stmt = null;	
		//String q1="Delete from  USERSTATUS where username="
		Connection conn = MyConnectionProvider.getDBConnection();
		try {
			System.out.println(reservationid);
			ps=conn.prepareStatement("Delete from  RESERVATION where reservationid=?;"); 
			ps.setString(1,reservationid);
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
