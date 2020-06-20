import apple.laf.JRSUIConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class baseTest {

    public WebDriver driver;
    public String username;
    public String password;
    public String baseURL = "https://demo.opencart.com/index.php?route=account/login";

    @BeforeMethod(alwaysRun = true)
    @Parameters({"username", "password","browser"})
    public void setUpTest(String username, String password, String browser){
        setInitialConfiguration(browser);
        this.username = username;
        this.password = password;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        try {
            driver.quit();
        }catch (WebDriverException ex) {
            System.out.println("Sesion de driver esta cerrada.");
        }
    }

    private void setInitialConfiguration(String browser)  {
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setBrowserName("chrome");
//        String Node = "http://localhost:4444/wd/hub";
//        driver = new RemoteWebDriver(new URL(Node), cap);
        System.out.println("** Before Method Setup");
        if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get(baseURL);;
    }


}
