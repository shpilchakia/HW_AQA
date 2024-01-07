package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithCommentsDemoQA {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver120.0.6099.109.exe");
//        Configuration.browserVersion = "114.xxx.xx.x.x";
    }

    @Test
    void successfulRegistrationTest() {

        String userName = "Igor";


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove"); // С помощью селенида убрать рекламу на странице с помощью языка JQuery
        Selenide.executeJavaScript("$('footer').remove");

        $("#firstName").setValue(userName);
        $("#lastName").setValue("Shpilchak");
        $("#userEmail").setValue("igor@test.com");
//        $("#gender-radio-2").parent().click(); // good
//        $(byText("Other")).click(); // not very good
//        $("label[for=gender-radio-1]").click(); / good
        $("#genterWrapper").$(byText("Male")).click(); // best veriable
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-select").selectOptionByValue(6);
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $x("//*[@class='react-datepicker__day--030'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click(); // XPath
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/Mock.jpg"); // Работает только для элементов type="file"
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/Mock.jpg"));
        $("#currentAddress").setValue("My home address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Shpilchak"), text("igor@test.com"),
                text("1234567890"), text("Delhi"));
    }
}
