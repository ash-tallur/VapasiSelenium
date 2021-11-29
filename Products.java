package com.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Products {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Asking to browser to go for this particular website
        driver.get("https://spree-vapasi-prod.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement dropDown = driver.findElement(By.id("taxon"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Brands");
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys("Ruby");
        driver.findElement(By.cssSelector("input[value='Search']")).click();

        List<WebElement> rubyProducts = driver.findElements(By.cssSelector("div[id='products']>div"));
        int totalNumOfProducts = rubyProducts.size();

        System.out.println("No of Ruby products are " + totalNumOfProducts);
        System.out.println("The product details are as follow :");
        for(int i=0;i<totalNumOfProducts;i++){
            String productDetails = rubyProducts.get(i).getText();
            System.out.println(productDetails);
        }

        driver.quit();

    }
}
