package selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HeaderPage;
import pageobjects.LoginPage;


public class AccountTests extends BaseClass {

    // 1. removed parametros de user y email
    // 2. crear un pojo y usarlo en el test
    // 3. crear in json
    // 4. crear un datasource que lea el json
    // 5. apuntar el test an datasource
    // 6. quitar los parametros del SearchSuite.xml
    // 7. dejar solo 1 metodo

    @Description("Test that login feature works fine")
    @Test(description = "Test Login Success")
    @Parameters({"email","password"})
    public void Test_Login_Successful(UserAccount userAccount){

        HeaderPage headerPage = new HeaderPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // go to login page
        headerPage.goToLogin();

        // enter information
        loginPage.loginWithCredentials(userAccount.getEmail(), userAccount.getPassword());

        // verificacion
        Assert.assertTrue(headerPage.isLogoutLinkEnabled());
    }



//    @Description("Test that login feature works fine when incorrect username")
//    @Test(description = "Test Login Fail")
//    @Parameters({"email","password"})
//    public void Test_Login_Unsuccessful(@Optional("holas@holas.com") String email, @Optional("holas") String password){
//        System.out.println("*** Test");
//
//        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
//
//        // go to login page
//        HeaderPage headerPage = new HeaderPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//
//        // go to login page
//        headerPage.goToLogin();
//
//        loginPage.loginWithCredentials(email, password);
//
//        Assert.assertTrue(loginPage.isAlertPresentWithText(expectedMessage));
//    }

}
