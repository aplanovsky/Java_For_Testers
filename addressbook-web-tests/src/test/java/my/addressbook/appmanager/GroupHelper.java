package my.addressbook.appmanager;

import my.addressbook.model.GroupDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    type(By.name("group_name"), groupDate.getName());
    type(By.name("group_header"), groupDate.getHeader());
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(groupDate.getFooter());
  }
  public void selectGroup(int index) {
    driver.findElements(By.name("selected[]*")).get(index).click();
    clik(By.name("selected[]"));
  }

  public void initGroupCreation() {
    clik(By.name("selected[]*"));
  }

  public void deleteSelectedGroup() {
    clik(By.name("delete"));
  }



  public void initGroupModification() {
    clik(By.name("edit"));
  }

  public void submitGroupModification() {
    clik(By.name("update"));
  }

  public void create(GroupDate group) {
    initGroupCreation();
    fieldGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(int index, GroupDate group) {
    selectGroup(index);
    initGroupModification();
    fieldGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

   public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroup();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]*"));
  }

  public int getGroupCount() {
   return driver.findElements(By.name("selected[]*")).size();
  }

  public List<GroupDate> list() {
    List<GroupDate> groups = new ArrayList<GroupDate>();
    List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    for(WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupDate().withId(id).withName(name));
    }
    return groups;
  }
}

