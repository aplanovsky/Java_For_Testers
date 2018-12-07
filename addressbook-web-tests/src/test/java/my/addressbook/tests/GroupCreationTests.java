package my.addressbook.tests;


import my.addressbook.model.GroupDate;
import my.addressbook.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    app.goToGroupPage();
    app.initGroupCreation();
    app.fieldGroupForm(new GroupDate("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
