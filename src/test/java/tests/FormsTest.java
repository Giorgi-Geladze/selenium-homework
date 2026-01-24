package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

@Epic("Form Tests")
@Feature("Automation Practice Form")
public class FormsTest extends BaseTest {

    @Test
    @Epic("User Interactions") // დიდი კატეგორია
    @Feature("Form Submission") // კონკრეტული ფუნქციონალი
    @Story("Positive form fill") // კონკრეტული სცენარი
    @Severity(SeverityLevel.CRITICAL) // რამდენად მნიშვნელოვანია ტესტი
    @Description("ეს ტესტი ამოწმებს ფორმის წარმატებით შევსებას")
    public void FormTest() {
        PracticeFormPage formPage = new PracticeFormPage(getDriver());

        getDriver().get("https://demoqa.com/automation-practice-form");

        formPage.fillName("george", "geladze");
        formPage.fillContact("george@test.com", "5551234567");
        formPage.selectGender("Male");
        formPage.fillSubject("Math");
        formPage.selectHobby("Sports");
        formPage.fillAddress("ager aqane sadgac");

        formPage.submitForm();

        // Assertions
        Assert.assertEquals(formPage.getModalTitle(), "Thanks for submitting the form");
        Assert.assertEquals(formPage.getResultValue("Student Name"), "george geladze");
        Assert.assertEquals(formPage.getResultValue("Student Email"), "george@test.com");
    }
}