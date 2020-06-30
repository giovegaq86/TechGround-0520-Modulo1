package selenium;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchAndAddToCartTests extends BaseClass {

    private static final String ITEM = "MacBook";
    private static final int ITEM_UNITS = 1;
    private static final String MESSAGE = "Products marked with *** are not available in the desired quantity or not in stock!";

    @Description("Test that search an item and then add it to the cart")
    @Test(description = "Test Search and Add to cart item")
    public void Test_Search_And_Add_To_Cart(){
        // Search Item
        headerPage().search(ITEM);

        // Add Item to cart
        searchResultsPage().clickItemButton(ITEM);

        // Add item to cart
        productPage().setAmountToAdd(ITEM_UNITS);
        productPage().clickAddToCart();
        Assert.assertTrue(productPage().isSuccessMessageVisibleWithText(ITEM));

        // Go to the cart
        cartPage().goTo();

        // Verify if the item was added correctly to the cart
        Assert.assertTrue(cartPage().isProductOnCartByName(ITEM));
        Assert.assertEquals(cartPage().getAmountFromProductRow(), ITEM_UNITS);
        Assert.assertTrue(cartPage().getMessage().contains(MESSAGE));

    }

}