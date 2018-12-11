package my.addressbook.tests;


import my.addressbook.appmanager.AplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import sun.plugin2.util.BrowserType;

import javax.xml.bind.annotation.XmlType;


public class TestBase {


protected final AplicationManager app = new AplicationManager(BrowserType.MOZILLA);

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

}
