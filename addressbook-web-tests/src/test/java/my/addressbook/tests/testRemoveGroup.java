package my.addressbook.tests;


import org.testng.annotations.Test;

public class testRemoveGroup extends TestBase {


  @Test
  private void testUntitledTestCase() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
  }


}
