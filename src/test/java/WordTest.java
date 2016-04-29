import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @After
  public void tearDown() {
    Word.clearWord();
  }

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word("happy");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void getWord_wordInstantiatesWithWord_String() {
    Word testWord = new Word("happy");
    assertEquals("happy", testWord.getWord());
  }

  @Test
  public void retrieveAll_returnAllInstancesOfWord_true() {
    Word firstWord = new Word("happy");
    Word secondWord = new Word("tea");
    assertTrue(Word.retrieveAll().contains(firstWord));
    assertTrue(Word.retrieveAll().contains(secondWord));
  }

  @Test
  public void clearWord_emptiesAllWordsFromList_0() {
    Word testWord = new Word("happy");
    Word.clearWord();
    assertEquals(Word.retrieveAll().size(), 0);
  }

  @Test
  public void getId_wordsInstantiateWithAnID_1() {
    Word testWord = new Word("happy");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void find_returnsWordWithSameId_secondWord() {
    Word firstWord = new Word("happy");
    Word secondWord = new Word("tea");
    assertEquals(Word.find(secondWord.getId()), secondWord);
  }

  @Test
  public void find_returnsNullWhenNoWordFound_null() {
    assertTrue(Word.find(99999) == null);
  }
}
