package functions;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;

public class Functions {
	 
	public static WebDriver driver;
	public static Properties prop;
	public void Registration(WebDriver driver,String sfirstname, String slastname, String sutaid,
			String saddress,String susername,String semail,String spassword,String sphone, String sdlnumber,
	 		String svnumber,String spermit,String suserrole) throws Exception
	{  
		driver.findElement(By.id(prop.getProperty("Txt_Register_FirstName"))).clear(); 
	    driver.findElement(By.id(prop.getProperty("Txt_Register_FirstName"))).sendKeys(sfirstname);
	    driver.findElement(By.id(prop.getProperty("Txt_Register_LastName"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Register_LastName"))).sendKeys(slastname);
	    driver.findElement(By.id(prop.getProperty("Txt_Register_UtaID"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Register_UtaID"))).sendKeys(sutaid);
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Address"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Address"))).sendKeys(saddress);
	    driver.findElement(By.id(prop.getProperty("Txt_Register_UserName"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Register_UserName"))).sendKeys(susername);
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Email"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Email"))).sendKeys(semail);
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Password"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Password"))).sendKeys(spassword);
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Phone"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Phone"))).sendKeys(sphone);
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Dlnumber"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Register_Dlnumber"))).sendKeys(sdlnumber);
	    driver.findElement(By.name(prop.getProperty("Txt_Register_Vnumber"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Register_Vnumber"))).sendKeys(svnumber);
	    new Select(driver.findElement(By.name(prop.getProperty("Lst_Register_Permit")))).selectByVisibleText(spermit);
	    new Select(driver.findElement(By.id(prop.getProperty("Lst_Register_Role")))).selectByVisibleText(suserrole);
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector(prop.getProperty("Lnk_Register_Submit"))).click();
	    
	} 
	public void Login(WebDriver driver,String susername,String spassword,String sUser) throws InterruptedException
	{
		driver.findElement(By.id(prop.getProperty("Txt_Login_UserName"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Login_UserName"))).sendKeys(susername);
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys(spassword);
	    new Select(driver.findElement(By.id(prop.getProperty("Lnk_Login_UserType")))).selectByVisibleText(sUser);
	    driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();
	    
	} 
	
	public void DeleteSpecificReservation(WebDriver driver, String reservationID)
	{
		 driver.findElement(By.id(prop.getProperty("Txt_DeleteSpecificReservation_ID"))).clear();
		 driver.findElement(By.id(prop.getProperty("Txt_DeleteSpecificReservation_ID"))).sendKeys(reservationID);
		 driver.findElement(By.id(prop.getProperty("Btn_DeleteSpecificReservation_Submit"))).click();
	}
	  
	public void ViewSpecificReservation(WebDriver driver, String reservation,String error,String idError)
	{
		 driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_View"))).click();
		 driver.findElement(By.id(prop.getProperty("Txt_ViewSpecificReservation_ID"))).clear();
		 driver.findElement(By.id(prop.getProperty("Txt_ViewSpecificReservation_ID"))).sendKeys(reservation);
		 driver.findElement(By.id("searchreservation")).click();
		 assertEquals(error,(driver.findElement(By.id("erMsg")).getAttribute("value")));
		 assertEquals(idError,(driver.findElement(By.id(prop.getProperty("ErrMsg_SearchReservation_IdError"))).getAttribute("value")));
		 
	}
	
	public void FinalViewSpecificReservation(WebDriver driver, String reservation)
	{
		 driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_View"))).click();
		 driver.findElement(By.id(prop.getProperty("Txt_ViewSpecificReservation_ID"))).clear();
		 driver.findElement(By.id(prop.getProperty("Txt_ViewSpecificReservation_ID"))).sendKeys(reservation);
		 driver.findElement(By.id("searchreservation")).click();
		 
	}
	
	
	public void ViewUsers(WebDriver driver){
		driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_ViewUsers"))).click();
	    driver.findElement(By.id("searchUser")).click();
	    driver.findElement(By.linkText(prop.getProperty("Btn_ViewUser_BackToHome"))).click();
	}
	
	public void ViewReservations(WebDriver driver){
		driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_ViewReservations"))).click();
	    driver.findElement(By.id(prop.getProperty("Btn_ViewReservations_Find"))).click();
	    driver.findElement(By.linkText(prop.getProperty("Lnk_ViewReservations_BackToHome"))).click();
	}
	public void Revoke(WebDriver driver,String username,String reason,String error,String usernameError,String reasonError){
		driver.findElement(By.linkText(prop.getProperty("Lnk_AdminHome_Revoke"))).click();
	    driver.findElement(By.id(prop.getProperty("Txt_Revoke_Username"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Revoke_Username"))).sendKeys(username);
	    driver.findElement(By.id(prop.getProperty("Txt_Revoke_Reason"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Revoke_Reason"))).sendKeys(reason);
	    driver.findElement(By.id(prop.getProperty("Btn_Revoke_revoke"))).click();
	    assertEquals(error,(driver.findElement(By.id(prop.getProperty("ErrMsg_Revoke_Error"))).getAttribute("value")));
	    assertEquals(usernameError,(driver.findElement(By.id(prop.getProperty("ErrMsg_Revoke_Username"))).getAttribute("value")));
	    assertEquals(reasonError,(driver.findElement(By.id(prop.getProperty("ErrMsg_Revoke_Reason"))).getAttribute("value")));
	    
	}
	 
	public void FinalRevoke(WebDriver driver,String username,String reason){
		driver.findElement(By.linkText(prop.getProperty("Lnk_AdminHome_Revoke"))).click();
	    driver.findElement(By.id(prop.getProperty("Txt_Revoke_Username"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Revoke_Username"))).sendKeys(username);
	    driver.findElement(By.id(prop.getProperty("Txt_Revoke_Reason"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Revoke_Reason"))).sendKeys(reason);
	    driver.findElement(By.id(prop.getProperty("Btn_Revoke_revoke"))).click();
	    
	}
	
	public void Unrevoke(WebDriver driver,String username){
		driver.findElement(By.linkText(prop.getProperty("Lnk_AdminHome_Unrevoke"))).click();
	    driver.findElement(By.id(prop.getProperty("Lnk_Unrevoke_Uname"))).clear();
	    driver.findElement(By.id(prop.getProperty("Lnk_Unrevoke_Uname"))).sendKeys(username);
	    driver.findElement(By.id(prop.getProperty("Btn_Unrevoke_unrevoke"))).click();
	    driver.findElement(By.id(prop.getProperty("Btn_AdminHome_Logout"))).click();
	    
	}
	
	public void SetUnavailable(WebDriver driver,String parkingarea,String parkingnumber,String type,String error, String areaError,String numberError, String typeError){
		
		 driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_SetSpotUnavailable"))).click();
		    driver.findElement(By.id(prop.getProperty("Txt_available_parkingarea"))).clear();
		    driver.findElement(By.id(prop.getProperty("Txt_available_parkingarea"))).sendKeys(parkingarea);
		    driver.findElement(By.id(prop.getProperty("Txt_available_parkingnumber"))).clear();
		    driver.findElement(By.id(prop.getProperty("Txt_available_parkingnumber"))).sendKeys(parkingnumber);
		    driver.findElement(By.id(prop.getProperty("Txt_available_type"))).clear();
		    driver.findElement(By.id(prop.getProperty("Txt_available_type"))).sendKeys(type);
		    driver.findElement(By.id(prop.getProperty("Btn_available_unavailable"))).click();
		    
		    assertEquals(error,(driver.findElement(By.id(prop.getProperty("ErrMsg_Available_error"))).getAttribute("value")));
		    assertEquals(areaError,(driver.findElement(By.id(prop.getProperty("ErrMsg_Available_area"))).getAttribute("value")));
		    assertEquals(numberError,(driver.findElement(By.id(prop.getProperty("ErrMsg_Available_number"))).getAttribute("value")));
		    assertEquals(typeError,(driver.findElement(By.id(prop.getProperty("ErrMsg_Available_type"))).getAttribute("value")));
	}
	
	
	
	public void AddParkingArea(WebDriver driver,String parking_area,String capacity,String floor,String type,String cart,String camera,String history,String errormsg,String parkingareaError,String capacityError,String floorError,String typeError,String cartError,String cameraError,String historyError){
		driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_AddParking"))).click();
		driver.findElement(By.id(prop.getProperty("Txt_FormParking_ParkingArea"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_ParkingArea"))).sendKeys(parking_area);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Capacity"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Capacity"))).sendKeys(capacity);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Floor"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Floor"))).sendKeys(floor);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Type"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Type"))).sendKeys(type);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Cart"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Cart"))).sendKeys(cart);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Camera"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Camera"))).sendKeys(camera);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_History"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_History"))).sendKeys(history);
	    driver.findElement(By.id(prop.getProperty("Btn_FormParking_Insert"))).click();
	     
	    assertEquals(errormsg,(driver.findElement(By.id(prop.getProperty("ErrMsg_FormParking_Errormsg"))).getAttribute("value")));
	    assertEquals(parkingareaError,(driver.findElement(By.id(prop.getProperty("ErrMsg_FormParking_ParkingAreaError"))).getAttribute("value")));
	    assertEquals(capacityError,(driver.findElement(By.id(prop.getProperty("ErrMsg_FormParking_CapacityErrorMsg"))).getAttribute("value")));
	    assertEquals(floorError,(driver.findElement(By.id(prop.getProperty("ErrMsg_FormParking_FloorErrorMsg"))).getAttribute("value")));
	    assertEquals(typeError,(driver.findElement(By.id(prop.getProperty("ErrMsg_FormParking_TypeErrorMsg"))).getAttribute("value")));
	    assertEquals(cartError,(driver.findElement(By.id(prop.getProperty("ErrMsg_FormParking_CartErrorMsg"))).getAttribute("value")));
	    assertEquals(cameraError,(driver.findElement(By.id(prop.getProperty("ErrMsg_FormParking_CameraErrorMsg"))).getAttribute("value")));
	    assertEquals(historyError,(driver.findElement(By.id(prop.getProperty("ErrMsg_FormParking_HistoryErrorMsg"))).getAttribute("value")));
	}
	
	public void FinalAddParkingArea(WebDriver driver,String parkingarea, String capacity,String floor,String type,String cart,String camera,String history){
		driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_AddParking"))).click();
		driver.findElement(By.id(prop.getProperty("Txt_FormParking_ParkingArea"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_ParkingArea"))).sendKeys(parkingarea);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Capacity"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Capacity"))).sendKeys(capacity);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Floor"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Floor"))).sendKeys(floor);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Type"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Type"))).sendKeys(type);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Cart"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Cart"))).sendKeys(cart);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Camera"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_Camera"))).sendKeys(camera);
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_History"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_FormParking_History"))).sendKeys(history);
	    driver.findElement(By.id(prop.getProperty("Btn_FormParking_Insert"))).click();
	}
	
	public void SetAvailability(WebDriver driver,String parking_Area,String parking_Number,String membership_type) throws InterruptedException
	{
		   
		                   
		driver.findElement(By.name(prop.getProperty("Txt_Available_ParkingArea"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Available_ParkingArea"))).sendKeys(parking_Area);
	    Thread.sleep(1000);
	    driver.findElement(By.id(prop.getProperty("Txt_Available_ParkingNumber"))).clear();
	    driver.findElement(By.id(prop.getProperty("Txt_Available_ParkingNumber"))).sendKeys(parking_Number);
	    Thread.sleep(1000);
	    driver.findElement(By.name(prop.getProperty("Txt_Available_MembershipType"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_Available_MembershipType"))).sendKeys(membership_type);
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(prop.getProperty("Btn_Available_SetStatus"))).click();
	    
	}
	
	public void SearchUser(WebDriver driver,String username) throws InterruptedException
	{
		driver.findElement(By.name(prop.getProperty("Txt_SearchUser_Username"))).clear();
	    driver.findElement(By.name(prop.getProperty("Txt_SearchUser_Username"))).sendKeys(username);
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(prop.getProperty("Btn_SearchUser_SearchButton"))).click();
	    
	}
	
	public void UpdateUser(WebDriver driver,String userrole) throws InterruptedException
	{
	     Thread.sleep(4000);
		 new Select(driver.findElement(By.id(prop.getProperty("Lst_UpdateUser_UserRole")))).selectByVisibleText(userrole);
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(prop.getProperty("Btn_UpdateUser_UpdateButton"))).click();
		 Thread.sleep(3000);
		 
	}
	
	

}
