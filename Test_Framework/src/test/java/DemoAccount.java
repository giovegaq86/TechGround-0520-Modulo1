import com.sun.javafx.scene.traversal.TopMostTraversalEngine;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoAccount {

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Ignore
    @Test
    public void test_capabilities(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1980,800");
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://expired.badssl.com/");
        driver.findElement(By.id("content")).isDisplayed();

//      driver.manage().window().maximize();
    }

    @Test
    public void test_waits(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");

        driver.findElement(By.id("downloadButton")).click();

        Assert.assertTrue(
                wait.until(
                        ExpectedConditions.textToBe(
                                By.className("progress-label"),
                                "Complete!")));

    }

}
