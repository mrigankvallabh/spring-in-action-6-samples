package tacos;

import java.time.Duration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tacos.util.MyHtmlUnitDriver;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HomePageBrowserTest {

  @LocalServerPort
  private int port;
  private static MyHtmlUnitDriver browser;  
  
  @BeforeAll
  public static void setup() {
    browser = new MyHtmlUnitDriver();
    
    browser.manage().timeouts()
          .implicitlyWait(Duration.ofSeconds(10));
  }
  
  @AfterAll
  public static void teardown() {
    browser.quit();
  }
  
  @Test
  public void testHomePage() {
    String homePage = "http://localhost:" + port;
    browser.get(homePage);
    
    String titleText = browser.getTitle();
    Assertions.assertThat(titleText).isEqualTo("Taco Cloud");
    
    String h1Text = browser.findElementByTagName("h1").getText();
    Assertions.assertThat(h1Text).isEqualTo("Welcome to...");

    
    String imgSrc = browser.findElementByTagName("img")
                                              .getAttribute("src");
    Assertions.assertThat(imgSrc).isEqualTo(homePage + "/images/TacoCloud.png");
  }
  
  
}
