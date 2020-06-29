package selenium;

import dataproviders.UsersProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.UserAccount;


public class AddPurchaseOrderTest extends BaseClass {

    private static final String ITEM = "MacBook";
    private static final int ITEM_UNITS = 1;
    private static final String MESSAGE = "Products marked with *** are not available in the desired quantity or not in stock!";

    @Description("Test that register a new user")
    @Test(description = "Test Create a new user")
    public void Test_Create_New_User(){
        // Search Item
        headerPage().search(ITEM);

        // Add Item to cart
        searchResultsPage().clickItemButton(ITEM);

        // Add item to cart
        productPage().setAmountToAdd(ITEM_UNITS);
        productPage().clickAddToCart();

        Assert.assertTrue(productPage().isSuccessMessageVisibleWithText(ITEM));

        cartPage().goTo();

        Assert.assertTrue(cartPage().isProductOnCartByName(ITEM));
        Assert.assertEquals(cartPage().getAmountFromProductRow(), ITEM_UNITS);
        Assert.assertEquals(cartPage().getMessage().split("\n")[0], MESSAGE);

    }

}