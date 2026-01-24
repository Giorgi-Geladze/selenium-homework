package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    // ლოკატორები
    private By alertWithTextboxTab = By.xpath("//a[normalize-space()='Alert with Textbox']");
    private By promptButton = By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']");
    private By resultText = By.id("demo1");

    // მოქმედებები
    public void clickAlertWithTextbox() {
        driver.findElement(alertWithTextboxTab).click();
    }

    public void clickPromptButton() {
        driver.findElement(promptButton).click();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}