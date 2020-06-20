package selenium;

import dataproviders.SearchProvider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HeaderPage;
import pageobjects.SearchResultsPage;
import pojo.SearchData;
import selenium.BaseClass;

public class SearchTests extends BaseClass {

    @Test(dataProvider = "getSearchDataFromJson", dataProviderClass = SearchProvider.class)
    @Parameters({"searchCriteria","expectedResults"})
    public void SearchTest(SearchData testSearchData){

        HeaderPage headerPage = new HeaderPage(driver);
        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        headerPage.search(testSearchData.getSearchCriteria());

        if (testSearchData.getExpectedResults() > 0) {

            int results = resultsPage.getThumbsCount();
            Assert.assertEquals(results, testSearchData.getExpectedResults(),
                    String.format("Was expecting %s, but got %s.", testSearchData.getExpectedResults(), results));
        }
        else
            Assert.assertTrue(resultsPage.isNoResultsVisible(), "Error message was not displayed");
    }
}