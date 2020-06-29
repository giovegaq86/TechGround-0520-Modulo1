package selenium;

import dataproviders.UsersProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.UserAccount;


public class CreateNewUserTests extends BaseClass {

    @Description("Test that register a new user")
    @Test(description = "Test Create a new user", dataProvider = "getUserDataFromJson", dataProviderClass = UsersProvider.class)
    public void Test_Create_New_User(UserAccount userAccount){
        // go to register page
        headerPage().goToRegister();

        // Enter information and submit
        registerPage().setUserInfo(userAccount);

        // Verify if the user was created correctly
        Assert.assertEquals(registerPage().getSuccessfulMessage(), userAccount.getSuccessfulMessage());

        //Verify if the user is logged
        Assert.assertTrue(headerPage().isLogoutEnabled());
    }

}
