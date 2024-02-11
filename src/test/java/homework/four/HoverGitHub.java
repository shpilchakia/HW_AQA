package homework.four;

import com.codeborne.selenide.Configuration;
import homework.one.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HoverGitHub extends TestBase {

    @Test
    void chooseSolutionsElement() {
        open("https://github.com/");
        $("[aria-label='Global']").$(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $(".enterprise-hero-heading").shouldHave(text("The AI-powered developer platform."));
    }

}
