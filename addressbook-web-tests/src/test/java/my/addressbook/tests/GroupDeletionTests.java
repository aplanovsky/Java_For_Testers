package my.addressbook.tests;


import my.addressbook.model.GroupDate;
import my.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupDeletionTests extends TestBase {

  public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.group().all().size() == 0) {
        app.group().create(new GroupDate().withName("test1"));
      }
    }

    @Test
    private void testGroupDeletion() {
      Groups before = app.group().all();
      GroupDate deletedGroup = before.iterator().next();
      app.group().delete(deletedGroup);
      assertThat(app.group().count(), equalTo(before.size() - 1));
      Groups after = app.group().all();
      assertEquals(after.size(), before.size() - 1);
      assertThat(after, equalTo(before.wihouthAdded(deletedGroup)));
    }

  }
}