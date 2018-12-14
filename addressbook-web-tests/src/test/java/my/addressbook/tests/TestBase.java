package my.addressbook.tests;


import my.addressbook.appmanager.AplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//import sun.plugin2.util.BrowserType;
import org.openqa.selenium.remote.BrowserType;



public class TestBase {


protected static final AplicationManager app
        = new AplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() throws Exception {
    app.stop();
  }

}
