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

public class SeleniumTC18 extends Functions {
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
  @FileParameters("test/Excel/Revoke.csv")
  public void testSeleniumTC18(String username,String reason,String error,String usernameError,String reasonError) throws Exception {
    driver.get(sAppURL);
    Login(driver,"admin","admin","Admin");
    Revoke(driver,username,reason,error,usernameError,reasonError);
    driver.findElement(By.linkText(prop.getProperty("Lnk_Revoke_BackToHome"))).click();
    driver.findElement(By.id(prop.getProperty("Btn_AdminHome_Logout"))).click();
  }
  
  @Test
  @FileParameters("test/Excel/FinalRevoke.csv")
  public void testFinalRevoke(String username,String reason) throws Exception {
    driver.get(sAppURL);
    Login(driver,"admin","admin","Admin");
    FinalRevoke(driver,username,reason);
    driver.findElement(By.id(prop.getProperty("Btn_AdminHome_Logout"))).click();
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
