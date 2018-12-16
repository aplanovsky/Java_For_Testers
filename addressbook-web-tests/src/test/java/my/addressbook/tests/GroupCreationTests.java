package my.addressbook.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
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
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

  @DataProvider
//  public Iterator<Object[]> validGroupsFromXml() throws IOException {
//    List<Object[]> list = new ArrayList<Object[]>();
//    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
//    String xml = "";
//    String line = reader.readLine();
//    while (line != null){
//      String[] spliit =  line.split(";");
//        xml += line;
////      list.add(new  Object[]{
////              new GroupData()
////                      .withName(spliit[0])
////                      .withHeader(spliit[1])
////                      .withFooter(spliit[2])
////              } );
//      line = reader.readLine();
//    }
//    XStream xstream = new XStream();
//    xstream.processAnnotations(GroupData.class);
//    List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
//    return groups.stream()
//            .map((g) -> new Object[] {g})
//            .collect(Collectors.toList())
//            .iterator();
//    //    return list.iterator();
//  }

  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null){
      String[] spliit =  line.split(";");
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {}.getType());
    return groups.stream()
            .map((g) -> new Object[] {g})
            .collect(Collectors.toList())
            .iterator();
  }


  @Test(dataProvider = "validGroupsFromJson")
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
