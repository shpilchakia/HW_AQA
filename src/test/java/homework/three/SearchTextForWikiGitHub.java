package homework.three;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTextForWikiGitHub {

    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver120.0.6099.109.exe");
    }

    @Test
    void searchTextGitHubWiki() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").shouldBe(visible).click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $("#wiki-body").$(byText("Soft assertions")).click();
        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:")).sibling(0)
                .shouldHave(exactText("@ExtendWith({SoftAssertsExtension.class}) " +
                        "class Tests { " +
                        "  @Test " +
                        "  void test() { " +
                        "    Configuration.assertionMode = SOFT; " +
                        "    open(\"page.html\"); " +
                        " " +
                        "    $(\"#first\").should(visible).click();\n" + //оставил для примера \n
                        "    $(\"#second\").should(visible).click();\n" + //оставил для примера \n
                        "  }\n" + //оставил для примера \n
                        "}"));
        // sleep(5000); оставил для примера
    }
}