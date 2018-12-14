package my.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Type;

public class SessionHelper extends HelperBase {


  public SessionHelper(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);

    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
