
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import pageobject.loginPage;
import pageobject.dashboardPage;


public class loginTest extends baseTest {


    @Test(priority = 1,invocationCount = 1)
    public void allow_user_to_do_login()  throws InterruptedException  {
        loginPage login = new loginPage(baseURL, driver);
        dashboardPage dashboardPage = new dashboardPage(driver);
        login.insertEmail(username);
        login.insertPassword(password);
        login.clickLoginButton();

        login.waitUntilElementExists(dashboardPage.showDashboard());

        Assert.assertEquals(dashboardPage.showDashboard().isDisplayed(), true);
    }

    @Test(groups = {"login"}, priority = 2,invocationCount = 1)
    public void do_not_allow_user_to_do_login()  throws InterruptedException  {
        loginPage login = new loginPage(baseURL, driver);
        login.insertEmail(username);
        login.insertPassword(password);
        login.clickLoginButton();

        // Explicit wait
        login.waitUntilElementExists(login.displayAlertMessage());

        Assert.assertEquals(login.displayAlertMessage().isDisplayed(), true);
    }

}
