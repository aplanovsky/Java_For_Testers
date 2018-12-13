package my.addressbook.tests;

import my.addressbook.model.GroupDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation(){
    app.goTo().goToNamePage();
    Set<GroupDate> befor = app.group().all();
    GroupDate group = new GroupDate().withId(0)
            .withName( "test1").withHeader( "test2").withFooter( "test3");
    app.group().create(group);
    Set<GroupDate> after = app.group().all();
    Assert.assertEquals(after.size(), befor.size() + 1);

    befor.add(group);
  }
}
