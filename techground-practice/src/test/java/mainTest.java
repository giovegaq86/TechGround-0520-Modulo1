import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class mainTest {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/alexandergonzalezfernandez/TechGround-0520-Modulo1/techground-practice/drivers/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://demo.opencart.com/index.php?route=account/login";
    }

    @Test
    public void Login() throws InterruptedException {
        driver.get(baseUrl);
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("alexgf08@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("account-account"));
        Assert.assertEquals(driver.findElement(By.id("account-account")).isDisplayed(), true);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
