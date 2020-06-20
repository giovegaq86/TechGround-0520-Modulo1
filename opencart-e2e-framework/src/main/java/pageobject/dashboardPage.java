package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardPage extends BasePage{

    private By dashboard = By.id("account-account");

    public dashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement showDashboard() {
        return driver.findElement(this.dashboard);
    }
}
