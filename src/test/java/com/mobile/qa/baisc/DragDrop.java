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

public class DragDrop extends BaseTest {

    @Test
    public void DragDropDemoTest() throws MalformedURLException, InterruptedException {


        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        Thread.sleep(1000);


        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 619,
                "endY", 560
        ));

        Thread.sleep(3000);
        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");

    }
}
