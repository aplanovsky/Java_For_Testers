package my.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] languages0 ={"Java", "C#", "Python", "PHP"};

    List<String> languages1 = Arrays.asList("Java", "C#", "Python", "PHP");

    List<String> languages2 = new ArrayList<String>();
    languages2.add("Java");
    languages2.add("Python");
    languages2.add("C#");

    for (String l : languages0) {
      System.out.println("I wont educate " + l);
    }

    for (int i = 0; i < languages1.size() ; i++) {
      System.out.println("I wont educate " + languages1.get(i));
    }
  }
}
