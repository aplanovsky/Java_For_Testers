package my.addressbook.tests;

import my.addressbook.model.GroupDate;
import my.addressbook.model.Groups;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if( app.group().all().size() == 0){
      app.group().create(new GroupDate().withName("test1"));
    }
  }

  @Test
  public void testGroupModification(){

    Groups before = app.group().all();
    GroupDate modifiedGroup = before.iterator().next();
    GroupDate group = new GroupDate().withId(modifiedGroup.getId())
            .withName( "test1").withHeader( "test2").withFooter("test3");
    app.group().modify(group);
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size())  ;

    assertThat(after, equalTo(before.wihouthAdded(modifiedGroup).withAdded(group)));
  }

}
