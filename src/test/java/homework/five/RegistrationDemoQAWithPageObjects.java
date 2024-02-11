package homework.five;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homework.one.TestBase;
import homework.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationDemoQAWithPageObjects extends TestBase {

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Igor")
                .setLastName("Shpilchak")
                .setUserEmail("igor@test.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setBirthDay("30", "July", "2008");

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/Mock.jpg");
        $("#currentAddress").setValue("My home address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Shpilchak"), text("igor@test.com"),
                text("1234567890"), text("Delhi"));
    }
}
