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
public class SeleniumTC14 extends Functions {
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
 
  @FileParameters("test/Excel/DeleteReservation.csv")
  @Test
  public void testSeleniumTC14(int testCaseNo, String username, String password,String role, String reservationID) throws Exception {
    driver.get(sAppURL);
    /*driver.findElement(By.id(prop.getProperty("Txt_Login_UserName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Login_UserName"))).sendKeys("sam");
    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys("Qwerty#123");
    new Select(driver.findElement(By.id(prop.getProperty("Lnk_Login_UserType")))).selectByVisibleText("Manager");
    driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();*/
    Login(driver,username,password,role);
    driver.findElement(By.linkText(prop.getProperty("Lnk_ManagerHome_Delete"))).click();
   /* driver.findElement(By.id(prop.getProperty("Txt_DeleteSpecificReservation_ID"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_DeleteSpecificReservation_ID"))).sendKeys("5");
    driver.findElement(By.id(prop.getProperty("Btn_DeleteSpecificReservation_Submit"))).click();*/
    DeleteSpecificReservation(driver, reservationID);
    driver.findElement(By.id(prop.getProperty("Btn_ViewReservations_Find"))).click();
    driver.findElement(By.linkText(prop.getProperty("Lnk_ViewReservations_Backtohome"))).click();
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
