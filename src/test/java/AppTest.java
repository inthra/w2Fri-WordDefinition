import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
    assertThat(pageSource()).contains("View All Words");
    assertThat(pageSource()).contains("Add a new word");
  }

  @Test
  public void wordIsAddedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new word"));
    fill("#inputWord").with("discovery");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/newWord");
    fill("#inputWord").with("discovery");
    submit(".btn");
    click("a", withText("View All Words"));
    assertThat(pageSource()).contains("discovery");
  }
// something wrong with the gradle test from this point. It can be run Gradle Run, but cannot pass the test.
  @Test
  public void wordShowPageDisplaysTheWord() {
    goTo("http://localhost:4567/words/newWord");
    fill("#inputWord").with("why");
    submit(".btn");
    click("a", withText("View All Words"));
    click("a", withText("why"));
    assertThat(pageSource()).contains("why");
  }

  @Test
  public void wordDefinitionFormIsDisplayed() {
    goTo("http://localhost:4567/words/newWord");
    fill("#inputWord").with("cat");
    submit(".btn");
    click("a", withText("View All Words"));
    click("a", withText("cat"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a definition to cat");
  }

  @Test
  public void definitionsIsAddedAndDisplayed() {
    goTo("http://localhost:4567/words/newWord");
    fill("#inputWord").with("bird");
    submit(".btn");
    click("a", withText("View All Words"));
    click("a", withText("bird"));
    click("a", withText("Add a new definition"));
    fill("#inputMeaning").with("a fowl.");
    submit(".btn");
    click("a", withText("View All Words"));
    click("a", withText("bird"));
    assertThat(pageSource()).contains("a fowl.");
  }

}
