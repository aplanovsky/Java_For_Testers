package my.addressbook;


import org.testng.annotations.Test;

public class testRemoveGroup extends TestBase {


  @Test
  private void testUntitledTestCase() throws Exception {
    goToGroupPage();
    selectGroup();
    deleteSelectedGroup();
    returnToGroupPage();
  }


}
