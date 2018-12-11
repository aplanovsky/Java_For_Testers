package my.addressbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
  static WebDriver driver ;

  public static void main(String[] args) {
    //beta 2 version
    //System.setProperty("webdriver.firefox.marionette", "./geckodriver.exe");

    //beta 1 version
   // System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");

    //3.x final version onwards
    System.setProperty("webdriver.gecko.driver.driver", "./geckodriver.exe");
    driver = (WebDriver) new FirefoxDriver();
    driver.get("http://www.facebook.com");
    driver.quit();
  }
}