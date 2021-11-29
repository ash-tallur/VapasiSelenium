package com.spree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver");
        WebDriver driver = new ChromeDriver();

        //Asking to browser to go for this particular website
        driver.get("https://spree-vapasi-prod.herokuapp.com/login");
        driver.manage().window().maximize();
        //Finding the login credentials and logging in
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

        driver.findElement(By.cssSelector("span[title='Ruby on Rails Tote']")).click();
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("2");
        driver.findElement(By.id("add-to-cart-button")).click();
        Thread.sleep(1000);
        String total = driver.findElement(By.cssSelector("td[class='lead']")).getText();
        System.out.println("The total of the product is "+total);

        driver.quit();
    }
}
