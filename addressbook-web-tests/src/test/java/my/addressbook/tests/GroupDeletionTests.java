package my.addressbook.tests;


import my.addressbook.model.GroupDate;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
      app.goTo().groupPage();
      if(app.group().list().size() == 0){
        app.group().create(new GroupDate(0, "test", null, null));
      }
    }
  @Test
  private void testGroupDeletion(){
    app.goTo().groupPage();
    if(! app.group().isThereAGroup()){
      app.group().create(new GroupDate(0,"test1", null, null));
    }

    List<GroupDate> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupDate> after = app.group().list();
    Assert.assertEquals(after.size(),before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);

  }

  }
