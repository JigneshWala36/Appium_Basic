package com.mobile.qa.baisc;

import com.mobile.qa.baseTest.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SwipeDemo extends BaseTest {

    @Test
    public void SwipeDemoTest() throws MalformedURLException, InterruptedException {


        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        Thread.sleep(1000);
        WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");

        swipeAction(firstImage,"left");
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");





    }
}
