package selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.Properties;
import java.io.FileInputStream;
import functions.*;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class SeleniumTC10 extends Functions{
  //private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String sAppURL, sSharedUIMapPath; 
  //public Properties prop;

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette", "C:\\GeckoSelenium\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8079/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    prop= new Properties();
    
    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
    sAppURL = prop.getProperty("sAppURL");
    sSharedUIMapPath = prop.getProperty("SharedUIMap");
    
    prop.load(new FileInputStream(sSharedUIMapPath));
  }
   
  
  @FileParameters("test/Excel/AddParkingArea.csv")
  @Test
  public void testSeleniumTC10(int testcaseNo,String username,String password,String role, String parkingarea, String capacity,String floor,String type,String cart,String camera,String history,String errormsg,String parkingareaError,String capacityError,String floorError,String typeError,String cartError,String cameraError,String historyError) throws Exception {
	driver.get(sAppURL);
	Login(driver,username,password,role);
    
    AddParkingArea(driver,parkingarea,capacity,floor,type,cart,camera,history,errormsg,parkingareaError,capacityError,floorError,typeError,cartError,cameraError,historyError);
    driver.findElement(By.id(prop.getProperty("Btn_ManagerHome_Logout"))).click();
  }
   
  @Test
  @FileParameters("test/Excel/FinalAddParkingArea.csv")
  public void testFinalAddParkingArea(int testcaseNo,String username,String password,String role, String parkingarea, String capacity,String floor,String type,String cart,String camera,String history) throws Exception{
	  driver.get(sAppURL);
	  Login(driver,username,password,role);
	  FinalAddParkingArea(driver,parkingarea,capacity,floor,type,cart,camera,history);
	  
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
