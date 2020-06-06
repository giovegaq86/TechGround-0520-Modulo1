import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAccount {

    @Description("Test that login feature works fine")
    @Test
    public void Test_Login_Successful(){

        String email = "hola@hola.com";
        String password = "hola";

        //String driverPath = TestAccount.class.getResource("/drivers/chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("https://demo.opencart.com/index.php");

        // go to login page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        // enter user information
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);

        // click submit
        driver.findElement(By.cssSelector("[value='Login']")).click();

        // verificacion
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
        driver.findElement(By.xpath("//span[text()='My Account']")).click();

        Assert.assertTrue(logoutButton.isEnabled());

        TakeScreenshot(driver);

        driver.close();
        driver.quit();
    }

    @Description("Test that login feature works fine when incorrect username")
    @Test(description = "Test Login Successfull")
    public void Test_Login_Unsuccessful(){

        String email = "hola@hola-failx.com";
        String password = "hola";
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";

//        String driverPath = TestAccount.class.getResource("/drivers/chromedriver").getPath();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("https://demo.opencart.com/index.php");

        // go to login page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        // enter user information
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);

        // click submit
        driver.findElement(By.cssSelector("[value='Login']")).click();

        // verificacion
        WebElement alertMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));

        Assert.assertEquals(expectedMessage.toLowerCase(), alertMessage.getText().toLowerCase().trim());

        TakeScreenshot(driver);


        driver.close();
        driver.quit();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
