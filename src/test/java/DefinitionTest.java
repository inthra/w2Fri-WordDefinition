import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("delighted");  // Definition of "happy"
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithMeaning_String() {
    Definition myDefinition = new Definition("delighted");  // Definition of "happy"
    assertEquals("delighted", myDefinition.getMeaning());
  }

  @Test
  public void retrieveAll_returnAllInstancesOfDefinition_true() {
    Definition firstMeaning = new Definition("delighted");
    Definition secondMeaning = new Definition("pleased");
    assertTrue(Definition.retrieveAll().contains(firstMeaning));
    assertTrue(Definition.retrieveAll().contains(secondMeaning));
  }

  @Test
  public void clearDefiniton_emptiesAllDefinitionsFromArrayList_0() {
    Definition myDefinition = new Definition("delighted");
    Definition.clearDefinition();
    assertEquals(Definition.retrieveAll().size(), 0);
  }

}
