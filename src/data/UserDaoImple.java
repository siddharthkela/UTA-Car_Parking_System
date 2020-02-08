package data;
import java.sql.Connection;
import model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Parking;
import model.USER;
import util.MyConnectionProvider;



 public class UserDaoImple {
      static Connection con;
              static PreparedStatement ps;
                      
                           
	
	public static ArrayList<USER> getUserByuserName1() {
		// TODO Auto-generated method stub
		
		ArrayList<USER> userListInDB = new ArrayList<USER>();
		Connection conn = MyConnectionProvider.getDBConnection();	
		try{
			
			
			ps=conn.prepareStatement("Select * from user");	
				ResultSet rs=ps.executeQuery();	
				   while(rs.next()){
			        USER user =new USER();		   
				   user.setUsername(rs.getString(1));
				   user.setPassword(rs.getString(2));
				   user.setFirstname(rs.getString(3));
				   user.setLastname(rs.getString(4));			   
				   user.setRole(rs.getString(5));
				   user.setPhone(rs.getString(6));
				   user.setEmail(rs.getString(7));
				   user.setAddress(rs.getString(8));			   
				   user.setParkingpermittype(rs.getString(9));
				   user.setVehiclenumber(rs.getString(10));
				   user.setLicensenumber(rs.getString(11));			   
				   user.setStatus(rs.getString(13));
				  user.setUtaid(rs.getString(15));
				  System.out.println(rs.getString(14));
				   userListInDB.add(user);
				}
			}
			catch(SQLException e){
				e.printStackTrace();				
			}finally{
				try {
					conn.close();
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				};
			}
		return userListInDB;
	}
	
	public static ArrayList<USER> getUserByPassword(String password) {
		// TODO Auto-generated method stub
		
		ArrayList<USER> userListInDB = new ArrayList<USER>();
	
		
		try{
			Connection conn = MyConnectionProvider.getDBConnection();	
			
	         		ps=conn.prepareStatement("Select * from user where password LIKE '%"+password+"%' ORDER BY user_name");	
			    	ResultSet rs=ps.executeQuery();	
				   while(rs.next()){
			        USER user =new USER();		   
				   user.setUsername(rs.getString(1));
				   user.setPassword(rs.getString(2));
				   user.setFirstname(rs.getString(3));
				   user.setLastname(rs.getString(4));			   
				   user.setRole(rs.getString(5));
				   user.setPhone(rs.getString(6));
				   user.setEmail(rs.getString(7));
				   user.setAddress(rs.getString(8));			   
				   user.setParkingpermittype(rs.getString(9));
				   user.setVehiclenumber(rs.getString(10));
				   user.setLicensenumber(rs.getString(11));	
				   user.setDateofBirth(rs.getString(12));
				   user.setStatus(rs.getString(13));
				  user.setUtaid(rs.getString(15));
				   
				   
				   userListInDB.add(user);
		}
			}
			catch(Exception e){
			System.out.println("Not connected");	
			}
		return userListInDB;
	}
	public static ArrayList<USER> getUserByuserName(String username) {
		// TODO Auto-generated method stub
		
		ArrayList<USER> userListInDB = new ArrayList<USER>();
	
		
		try{
			Connection conn = MyConnectionProvider.getDBConnection();	
			
	         		ps=conn.prepareStatement("Select * from user where user_name LIKE '%"+username+"%' ORDER BY user_name");	
			    	ResultSet rs=ps.executeQuery();	
				   while(rs.next()){
			        USER user =new USER();		   
				   user.setUsername(rs.getString(1));
				   user.setPassword(rs.getString(2));
				   user.setFirstname(rs.getString(3));
				   user.setLastname(rs.getString(4));			   
				   user.setRole(rs.getString(5));
				   user.setPhone(rs.getString(6));
				   user.setEmail(rs.getString(7));
				   user.setAddress(rs.getString(8));			   
				   user.setParkingpermittype(rs.getString(9));
				   user.setVehiclenumber(rs.getString(10));
				   user.setLicensenumber(rs.getString(11));	
				   user.setDateofBirth(rs.getString(12));
				   user.setStatus(rs.getString(13));
				  user.setUtaid(rs.getString(15));
				   
				   
				   userListInDB.add(user);
		}
			}
			catch(Exception e){
			System.out.println("Not connected");	
			}
		return userListInDB;
	}
	public static ArrayList<USER> LoginUser(String username)
	{
		ArrayList<USER> userListInDB = new ArrayList<USER>();
		try{
			
			Connection conn = MyConnectionProvider.getDBConnection();	
		}catch(Exception e){
			System.out.println(e);
		}
		return userListInDB;
		
	}

	public static void UpdateUser(USER user) {
		
		Connection conn = MyConnectionProvider.getDBConnection();
		try {
		
			PreparedStatement ps = conn.prepareStatement("update user set  firstname=?, lastname=?, password=?, phone=? , address=?, role=? where user_name=?");
			ps.setString(1,user.getFirstname());
			ps.setString(2,user.getLastname());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getPhone());			
			ps.setString(5,user.getAddress());
			ps.setString(6,user.getRole());
			ps.setString(7,user.getUsername());
			ps.executeUpdate();			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		finally {
			try {
				conn.close();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}};
	} 
	public static void insertuser(USER user) {
		
		Connection conn = MyConnectionProvider.getDBConnection();
		Statement stmt = null;
		System.out.println("This fiuq3guirg3qur7q3hris the role"+user.getRole());
		try {
			
			stmt = conn.createStatement();
			String  Q1="INSERT INTO user (firstname,lastname, password, phone ,address, user_name,utaid,role,vehiclenumber,licensenumber)";
			String insertRevoke = Q1 + " VALUES ('"  
					+ user.getFirstname()  + "','"
					+ user.getLastname()  + "','"
					+ user.getPassword()  + "','"
					+ user.getPhone()  + "','"
					+ user.getAddress()  + "','"
					+ user.getUsername()  + "','"
					+ user.getUtaid()  + "','"
					+ user.getRole()  + "','"
					+ user.getVehiclenumber()  + "','"
					+ user.getLicensenumber() + "')";
			stmt.executeUpdate(insertRevoke);	
						 
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		finally {
			try {
				conn.close();
	
			} catch (SQLException e) {
				e.printStackTrace(); 
			}};
	}
	
	public static void StoreListinDB(Revoke revoke) {
		Statement stmt = null;		
		Connection conn = MyConnectionProvider.getDBConnection();
		try {
			stmt = conn.createStatement();
			String q1="INSERT INTO USERSTATUS (username,reason)"; 
			String insertRevoke = q1 + " VALUES ('"  
					+ revoke.getUsername()  + "','"
					+ revoke.getReason() + "')";
			stmt.executeUpdate(insertRevoke);	
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}};
	}
	public static void UnrevokeUser(String username)
	{
		
		Statement stmt = null;	
		//String q1="Delete from  USERSTATUS where username="
		Connection conn = MyConnectionProvider.getDBConnection();
		try {
			System.out.println(username);
			ps=conn.prepareStatement("Delete from  USERSTATUS where username=?;"); 
			ps.setString(1,username);
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
