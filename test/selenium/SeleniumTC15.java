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

public class SeleniumTC15 extends Functions{
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
    prop = new Properties(); 
     
    prop.load(new FileInputStream("./Configuration/Configuration.properties"));
    sAppURL = prop.getProperty("sAppURL");
    sSharedUIMapPath = prop.getProperty("SharedUIMap");
    
    prop.load(new FileInputStream(sSharedUIMapPath));
  }

  @Test
  public void testSeleniumTC15() throws Exception {
    driver.get(sAppURL);
    Thread.sleep(3000);
    driver.findElement(By.linkText(prop.getProperty("Lnk_Login_ClickHereToRegister"))).click();
    Registration(driver,"Admin","Admin","1001555555","Arlington","admin","adminadmin@gmail.com","admin",
    		"6666666666","DL12345678","hg456","Access","Admin");
    Login(driver,"admin","admin","Admin"); 
    /*driver.findElement(By.id(prop.getProperty("Txt_Register_FirstName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_FirstName"))).sendKeys("Admin");
    driver.findElement(By.id(prop.getProperty("Txt_Register_LastName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_LastName"))).sendKeys("Admin");
    driver.findElement(By.id(prop.getProperty("Txt_Register_UtaID"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_UtaID"))).sendKeys("1001555555");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Address"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Address"))).sendKeys("Arlington");
    driver.findElement(By.id(prop.getProperty("Txt_Register_UserName"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_UserName"))).sendKeys("admin");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Email"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Email"))).sendKeys("adminadmin@gmail.com");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Password"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Password"))).sendKeys("admin");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Phone"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Phone"))).sendKeys("6666666666");
    driver.findElement(By.id(prop.getProperty("Txt_Register_Dlnumber"))).clear();
    driver.findElement(By.id(prop.getProperty("Txt_Register_Dlnumber"))).sendKeys("DL12345678");
    driver.findElement(By.name(prop.getProperty("Txt_Register_Vnumber"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_Register_Vnumber"))).sendKeys("hg456");
    new Select(driver.findElement(By.name(prop.getProperty("Lst_Register_Permit")))).selectByVisibleText("Access");
    new Select(driver.findElement(By.id(prop.getProperty("Lst_Register_Role")))).selectByVisibleText("Admin");
    driver.findElement(By.cssSelector(prop.getProperty("Lnk_Register_Submit"))).click();
    driver.findElement(By.name(prop.getProperty("Txt_Login_UserName"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_Login_UserName"))).sendKeys("admin");
    driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_Login_Password"))).sendKeys("admin");
    new Select(driver.findElement(By.name(prop.getProperty("Lnk_Login_UserType")))).selectByVisibleText("Admin");
    driver.findElement(By.name(prop.getProperty("Btn_Login_Login"))).click();*/
    Thread.sleep(3000);
    driver.findElement(By.linkText("Search User")).click();
    SearchUser(driver,"hari");
    UpdateUser(driver,"User"); 
   /* driver.findElement(By.name(prop.getProperty("Txt_SearchUser_Username"))).clear();
    driver.findElement(By.name(prop.getProperty("Txt_SearchUser_Username"))).sendKeys("hari");
    driver.findElement(By.cssSelector(prop.getProperty("Btn_SearchUser_SearchButton"))).click();*/
   /* new Select(driver.findElement(By.id(prop.getProperty("Lst_UpdateUser_UserRole")))).selectByVisibleText("User");
    driver.findElement(By.cssSelector(prop.getProperty("Btn_UpdateUser_UpdateButton"))).click();*/
    driver.findElement(By.name(prop.getProperty("Btn_ViewUser_Find"))).click();
    Thread.sleep(4000);
    Thread.sleep(3000);
    driver.findElement(By.id("logout")).click();
    Thread.sleep(4000);

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
