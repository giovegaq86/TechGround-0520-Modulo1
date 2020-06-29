package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage{

    private By productQuantityLocator = By.id("input-quantity");
    private By addToCartButtonLocator = By.id("button-cart");
    private By currenciesButtonLocator = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    private String currencyLocator = "//button[@name='<param1>']";
    private By priceLabelLocator = By.xpath("(//div[@class='col-sm-4'])[2]/ul[2]/li/h2");

    public ProductPage(WebDriver _driver){
        super(_driver);
    }

   public void setAmountToAdd(int amount){
       driver.findElement(productQuantityLocator).clear();
       driver.findElement(productQuantityLocator).sendKeys(String.valueOf(amount));
   }

   public void clickAddToCart(){
        driver.findElement(addToCartButtonLocator).click();
   }

   public void clickCurrency(String currency){
        driver.findElement(currenciesButtonLocator).click();
        this.findElementWithGenericLocator(currencyLocator, currency).click();
   }

    public String getItemPrice(){
        String price = driver.findElement(priceLabelLocator).getText();

        return price.replace("$", "").replace("€","").replace("£","");
   }



}
