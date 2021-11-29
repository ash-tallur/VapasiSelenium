package com.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindingElement {
    public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver","./Driver/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://spree-vapasi-prod.herokuapp.com/");

            //class activity
            //driver.findElement(By.xpath("(//a[contains(@href,'/login')])")).click();
            //driver.findElement(By.xpath("//a[@href='/login']")).click();

            //finding elements by using multiple By methods
            //email - id ->spree_user_email
            //password -1 -> name  -> spree_user[password]
            //pwd -2 -> css  -> [name = "spree_user[password_confirmation]"]
            //create -- css   --> [data-disable-with = "Create"]

    //           driver.findElement(By.id("spree_user_email")).sendKeys("test1234@test.com");
    //           driver.findElement(By.name("spree_user[password]")).sendKeys("123456");
    //           driver.findElement(By.cssSelector("[name = \"spree_user[password_confirmation]\"]")).sendKeys("123456");
    //           driver.findElement(By.cssSelector("[data-disable-with = \"Create\"]")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[@href='/login']")).click();

            driver.findElement(By.id("spree_user_email")).sendKeys("helloash@hello.com");
            driver.findElement(By.id("spree_user_password")).sendKeys("123456");
            driver.findElement(By.cssSelector("input[type='checkbox']")).click();
            driver.findElement(By.cssSelector("input[value='Login']")).click();

            //asking the page to wait so it will wait for loading all the elements in the page
            Thread.sleep(2000);

            //We find the dropdown menu and then selectign the categories value
            WebElement dropDown = driver.findElement(By.id("taxon"));
            //select class wil be helpful for selecting items from dropdown
            Select select = new Select(dropDown);
            //here we are selecting the categories by choosing the value
            //select.selectByValue("1");
            select.selectByVisibleText("Categories");
            //select.selectByIndex(1);

            //then clicking on search based on the drop down value selected
            driver.findElement(By.cssSelector("input[value='Search']")).click();

            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='$10.00 - $15.00']")).click();
            driver.findElement(By.xpath("//input[@value='$18.00 - $20.00']")).click();
            driver.findElement(By.cssSelector("form[action=\"/products\"] input[value='Search']")).click();
            driver.findElement(By.cssSelector("img[alt='Spree Ringer T-Shirt']")).click();
            driver.findElement(By.id("quantity")).clear();
            driver.findElement(By.id("quantity")).click();
            driver.findElement(By.id("add-to-cart-button")).click();
            driver.findElement(By.id("order_line_items_attributes_1_quantity")).sendKeys("0");






    }
}
