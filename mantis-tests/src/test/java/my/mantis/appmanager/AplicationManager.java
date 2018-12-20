package my.mantis.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AplicationManager {
  private final Properties properties;
  WebDriver driver;


  private String browser;

  public AplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


    if (browser.equals(BrowserType.FIREFOX)) {
      driver = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.IEXPLORE)) {
      driver = new InternetExplorerDriver();

  }
    //System.setProperty("webdriver.gecko.driver.driver", "./geckodriver.exe");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(properties.getProperty("web.baseUrl"));

  }
public void stop(){
    driver.quit();
}

}