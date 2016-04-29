import java.util.ArrayList;

public class Definition {
  private String mMeaning;
  private static ArrayList<Definition> instances = new ArrayList<Definition>();


  public Definition(String meaning) {
    mMeaning = meaning;
    instances.add(this);

  }

  public String getMeaning() {
    return mMeaning;
  }

  public static ArrayList<Definition> retrieveAll() {
    return instances;
  }

  public static void clearDefinition() {
    instances.clear();
  }
}
