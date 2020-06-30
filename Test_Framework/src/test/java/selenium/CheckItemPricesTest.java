package selenium;
import dataproviders.ItemsProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ItemPrices;


public class CheckItemPricesTest extends BaseClass {

    @Description("Test that check the different prices of a same item")
    @Test(description = "Test that check the different prices of a same item", dataProvider = "getItemsDataFromJson", dataProviderClass = ItemsProvider.class)
    public void Test_Create_New_User(ItemPrices itemPrices){
        // Search Item
        headerPage().search(itemPrices.getProduct());

        // Add Item to cart
        searchResultsPage().clickItemButton(itemPrices.getProduct());

        // select Euro
        productPage().clickCurrency("EUR");

        // Verify price in Euros
        Assert.assertEquals(productPage().getItemPrice(), itemPrices.getEur());

        // select USD
        productPage().clickCurrency("USD");

        // Verify price in USD
        Assert.assertEquals(productPage().getItemPrice(), itemPrices.getUsd());

        // select GBP
        productPage().clickCurrency("GBP");

        // Verify price in GBP
        Assert.assertEquals(productPage().getItemPrice(), itemPrices.getPnd());
    }

}
