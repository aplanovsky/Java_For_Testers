package my.addressbook.tests;


import my.addressbook.model.GroupDate;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupDate("test1", null, null));

  }

}
