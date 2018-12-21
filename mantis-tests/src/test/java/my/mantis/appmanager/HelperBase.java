package my.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {

  protected  ApplicationManager app;
  protected WebDriver driver;

  public HelperBase(ApplicationManager app){
    this.app = app;
    this.driver = app.getDriver();
  }

  protected void click(By locator){
    driver.findElement(locator).click();
  }
  protected  void type(By locator, String text){
    click(locator);
    if (text != null){
      String existingText = driver.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void attach(By locator, File file){
    if (file != null){
      driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }
}
