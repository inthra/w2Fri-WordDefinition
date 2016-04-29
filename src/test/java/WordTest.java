import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  // @After
  // public void tearDown() {
  //   Definition.clearDefinition();
  // }

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word testWord = new Word("happy");
    assertEquals(true, testWord instanceof Word);
  }

}
