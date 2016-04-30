import java.util.ArrayList;

public class Word {
  private String mWord;
  private static ArrayList<Word> allWords = new ArrayList<Word>();
  private int mId;
  private ArrayList<Definition> mDefinitions;

  public Word(String word) {
    mWord = word;
    allWords.add(this);
    mId = allWords.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getWord() {
    return mWord;
  }

  public static ArrayList<Word> retrieveAllWord() {
    return allWords;
  }

  public static void clearWord() {
    allWords.clear();
  }

  public int getId() {
    return mId;
  }

  public static Word find(int id) {
    try {
      return allWords.get(id - 1);
    } catch (IndexOutOfBoundsException exception) {
      return null;
    }
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public void addDefinition(Definition meaning) {
    mDefinitions.add(meaning);
  }
}
