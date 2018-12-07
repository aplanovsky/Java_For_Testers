package my.addressbook.tests;


import my.addressbook.appmanager.AplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;




public class TestBase {


  protected final AplicationManager app = new AplicationManager();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
