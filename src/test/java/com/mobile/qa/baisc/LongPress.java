package com.mobile.qa.baisc;

import com.google.common.collect.ImmutableMap;
import com.mobile.qa.baseTest.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class LongPress extends BaseTest {

    @Test
    public void longPressGesture() throws MalformedURLException, InterruptedException {


        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        Thread.sleep(1000);
        WebElement ele=	driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        Thread.sleep(1000);
        longPressAction(ele);
        Thread.sleep(1000);
        String menuText =	driver.findElement(By.id("android:id/title")).getText();
        Thread.sleep(1000);
        Assert.assertEquals(menuText, "Sample menu");
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());






    }
}
