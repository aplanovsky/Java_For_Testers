package my.addressbook.tests;


import my.addressbook.model.GroupDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().goToGroupPage();
    List<GroupDate> before = app.getGroupHelper().getGroupList();
    GroupDate group = new GroupDate(0 , "test2", "test2", "test3");
    app.getGroupHelper().createGroup(group);
    List<GroupDate> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


    int max = 0;
    for(GroupDate g : after ){
      if(g.getId() > max){
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
