package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public String pageURL;
    public WebDriver driver;

    public BasePage(String _pageURL, WebDriver _driver) {
        this.pageURL = _pageURL;
        this.driver = _driver;
    }

    public BasePage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void loadPage() {
        System.out.println(this.pageURL);
        driver.navigate().to(this.pageURL);
    }

    public void waitUntilElementExists(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}


