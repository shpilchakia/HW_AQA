package homework.two;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import homework.one.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationDemoQA extends TestBase {

    @Test
    void successfulRegistrationTest() {

        String userName = "Igor";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove");
        Selenide.executeJavaScript("$('footer').remove");

        $("#firstName").setValue(userName);
        $("#lastName").setValue("Shpilchak");
        $("#userEmail").setValue("igor@test.com");
        $("#genterWrapper").$(byText("Male")).click(); // best veriable
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
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
