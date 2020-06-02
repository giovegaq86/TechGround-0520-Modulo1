package com.company;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.*;


public class Main {

    WebDriver browser = new ChromeDriver();

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/alexandergonzalezfernandez/TechGround-0520-Modulo1/techground-practice/drivers/chromedriver");

        browser.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @Test
    public void Login() {

        browser.findElement(By.name("email")).sendKeys("Hola");
        browser.findElement(By.xpath("//input[@type='password']")).sendKeys("Hola");
        browser.findElement(By.xpath("//input[@type='submit']")).click();


    }

    @AfterTest
    public void tearDown() {
        browser.close();
        browser.quit();
    }
}
