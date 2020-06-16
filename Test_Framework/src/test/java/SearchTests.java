import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseClass{

    @Test(groups = "search")
    @Parameters({"searchCriteria", "expectedResults"})
    public void SearchTest(@Optional("") String searchCriteria, @Optional("0") int expectedResults){

        WebElement searchEntry = driver.findElement(By.name("search"));
        searchEntry.sendKeys(searchCriteria, Keys.ENTER);

        Assert.assertTrue(driver.getCurrentUrl().contains(String.format("search=%s", searchCriteria)));

        if (expectedResults > 0) {
            List<WebElement> results = driver.findElements(By.cssSelector(".product-thumb"));
            Assert.assertEquals(results.size(), expectedResults,
                    String.format("Was expecting %s, but got %s.", expectedResults, results.size()));
        }
        else {
            WebElement result = driver.findElement(By.id("content"));
            Assert.assertTrue(result.getText().contains("There is no product that matches the search criteria.")
                ,"No results text was not found on page");
        }
    }

}
