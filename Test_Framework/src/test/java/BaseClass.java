import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static String baseUrl = "https://demo.opencart.com/index.php";

    protected WebDriver driver;

    @BeforeTest
    public void setupTest(){
        System.out.println("* Before Test Setup");

        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setupMethod(@Optional("chrome") String browser){

        setInitialConfiguration(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(){
        System.out.println("** After Method Setup");

        TakeScreenshot(driver);
        driver.close();

        try {
            driver.quit();
        }
        catch (WebDriverException ex){
            System.out.println("Session already closed!");
        }
    }

    private void setInitialConfiguration(String browser){
        System.out.println("** Before Method Setup");

        if (browser.equals("firefox"))
            driver = new FirefoxDriver();
        else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] TakeScreenshot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
