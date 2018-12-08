package my.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void clik(By locator) {
    driver.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    clik(By.name(locator));
    driver.findElement(By.name(locator)).clear();
    driver.findElement(By.name(locator)).sendKeys(text);
  }
}