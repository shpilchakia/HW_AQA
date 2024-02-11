package homework.four;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import homework.one.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop extends TestBase {

    @Test
    void selenideWikiPage() {
        // Open 'The Internet'
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Drag element A to element B space
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        // Check that elements have truly changed their spaces
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

        // Drag element B to element A space (This method doesn't work)
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        // Check that no changes has happened
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }
}