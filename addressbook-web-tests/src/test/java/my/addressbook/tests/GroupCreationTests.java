package my.addressbook.tests;


import my.addressbook.model.GroupDate;
import my.addressbook.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fieldGroupForm(new GroupDate("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
