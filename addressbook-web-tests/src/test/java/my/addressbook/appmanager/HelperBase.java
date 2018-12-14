package my.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(By.name(String.valueOf(locator)));
    if(text != null){
      String  existingText = driver.findElement(By.name(String.valueOf(locator))).getAttribute("value");
      if (! text.equals(existingText)){
        driver.findElement(By.name(String.valueOf(locator))).clear();
        driver.findElement(By.name(String.valueOf(locator))).sendKeys(text);
      }
    }
  }
  public boolean isAlertPreasent(){
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e){
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    }catch (NoSuchElementException ex){
      return false;
    }

  }
}

