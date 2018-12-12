package my.addressbook.tests;


import my.addressbook.appmanager.AplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import sun.plugin2.util.BrowserType;




public class TestBase {


protected static final AplicationManager app
        = new AplicationManager(BrowserType.MOZILLA);


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() throws Exception {
    app.stop();
  }

}
