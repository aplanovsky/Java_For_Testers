package my.addressbook.tests;

import my.addressbook.model.GroupDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation(){
    app.goTo().goToNamePage();
    List<GroupDate> befor = app.group().list();
    GroupDate group = new GroupDate(0, "test1", "test2", "test3");
    app.group().create(group);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(after.size(), befor.size() + 1);

    befor.add(group);
  }
}
