package com.example.shoppinglist;

import android.util.Log;
import android.widget.Toast;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    private AndroidDriver<AndroidElement> driver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.example.shoppinglist");
        desiredCapabilities.setCapability("appActivity", "MainActivity");
        desiredCapabilities.setCapability("noReset", true);
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void sampleTest() {
        MobileElement addButton = driver.findElementById("com.example.shoppinglist:id/add_button");
        wait.until(ExpectedConditions.visibilityOf(addButton));
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.shoppinglist:id/button6")));
        MobileElement itemCorn = driver.findElementById("com.example.shoppinglist:id/button6");
        wait.until(ExpectedConditions.visibilityOf(itemCorn));
        itemCorn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.shoppinglist:id/add_button")));
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.shoppinglist:id/button6")));
        MobileElement itemBread = driver.findElementById("com.example.shoppinglist:id/button4");
        itemBread.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.shoppinglist:id/add_button")));
        MobileElement element1 = driver.findElementById("com.example.shoppinglist:id/item1");
        element1.click();
        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.shoppinglist:id/button6")));
        MobileElement itemGrapes = driver.findElementById("com.example.shoppinglist:id/button15");
        itemGrapes.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.example.shoppinglist:id/add_button")));
        Assert.assertEquals(element1.getText(), "Bread");
        System.out.println("The test is finished!");
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
