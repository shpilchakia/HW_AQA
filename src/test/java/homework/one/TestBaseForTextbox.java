package homework.one;

import com.codeborne.selenide.Configuration;
import homework.five.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseForTextbox {
    public RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        System.setProperty("webdriver.chrome.driver", "C:/WebDrivers/chromedriver120.0.6099.109.exe");
        Configuration.holdBrowserOpen = true;
    }
}
