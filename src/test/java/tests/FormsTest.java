package tests;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {
    @Test
    public void FormTest(){
        getDriver().get("https://demoqa.com/automation-practice-form");

        String FirstName = "george";
        String LastName = "geladze";
        String Email = "george@test.com";
        String Tel = "5551234567";
        String Gender = "Male";

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 800)");

        getDriver().findElement(By.id("firstName")).sendKeys(FirstName);
        getDriver().findElement(By.id("lastName")).sendKeys(LastName);
        getDriver().findElement(By.id("userEmail")).sendKeys(Email);
        getDriver().findElement(By.xpath("//label[text()='"+Gender+"']")).click();
        getDriver().findElement(By.id("userNumber")).sendKeys(Tel);

        String Subject = "Math";

        getDriver().findElement(By.id("subjectsInput")).sendKeys(Subject);
        getDriver().findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);

        js.executeScript("window.scrollBy(0, 800)");

        String Hobby = "Sports";

        getDriver().findElement(By.xpath("//label[text()='"+Hobby+"']")).click();

        String Address = "ager aqane sadgac";

        getDriver().findElement(By.id("currentAddress")).sendKeys(Address);

        js.executeScript("window.scrollBy(0, 800)");

//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("window.scrollBy(0, 1000)");

        js.executeScript(
                "const iframes = document.querySelectorAll('iframe[src*=\"google\"]');" +
                        "iframes.forEach(iframe => iframe.remove());"
        );

        getDriver().findElement(By.id("submit")).click();


        WebElement modalTitle = getDriver().findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertTrue(modalTitle.isDisplayed(), "Submission modal not opened");

        String expectedFullName = FirstName + " " + LastName;
        String actualFullName = getDriver().findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText();
        Assert.assertEquals(actualFullName, expectedFullName, "name/lastname incorrect!");

        String actualEmail = getDriver().findElement(By.xpath("//td[text()='Student Email']/following-sibling::td")).getText();
        Assert.assertEquals(actualEmail, Email, "Email incorrect!");

        String actualGender = getDriver().findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText();
        Assert.assertEquals(actualGender, Gender, "gender incorrect!");

        String actualMobile = getDriver().findElement(By.xpath("//td[text()='Mobile']/following-sibling::td")).getText();
        Assert.assertEquals(actualMobile, Tel, "tel incorrect!");

        String actualSubject = getDriver().findElement(By.xpath("//td[text()='Subjects']/following-sibling::td")).getText();
        Assert.assertTrue(actualSubject.contains(Subject), "subject incorrect!");

        String actualHobby = getDriver().findElement(By.xpath("//td[text()='Hobbies']/following-sibling::td")).getText();
        Assert.assertTrue(actualHobby.contains(Hobby), "hobby incorrect!");

        js.executeScript("window.scrollBy(0, 500)");

        js.executeScript(
                "const iframes = document.querySelectorAll('iframe[src*=\"google\"]');" +
                        "iframes.forEach(iframe => iframe.remove());"
        );

        WebElement closeButton = getDriver().findElement(By.id("closeLargeModal"));
        js.executeScript("arguments[0].click();", closeButton);
//        getDriver().findElement(By.id("closeLargeModal")).click();
    }
}
