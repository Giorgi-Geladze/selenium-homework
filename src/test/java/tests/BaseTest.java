package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class BaseTest {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        threadLocalDriver.set(driver);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
        threadLocalDriver.remove();
    }
}
