package my.addressbook.tests;


import my.addressbook.model.GroupDate;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


  @Test
  private void testGroupDeletion(){
    app.getNavigationHelper().goToGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupDate("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
  }


}
