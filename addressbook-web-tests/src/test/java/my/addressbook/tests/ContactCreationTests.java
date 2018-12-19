package my.addressbook.tests;

import my.addressbook.model.Groups;
import org.testng.annotations.Test;
import my.addressbook.model.ContactData;

import java.io.File;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {

    Groups groups = app.db().groups();
    File photo = new File("src/test/resources/finding.gif");
    ContactData newContact = (new ContactData()
            .withFirstname("test_name")
            .withLastname("test_surname")
            .withtPhoto(photo)
            .inGroup(groups.iterator().next()));
    app.goTo().goToHomePage();
    app.contact().initContactCreation();
    app.contact().fillContactForm(newContact, true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();
  }
//  @Test
//  public void  testCurrentDir(){
//    File currentDir = new File(".");
//    System.out.println( currentDir.getAbsolutePath());
//    File photo = new File("src/test/resources/finding.gif");
//    System.out.println(photo.getAbsolutePath());
//    System.out.println(photo.exists());
//  }
}
