package homework.five;

import homework.five.pages.TextBoxPage;
import homework.one.TestBaseForTextbox;
import org.junit.jupiter.api.Test;


public class TextBoxDemoQAWithPageObjects extends TestBaseForTextbox {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void successTest() {
        textBoxPage.openPage()
                .setUserName("Igor Shpilchak")
                .setUserEmail("igor@test.ru")
                .setCurrentAddress("Current address 1")
                .setPermanentAddress("Permanent address 1")
                .clickSubmitBtn();

        textBoxPage
                .verifyResult("Igor Shpilchak", "igor@test.ru",
                        "Current address 1", "Permanent address 1");

    }
}
