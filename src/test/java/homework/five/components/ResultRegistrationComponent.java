package homework.five.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultRegistrationComponent {

    static SelenideElement
            tableResponsive = $(".table-responsive"),
            closeTableResponsiveBtn = $("#closeLargeModal");

    public static void verifyResult(String key, String value) {
        tableResponsive.$(byText(key)).sibling(0).shouldHave(text(value));
    }

    public static void clickCloseBtn() {
        closeTableResponsiveBtn.click();
    }
}
