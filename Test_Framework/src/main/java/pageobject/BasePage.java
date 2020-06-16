package pageobject;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public String pageUrl;
    public WebDriver driver;

    public BasePage(WebDriver _driver, String _pageUrl){
        this.driver = _driver;
        this.pageUrl = _pageUrl;
    }

    public void loadPage(){
        driver.navigate().to(pageUrl);
    }

}
