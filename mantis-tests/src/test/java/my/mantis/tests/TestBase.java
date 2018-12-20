package my.mantis.tests;


import my.mantis.appmanager.AplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;




public class TestBase {


  protected static final AplicationManager app
          = new AplicationManager(System.getProperty("browser", BrowserType.CHROME));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown(){
    app.stop();
  }


}
