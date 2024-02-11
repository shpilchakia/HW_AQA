package homework.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import homework.five.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

//    String loginFirstName = "#firstName"; // Bad practice

    SelenideElement
            inputFirstName = $("#firstName"),
            inputLastName = $("#lastName"),
            inputUserEmail = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            inputUserNumber = $("#userNumber"),
            inputBirthDay = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove");
        Selenide.executeJavaScript("$('footer').remove");

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        inputFirstName.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        inputLastName.setValue(value);

        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        inputUserEmail.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        inputUserNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        inputBirthDay.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
}
