package my.addressbook.tests;


import org.testng.annotations.Test;

public class testRemoveGroup extends TestBase {


  @Test
  private void testUntitledTestCase() throws Exception {
    app.goToGroupPage();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();
  }


}
