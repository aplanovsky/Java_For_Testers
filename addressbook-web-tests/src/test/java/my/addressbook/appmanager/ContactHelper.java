package my.addressbook.appmanager;

import my.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver driver) {super (driver);}

  public void initContactForm() {clik(By.linkText("add new"));}

  public void fillContactForm(ContactData contactData){
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if(isElementPresent(By.name("new group"))) {
      new Select(driver.findElement(By.name("new group"))).selectByVisibleText(contactData.getGroup());
    }
  }

  public void submitContactCreation(){clik(By.name("submit"));}
  public void returnToHomePage() {clik(By.linkText("home page"));}
  public void initContactModification() {clik(By.cssSelector("img[alt='Edit']"));}
  public void submitContactModification() {clik(By.name("update"));}
}

