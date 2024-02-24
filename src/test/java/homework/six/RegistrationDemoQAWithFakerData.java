package homework.six;

import homework.five.pages.RegistrationPage;
import homework.one.TestBase;
import org.junit.jupiter.api.Test;

public class RegistrationDemoQAWithFakerData extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    FakerData randomData = new FakerData();

    String firstName = randomData.getFirstName(),
            lastName = randomData.getLastName(),
            email = randomData.getEmail(),
            gender = randomData.getGender(),
            phoneNumber = randomData.getPhoneNumber(),
            day = randomData.getDay(),
            month = randomData.getMonth(),
            year = randomData.getYear(),
            subject = randomData.getSubjects(),
            hobby = randomData.getHobbies(),
            fileName = "img/Mock.jpg",
            address = randomData.getAddress(),
            state = randomData.getState(),
            city = randomData.getCity(state);


    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .closeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setBirthDay(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .addPicture(fileName)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitBtn();


        registrationPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "Mock.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
}