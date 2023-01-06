package com.mobile.qa.baisc;

import com.mobile.qa.baseTest.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class MiscDemoTest extends BaseTest {

    @Test
    public void MiscTest() throws MalformedURLException, InterruptedException {

        //adb shell dumpsys window | grep -E 'mCurrentFocus'  - MAC
        // adb shell dumpsys window | find "mCurrentFocus"  - Windows

        //App Package & App Activity

        Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);

        Thread.sleep(3000);
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        Thread.sleep(1000);
//        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/checkbox")).click();
        Thread.sleep(1000);

        // Rotation
        DeviceRotation landScape = new DeviceRotation(0, 0, 90);
        Thread.sleep(1000);
        driver.rotate(landScape);
        Thread.sleep(1000);


        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        Thread.sleep(1000);
        String popUpWifiHeader = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(popUpWifiHeader,"WiFi settings", "Wifi Pop Up header not match");
        Thread.sleep(1000);
        driver.setClipboardText("Jignesh Wala");
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        Thread.sleep(1000);

        // Keyboard Events
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(1000);




    }
}
