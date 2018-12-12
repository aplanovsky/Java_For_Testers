package my.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void groupPage() {
    if(isElementPresent(By.tagName("h1"))
            && driver.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }
    clik(By.xpath("//html"));
    clik(By.linkText("groups"));
  }
  public void goToNamePage() {
    if(isElementPresent(By.id("maintable"))){
      return;
    }
    clik(By.xpath("//html"));
    clik(By.linkText("name"));
  }
}
