package my.addressbook.tests;


import my.addressbook.model.GroupDate;
import my.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups(){
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupDate().withName("test1").withHeader("header 1").withFooter("footer 1")});
    list.add(new Object[] {new GroupDate().withName("test2").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[] {new GroupDate().withName("test3").withHeader("header 3").withFooter("footer 3")});
    return list.iterator();
  }


  @Test(dataProvider =  "validGroups")
  public void testGroupCreation(GroupDate group) {

    app.goTo().groupPage();
    Groups before = app.group().all();
    //GroupDate group = new GroupDate().withName("test2") ;
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId() ).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testBadGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupDate group = new GroupDate().withName("test'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));


  }

}
