package my.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import sun.plugin2.util.BrowserType;
import java.lang.String;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class AplicationManager extends SessionHelper {
  private WebDriver driver;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper = new GroupHelper(driver);
  private ContactHelper contactHelper = new ContactHelper(driver);
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private int browser;

//  private  AplicationManager(driver) {
//    super();
//  }

  public  AplicationManager(int browser) {
    super(null);
    this.browser =  browser;
  }

  public void init() {

    if (browser == (BrowserType.MOZILLA)){
      driver =  new FirefoxDriver();
    }else if(browser ==( BrowserType.DEFAULT)) {
      driver = new ChromeDriver();
    } else if (browser ==( BrowserType.INTERNET_EXPLORER)){
      driver = new InternetExplorerDriver();
    }

    driver =  new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/addressbook/group.php");
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("admin", "secret");
  }



  public void stop() {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  public boolean isElementPresent(By by) {
    try {
    driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
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

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
