package com.mobile.qa.baisc;

import com.mobile.qa.baseTest.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollDemo extends BaseTest {

    @Test
    public void ScrollDemoTest() throws MalformedURLException, InterruptedException {


        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(1000);
        //where to scroll is known prior
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        //No prior idea
        scrollToEndAction();


    }
}
