package my.addressbook.rf;

import my.addressbook.appmanager.AplicationManager;
import my.addressbook.model.GroupData;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;

public class AddressbookKeyword {

  public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

  private AplicationManager app;

  public void initAplicationManager() throws IOException {
    app = new AplicationManager
            (System.getProperty
                    ("browser", BrowserType.CHROME));
    app.init();
  }

  public void stopAplicationManager(){
    app.stop();
    app = null;
  }
  public int getGroupCount(){
    app.goTo().groupPage();
    return app.group().count();
  }
  public void createGroup(String name, String header, String footer){
    app.goTo().groupPage();
    app.group().create(new GroupData()
            .withName(name)
            .withHeader(header)
            .withFooter(footer));
  }
}
