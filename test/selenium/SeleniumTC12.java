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

public class SeleniumTC12 extends Functions {
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
	    prop= new Properties();
	    
	    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
	    sAppURL = prop.getProperty("sAppURL");
	    sSharedUIMapPath = prop.getProperty("SharedUIMap");
	    prop.load(new FileInputStream(sSharedUIMapPath));
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  @FileParameters("test/Excel/ViewSpecificReservation.csv")
  public void testSeleniumTC12(String reservation,String error,String idError) throws Exception {
    driver.get(sAppURL);
    Login(driver,"sam","Qwerty#123","Manager");
    ViewSpecificReservation(driver, reservation,error,idError);
    driver.findElement(By.linkText(prop.getProperty("Lnk_ViewSpecificReservation_BackToHome"))).click();
    driver.findElement(By.id(prop.getProperty("Btn_ManagerHome_Logout"))).click();
    
  }
  
  @Test
  @FileParameters("test/Excel/FinalViewSpecificReservation.csv")
  public void testFinalSeleniumTC12(String username, String password,String role,String reservation) throws Exception {
	    driver.get(sAppURL);
	    Login(driver,username,password,role);
	    FinalViewSpecificReservation(driver, reservation);
	    driver.findElement(By.linkText(prop.getProperty("Lnk_ViewSpecificReservation_BackToHome"))).click();
	    driver.findElement(By.id(prop.getProperty("Btn_ManagerHome_Logout"))).click();
	    
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
