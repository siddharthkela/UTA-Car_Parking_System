package selenium;
 
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;
import java.io.FileInputStream;


import functions.*;
  
public class SeleniumTC09 extends Functions { 
  /*private WebDriver driver;*/ 
  private String baseUrl;
  private boolean acceptNextAlert = true; 
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL, sSharedUIMapPath; 
 /* public Properties prop;*/
   
  @Before 
  public void setUp() throws Exception {
	   
	System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8079/";
    prop= new Properties();
      
    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
    sAppURL = prop.getProperty("sAppURL");
   sSharedUIMapPath = prop.getProperty("SharedUIMap");
    prop.load(new FileInputStream(sSharedUIMapPath));
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  } 
 
  @Test
  public void testSeleniumTC09() throws Exception {
    driver.get(sAppURL);
    Thread.sleep(4000);
    driver.findElement(By.linkText(prop.getProperty("Lnk_Login_ClickHereToRegister"))).click();
    Registration(driver,"Hari","G","1001552486","Arlington","hari","hari@gmail.com","Qwerty#123",
    		"1234567890","DL12345678","hg123","Premium","Manager");
    Login(driver,"hari","Qwerty#123","Manager");
     
    
    /*driver.findElement(By.id(prop.getProperty("Txt_Register_FirstName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_FirstName"))).sendKeys("Hari");
    driver.findElement(By.id(prop.getProperty("Txt_Register_LastName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_LastName"))).sendKeys("G");
    driver.findElement(By.id(prop.getProperty("Txt_Register_UtaID"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_UtaID"))).sendKeys("1001552486");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Address"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Address"))).sendKeys("Arlington");
    driver.findElement(By.id(prop.getProperty("Txt_Register_UserName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_UserName"))).sendKeys("hari");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Email"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Email"))).sendKeys("hari@gmail.com");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Password"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Password"))).sendKeys("Qwerty#123");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Phone"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Phone"))).sendKeys("1234567890");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Dlnumber"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Dlnumber"))).sendKeys("DL12345678");
    driver.findElement(By.name(prop.getProperty("Txt_Register_Vnumber"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_Register_Vnumber"))).sendKeys("hg123");
    new Select(driver.findElement(By.name(prop.getProperty("Lst_Register_Permit")))).selectByVisibleText("Premium");
    new Select(driver.findElement(By.id(prop.getProperty("Lst_Register_Role")))).selectByVisibleText("Manager");
    driver.findElement(By.cssSelector(prop.getProperty("Lnk_Register_Submit"))).click();
    driver.findElement(By.name(prop.getProperty("Txt_Login_UserName"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_Login_UserName"))).sendKeys("hari");
    driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).sendKeys("Qwerty#123");
    new Select(driver.findElement(By.name(prop.getProperty("Lnk_Login_UserType")))).selectByVisibleText("Manager");
    driver.findElement(By.name(prop.getProperty("Btn_Login_Login"))).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_SearchUsers"))).click();
    Thread.sleep(3000);
    driver.findElement(By.name(prop.getProperty("Btn_ManagerHome_Find"))).click(); 
    Thread.sleep(3000); 
    driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_BackToHome"))).click();
    Thread.sleep(3000); 
    driver.findElement(By.linkText(prop.getProperty("Lnk_Available_SetSpotUnavailable"))).click();
    SetAvailability(driver,"West Garage Floor 5","5","basic");
    
    driver.findElement(By.name(prop.getProperty("Txt_Available_ParkingArea"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_Available_ParkingArea"))).sendKeys("West Garage Floor 5");
    driver.findElement(By.id(prop.getProperty("Txt_Available_ParkingNumber"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Available_ParkingNumber"))).sendKeys("5");
    driver.findElement(By.name(prop.getProperty("Txt_Available_MembershipType"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_Available_MembershipType"))).sendKeys("basic");
    driver.findElement(By.cssSelector(prop.getProperty("Btn_Available_SetStatus"))).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText(prop.getProperty("Lnk_Available_BackToHome"))).click();
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(prop.getProperty("Btn_ManagerHome_Logout"))).click();
    Thread.sleep(3000);*/
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
