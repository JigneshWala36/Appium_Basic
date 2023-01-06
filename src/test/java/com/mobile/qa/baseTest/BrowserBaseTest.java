package com.mobile.qa.baseTest;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserBaseTest {

    public static AppiumDriverLocalService appService;
    public static AndroidDriver driver;

    @BeforeClass
    public static void configureAppium() throws InterruptedException, MalformedURLException {

        appService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\jignesh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        appService.start();

//        D:\\Jignesh\\Intellij Project\\Appium\\Appium\\src\\test\\java\\com\\mobile\\qa\\resources\\ApiDemos-debug.apk

        UiAutomator2Options uiOptions = new UiAutomator2Options();
        uiOptions.setDeviceName("JigneshEmulator");  //emulator
//        options.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11");//
        uiOptions.setCapability("browserName", "Chrome");
//        uiOptions.setDeviceName("Android Device");// real device


//        uiOptions.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11"); // chrome driver path
//        uiOptions.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\com\\mobile\\qa\\resources\\ApiDemos-debug.apk");

        uiOptions.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\com\\mobile\\qa\\resources\\General-Store.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void longPressAction(WebElement longPressElement) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) longPressElement).getId(),
                        "duration", 2000));
    }

    public void scrollToEndAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 0.75

            ));
        } while (canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));

    }

    public Double getFormattedAmount(String amount)
    {
        Double price = Double.parseDouble(amount.substring(1));
        return price;

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        appService.stop();
    }

}
