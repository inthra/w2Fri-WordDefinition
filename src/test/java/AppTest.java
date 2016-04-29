import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
// import org.junit.Rule;
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
    // assertThat(pageSource()).contains("discovery");
  }

  // @Test
  // public void wordShowPageDisplaysTheWord() {
  //   goTo("http://localhost:4567/words/newWord");
  //   fill("#inputWord").with("discovery");
  //   submit(".btn");
  //   click("a", withText("View All Words"));
  //   click("a", withText("discovery"));
  //   assertThat(pageSource()).contains("discovery");
  // }

}
