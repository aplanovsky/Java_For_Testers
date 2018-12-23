package my.mantis.tests;


import my.mantis.model.Issue;
import my.mantis.model.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;

import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase{

  @Test
  public void testGetProjects() throws ServiceException, MalformedURLException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects){
      System.out.println(project.getName());
    }
  }
  @Test
  public void testCreateIssue()throws ServiceException, MalformedURLException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue()
            .withSummary("Test issue")
            .withDescription("Test issue description")
            .withProject(projects.iterator().next());
     Issue created = app.soap().addissue(issue);
    Assert.assertEquals(issue.getSummary(), created.getSummary());
  }
}
