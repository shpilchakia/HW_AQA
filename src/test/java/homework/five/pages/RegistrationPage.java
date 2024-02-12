package homework.five.pages;

import com.codeborne.selenide.SelenideElement;
import homework.five.components.CalendarComponent;
import homework.five.components.ResultRegistrationComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    String formTitle = "Student Registration Form";
    String successRegistrationFormText = "Thanks for submitting the form";

    CalendarComponent calendarComponent = new CalendarComponent();

    SelenideElement
            practiceFormWrapper = $(".practice-form-wrapper"),
            inputFirstName = $("#firstName"),
            inputLastName = $("#lastName"),
            inputUserEmail = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            inputUserNumber = $("#userNumber"),
            inputBirthDay = $("#dateOfBirthInput"),
            inputSubjects = $("#subjectsInput"),
            inputHobbies = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            inputAddressInput = $("#currentAddress"),
            selectState = $("#state"),
            selectStateCity = $("#stateCity-wrapper"),
            selectCity = $("#city"),
            submitBtn = $("#submit"),
            modalDialog = $(".modal-dialog"),
            modalDialogTitle = $("#example-modal-sizes-title-lg");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        practiceFormWrapper.shouldHave(text(formTitle));

        return this;
    }

    public RegistrationPage closeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

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

    public RegistrationPage setSubject(String value) {
        inputSubjects.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        inputHobbies.$(byText(value)).click();
        ;

        return this;
    }

    public RegistrationPage addPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        ;

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        inputAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        selectState.click();
        selectStateCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        selectCity.click();
        selectCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmitBtn() {
        submitBtn.click();

        return this;
    }

    public RegistrationPage checkModalDialogVisible() {
        modalDialog.should(appear);
        modalDialogTitle.shouldHave(text(successRegistrationFormText));

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        ResultRegistrationComponent.verifyResult(key, value);

        return this;
    }

    public RegistrationPage closeTableResponsive() {
        ResultRegistrationComponent.clickCloseBtn();

        return this;
    }
}
