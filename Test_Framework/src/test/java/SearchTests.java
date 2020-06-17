import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HeaderPage;
import pageobjects.SearchResultsPage;

import java.util.List;

public class SearchTests extends BaseClass{

    @Test()
    @Parameters({"searchCriteria","expectedResults"})
    public void SearchTest(@Optional("ucreativa") String searchCriteria, @Optional("0") int expectedResults){

        HeaderPage headerPage = new HeaderPage(driver);
        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        headerPage.search(searchCriteria);

        int results = resultsPage.getThumbsCount();

        Assert.assertEquals(results, expectedResults,
                String.format("Was expecting %s, but got %s.", expectedResults, results));
    }

}


// encuentreme la alaerta que tenga texto X