package my.addressbook.tests;

import my.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation(){
    app.getNavigationHelper().goToNamePage();
    app.getContactHelper().initContactForm(new ContactData("test_name", "test_surname", null), false);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
