package com.mobile.qa.baisc;

import com.mobile.qa.baseTest.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class eCommerce_tc_1 extends BaseTest {

    @Test
    public void eCommerce_tc_1Test() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jignesh Wala");
        Thread.sleep(1000);
        driver.hideKeyboard();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("android:id/text1")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(1000);
/*
        // Verify the Toaster message
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Thread.sleep(1000);

        Assert.assertEquals(toastMessage,"Please enter your name");

 */


        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

        Thread.sleep(1000);

        int productCount =	driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i =0;i<productCount;i++)
        {
            String productName =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            Thread.sleep(1000);

            if(productName.equalsIgnoreCase("Jordan 6 Rings"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                Thread.sleep(1000);
            }
        }

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text" , "Cart"));
        Thread.sleep(1000);
        String lastPageProduct =driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Thread.sleep(1000);
        Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");



    }


}
