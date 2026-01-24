package pages;

import org.openqa.selenium.*;
import java.util.List;

public class PracticeFormPage {
    private WebDriver driver;
    private JavascriptExecutor js;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // ლოკატორები (By)
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmail = By.id("userEmail");
    private By userNumber = By.id("userNumber");
    private By subjectsInput = By.id("subjectsInput");
    private By currentAddress = By.id("currentAddress");
    private By submitButton = By.id("submit");
    private By modalTitle = By.id("example-modal-sizes-title-lg");

    // მეთოდები (მოქმედებები)
    public void fillName(String fName, String lName) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
    }

    public void selectGender(String gender) {
        WebElement genderRadio = driver.findElement(By.xpath("//label[text()='" + gender + "']"));
        js.executeScript("arguments[0].click();", genderRadio);
    }

    public void fillContact(String email, String phone) {
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userNumber).sendKeys(phone);
    }

    public void fillSubject(String subject) {
        driver.findElement(subjectsInput).sendKeys(subject);
        driver.findElement(subjectsInput).sendKeys(Keys.ENTER);
    }

    public void selectHobby(String hobby) {
        WebElement hobbyCheckbox = driver.findElement(By.xpath("//label[text()='" + hobby + "']"));
        js.executeScript("arguments[0].click();", hobbyCheckbox);
    }

    public void fillAddress(String address) {
        driver.findElement(currentAddress).sendKeys(address);
    }

    public void submitForm() {
        // შენი კოდიდან გადმოვიტანე iframe-ების წაშლა, რომ ღილაკს ხელი არ შეუშალოს
        js.executeScript("document.querySelectorAll('iframe').forEach(el => el.remove());");
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(submitButton));
        js.executeScript("arguments[0].click();", driver.findElement(submitButton));
    }

    public String getModalTitle() {
        return driver.findElement(modalTitle).getText();
    }

    public String getResultValue(String label) {
        return driver.findElement(By.xpath("//td[text()='" + label + "']/following-sibling::td")).getText();
    }
}