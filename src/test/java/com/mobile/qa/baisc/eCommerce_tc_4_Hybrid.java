package com.mobile.qa.baisc;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import com.mobile.qa.baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends BaseTest {


    @Test
    public void FillForm() throws InterruptedException
    {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
        Thread.sleep(500);
        driver.hideKeyboard();
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("android:id/text1")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        Thread.sleep(500);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(500);
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        Thread.sleep(500);
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        Thread.sleep(500);
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(500);

        //Thread.sleep(2000);
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        Thread.sleep(500);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" , "Cart"));
        Thread.sleep(500);
        List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        Thread.sleep(500);
        int count = productPrices.size();
        Thread.sleep(500);
        double totalSum =0;
        for(int i =0; i< count; i++)
        {
            String amountString =productPrices.get(i).getText();
            Thread.sleep(500);
            Double price = getFormattedAmount(amountString);
            Thread.sleep(500);
            totalSum = totalSum + price;  //160.97 + 120 =280.97
            Thread.sleep(500);

        }
        String displaySum =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Thread.sleep(500);
        Double displayFormattedSum = getFormattedAmount(displaySum);
        Thread.sleep(500);
        Assert.assertEquals(totalSum, displayFormattedSum);
        Thread.sleep(500);
        
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        Thread.sleep(500);
        longPressAction(ele);
        Thread.sleep(500);
        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        Thread.sleep(500);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(2000);



        //Hybrid - Google page->

        Thread.sleep(20000);
        Set<String> contexts =driver.getContextHandles();
        Thread.sleep(500);
        for(String contextName :contexts)
        {
            System.out.println(contextName);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver
        Thread.sleep(500);
        driver.findElement(By.name("q")).sendKeys("rahul shetty academy");
        Thread.sleep(500);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(500);
        driver.context("NATIVE_APP");
        Thread.sleep(3000);










    }


}