package homework.five;

import homework.one.TestBase;
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
                .closeBanners()
                .setFirstName("Igor")
                .setLastName("Shpilchak")
                .setUserEmail("igor@test.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setBirthDay("30", "July", "2008")
                .setSubject("Math")
                .setHobbies("Sports")
                .addPicture("img/Mock.jpg")
                .setCurrentAddress("My home address 1")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmitBtn();

        registrationPage
                .checkModalDialogVisible()
                .checkResult("Student Name","Igor Shpilchak")
                .checkResult("Student Email", "igor@test.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Mock.jpg")
                .checkResult("Address", "My home address 1")
                .checkResult("State and City", "NCR Delhi")
                .closeTableResponsive();
    }
}