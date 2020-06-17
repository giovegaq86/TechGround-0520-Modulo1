import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HeaderPage;
import pageobjects.LoginPage;

public class AccountTests extends BaseClass{

    @Description("Test that login feature works fine")
    @Test(description = "Test Login Success")
    @Parameters({"email","password"})
    public void Test_Login_Successful(@Optional("hola@hola.com") String email, @Optional("hola") String password){

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // go to login page
        headerPage.goToLogin();

        // enter information
        loginPage.loginWithCredentials(email, password);

        // verificacion
        Assert.assertTrue(headerPage.isLogoutLinkEnabled());

    }

    @Description("Test that login feature works fine when incorrect username")
    @Test(description = "Test Login Fail")
    @Parameters({"email","password"})
    public void Test_Login_Unsuccessful(@Optional("holas@holas.com") String email, @Optional("holas") String password){
        System.out.println("*** Test");

        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";

        // go to login page
        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // go to login page
        headerPage.goToLogin();

        loginPage.loginWithCredentials(email, password);

        Assert.assertTrue(loginPage.isAlertPresentWithText(expectedMessage));
    }



}
