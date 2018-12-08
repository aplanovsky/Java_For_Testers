package my.addressbook.appmanager;

import my.addressbook.model.GroupDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver driver) {
    super(driver);

  }

  public void returnToGroupPage() {
    clik(By.xpath("//html"));
    clik(By.linkText("group page"));
    clik(By.xpath("//html"));
  }

  public void submitGroupCreation() {
    clik(By.name("submit"));
  }

  public void fieldGroupForm(GroupDate groupDate) {
    type("group_name", groupDate.getName());
    type("group_header", groupDate.getHeader());
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(groupDate.getFooter());
  }

  public void initGroupCreation() {
    clik(By.name("new"));
  }

  public void deleteSelectedGroup() {
    clik(By.name("delete"));
  }

  public void selectGroup() {
    clik(By.name("selected[]"));
  }

  public void initGroupModification() {
    clik(By.name("edit"));
  }

  public void submitGroupModification() {
    clik(By.name("update"));
  }
}
