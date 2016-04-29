import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("a wild or natural musical tone, as that of a forest bird.");
    assertEquals(true, myDefinition instanceof Definition);
  }
}
