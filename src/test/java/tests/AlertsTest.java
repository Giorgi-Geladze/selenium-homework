package tests;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {
    private final String username = "george geladze";

    @Test
    public void alertsTest(){
        getDriver().get("https://demo.automationtesting.in/Alerts.html");

        getDriver().findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();

        WebElement promptButton = getDriver().findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']"));
        promptButton.click();

        Alert promptAlert = getDriver().switchTo().alert();

        promptAlert.sendKeys(username);
        promptAlert.accept();

        WebElement resultElement = getDriver().findElement(By.id("demo1"));
        String actualResultText = resultElement.getText();

        Assert.assertTrue(actualResultText.contains(username), "Assertion Başarısız: Girdiğimiz metin sonuçta bulunamadı!");
    }
}
