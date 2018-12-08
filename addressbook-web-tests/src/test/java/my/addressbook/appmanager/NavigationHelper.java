package my.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToGroupPage() {
    clik(By.xpath("//html"));
    clik(By.linkText("groups"));
  }
}
