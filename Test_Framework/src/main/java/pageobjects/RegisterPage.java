package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pojo.UserAccount;
import utils.DataUtils;

public class RegisterPage extends BasePage{

    private By firstNameFieldLocator = By.name("firstname");
    private By lastNameFieldLocator = By.name("lastname");
    private By emailFieldLocator = By.name("email");
    private By phoneFieldLocator = By.name("telephone");
    private By passwordFieldLocator = By.name("password");
    private By confirmPasswordFieldLocator = By.name("confirm");
    private String subscribeRadioLocator = "//input[@name='newsletter' and @value=<param1>]";
    private By policyCheckLocator = By.name("agree");
    private By continueButtonLocator = By.xpath("//input[@value='Continue']");
    private By successfulMessageLocator = By.xpath("//div[@id='content']/h1");

    public RegisterPage(WebDriver _driver){
        super(_driver);
    }

    public void setUserInfo(UserAccount userInfo){
        String email = DataUtils.getRandomEmail();
        driver.findElement(firstNameFieldLocator).sendKeys(userInfo.getFirstName());
        driver.findElement(lastNameFieldLocator).sendKeys(userInfo.getLastName());
        driver.findElement(emailFieldLocator).sendKeys(email);
        driver.findElement(phoneFieldLocator).sendKeys(userInfo.getPhone());
        driver.findElement(passwordFieldLocator).sendKeys(userInfo.getPassword());
        driver.findElement(confirmPasswordFieldLocator).sendKeys(userInfo.getPassword());
        this.findElementWithGenericLocator(subscribeRadioLocator, userInfo.getSubscribe()).click();
        WebElement policyCheck = driver.findElement(policyCheckLocator);
        if (userInfo.getPolicy() && !policyCheck.isSelected()){
            policyCheck.click();
        }
        driver.findElement(continueButtonLocator).click();
    }

    public String getSuccessfulMessage(){
        WebElement message = this.waitForElementIsPresent(10, successfulMessageLocator);
        return message.getText();
    }

}
