package com.mobile.qa.baisc;

import com.mobile.qa.baseTest.BrowserBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileResponsiveBrowserTest extends BrowserBaseTest {


    @Test
    public void browserTest() throws InterruptedException {


        Thread.sleep(1000);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");	//Scroll
        Thread.sleep(1000);
        String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Thread.sleep(1000);
        System.out.println(text);
        Assert.assertEquals(text, "Devops");
        Thread.sleep(5000);


    }
}
