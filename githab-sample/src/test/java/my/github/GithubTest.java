package my.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTest {
  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("29a035d73777aedf2488b5d632ca993309254680");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("aplanovsky", "Java_For_Testers")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){
      System.out.println(new RepoCommit.Smart(commit).message());

    }
  }

}
