package my.addressbook;



public class GroupCreationTests extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    goToGroupPage();
    initGroupCreation();
    fieldGroupForm(new GroupDate("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
