package com.mobile.qa.baisc;

import com.mobile.qa.baseTest.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class AppiumBasics extends BaseTest {

    @Test
    public void AppiumTest() throws MalformedURLException, InterruptedException {


        Thread.sleep(3000);
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/checkbox")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        Thread.sleep(1000);
        String popUpWifiHeader = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(popUpWifiHeader,"WiFi settings", "Wifi Pop Up header not match");
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/edit")).sendKeys("Jignesh Wala");
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(1000);



    }
}
