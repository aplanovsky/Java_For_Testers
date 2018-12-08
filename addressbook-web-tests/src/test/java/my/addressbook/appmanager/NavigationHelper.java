package my.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver driver;

  public NavigationHelper(WebDriver driver) {

  }

  public void goToGroupPage() {
   driver.findElement(By.xpath("//html")).click();
   driver.findElement(By.linkText("groups")).click();
  }
}
