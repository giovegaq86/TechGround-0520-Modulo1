package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{

    private By resultThumbs = By.cssSelector(".product-thumb");

    public SearchResultsPage(WebDriver _driver){
        super(_driver);
    }

    public int getThumbsCount(){
        return driver.findElements(resultThumbs).size();
    }


}
