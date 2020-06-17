package pageobjects;

import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver _driver){
        this.driver = _driver;
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
