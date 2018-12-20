package my.mantis.tests;

import my.mantis.appmanager.HttpSession;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase {
  @Test
 public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login(
            "administrator",
            "root"));
   assertTrue(session.isLoggedInAs("administrator"));
  }
}
