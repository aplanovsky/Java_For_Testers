package my.addressbook.tests;


import my.addressbook.model.GroupData;
import my.addressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
     String line = reader.readLine();
    while (line != null){
      String[] spliit =  line.split(";");
      list.add(new  Object[]{
              new GroupData()
                      .withName(spliit[0])
                      .withHeader(spliit[1])
                      .withFooter(spliit[2])
              } );
      line = reader.readLine();
    }
    return list.iterator();
  }


  @Test(dataProvider =  "validGroups")
  public void testGroupCreation(GroupData group) {

    app.goTo().groupPage();
    Groups before = app.group().all();
    //GroupData group = new GroupData().withName("test2") ;
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId() ).max().getAsInt()))));
  }

//  @Test(enabled = false)
//  public void testBadGroupCreation() {
//
//    app.goTo().groupPage();
//    Groups before = app.group().all();
//    GroupData group = new GroupData().withName("test'");
//    app.group().create(group);
//    assertThat(app.group().count(), equalTo(before.size()));
//    Groups after = app.group().all();
//    assertThat(after, equalTo(before));
//  }

}
