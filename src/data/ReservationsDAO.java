package data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import model.Reservations;
import util.MyConnectionProvider;
public class ReservationsDAO {
	 static Connection con;
     static PreparedStatement ps;

	
	
	
	public static ArrayList<Reservations>  listReservations() {
		
		
		ArrayList<Reservations> reservationsListInDB = new ArrayList<Reservations>();
		
	
		
	try {
	
		Connection conn = MyConnectionProvider.getDBConnection();	
		ps=conn.prepareStatement("SELECT * from RESERVATION ORDER BY reservationid");			
		ResultSet reservationsList=ps.executeQuery();
		while (reservationsList.next()) {
			Reservations reservations = new Reservations(); 
			reservations.setReservationid(reservationsList.getString("reservationid"));
			reservations.setUsername(reservationsList.getString("username"));
			reservations.setParking_Area(reservationsList.getString("parking_Area"));
			reservations.setParking_Number(reservationsList.getString("parking_Number"));
			reservations.setStarttime_hour(reservationsList.getString("starttime_hour"));
			reservations.setStarttime_minutes(reservationsList.getString("starttime_minutes"));
			reservations.setEndtime_hour(reservationsList.getString("endtime_hour"));
			reservations.setEndtime_minutes(reservationsList.getString("endtime_minutes"));
			reservations.setCost(reservationsList.getString("cost"));
			System.out.println(reservations.getReservationid()+" "+reservations.getUsername());
			reservationsListInDB.add(reservations);	
		}
	} catch (SQLException e) {
		e.printStackTrace();
	
	}
	return reservationsListInDB;
		
		
}

}
