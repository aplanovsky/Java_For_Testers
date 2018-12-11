package my.addressbook.tests;

import my.addressbook.model.ContactData;
import my.addressbook.model.GroupDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation(){
    app.getNavigationHelper().goToNamePage();
    List<GroupDate> befor = app.getGroupHelper().getGroupList();
    GroupDate group = new GroupDate(0, "test1", "test2", "test3");
    app.getGroupHelper().createGroup(group);
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), befor.size() + 1);

    befor.add(group);
  }
}
