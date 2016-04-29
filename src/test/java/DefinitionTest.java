import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

  @After
  public void tearDown() {
    Definition.clearDefinition();
  }

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myMeaning = new Definition("delighted");  // Definition of "happy"
    assertEquals(true, myMeaning instanceof Definition);
  }

  @Test
  public void Definition_instantiatesWithMeaning_String() {
    Definition myMeaning = new Definition("delighted");  // Definition of "happy"
    assertEquals("delighted", myMeaning.getMeaning());
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
    Definition myMeaning = new Definition("delighted");
    Definition.clearDefinition();
    assertEquals(Definition.retrieveAll().size(), 0);
  }

  @Test
  public void getId_meaningsInstantiateWithAnID_1() {
    Definition myMeaning = new Definition("delighted");
    assertEquals(1, myMeaning.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondMeaning() {
    Definition firstMeaning = new Definition("delighted");
    Definition secondMeaning = new Definition("pleased");
    assertEquals(Definition.find(secondMeaning.getId()), secondMeaning);
  }

  @Test
  public void find_returnsNullWhenNoMeaningFound_null() {
    assertTrue(Definition.find(99) == null);
  }
}
