package tests;

import io.qameta.allure.*;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage; // აუცილებლად დააიმპორტე!

public class AlertsTest extends BaseTest {

    @Test
    @Epic("User Interactions") // დიდი კატეგორია
    @Feature("Form Submission") // კონკრეტული ფუნქციონალი
    @Story("Positive form fill") // კონკრეტული სცენარი
    @Severity(SeverityLevel.CRITICAL) // რამდენად მნიშვნელოვანია ტესტი
    @Description("ეს ტესტი ამოწმებს ფორმის წარმატებით შევსებას")
    public void alertsTest() {
        AlertsPage alertsPage = new AlertsPage(getDriver()); // გვერდის ობიექტის შექმნა

        getDriver().get("https://demo.automationtesting.in/Alerts.html");

        alertsPage.clickAlertWithTextbox();
        alertsPage.clickPromptButton();

        Alert promptAlert = getDriver().switchTo().alert();
        promptAlert.sendKeys("george geladze");
        promptAlert.accept();

        Assert.assertTrue(alertsPage.getResultText().contains("george geladze"));
    }
}