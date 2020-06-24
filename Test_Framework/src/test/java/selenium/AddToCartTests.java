package selenium;

import dataproviders.UsersProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.UserAccount;


public class AddToCartTests extends BaseClass {



    @Description("Verify that add to cart works fine")
    @Test(description = "Add to Cart Test")
    public void Test_Add_To_Cart_Successful(){

        // opciones : 1) buscar el producto, 2) usar el menu, 3) usar el url directo, 4) escoger el primerProducto
         int testAmount = 2;

         String testProduct = homePage().selectFirstProductAndGetName(); // homePage().selectProductByName(testProduct);

         productPage().setAmountToAdd(testAmount);
         productPage().clickAddToCart();

         Assert.assertTrue(productPage().isSuccessMessageVisibleWithText(testProduct));

        // cartPage.goTo(); 1) click on the link 2) go to CartByUrl 3) clickButtonArriba

        // Assert.isTrue(cartPage.isProductOnCartByName(testProduct);
        // Assert.equals(cartPage.getAmountOnCartByName(testProduct), testAmount);
    }

}
