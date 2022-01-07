package com.autotest.at.auto;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppDemo {

    private static AndroidDriver  driver;

    @BeforeAll
    public static void setUp() throws Exception {
        // set up appium
        //File classpathRoot = new File(System.getProperty("user.dir"));
        //File appDir = new File(classpathRoot, "apps");
        //File app = new File(appDir, "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","127.0.0.1:7555");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("noReset", "True");
        capabilities.setCapability("autoGrantPermissions", "True");
        //capabilities.setCapability("app", app.getAbsolutePath());
        //adb shell dumpsys window | findstr mCurrentFocus
        capabilities.setCapability("appPackage", "com.tencent.mobileqq");
        capabilities.setCapability("appActivity", "com.tencent.mobileqq.activity.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterAll
    public static void tearDown() throws Exception {
        //driver.quit();
    }

    @Test
    public void addContact(){

        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        clickEle(10, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TabHost/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TabWidget/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.TextView"));
        //clickEle(10, By.id("com.tencent.mobileqq:id/group_name"));
        clickEle(10, By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TabHost/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.AbsListView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View"));

        clickEle(10, By.xpath("//android.widget.Button[@content-desc=\"发消息\"]"));
        clickEle(10, By.id("com.tencent.mobileqq:id/input"));

        WebElement inputEl = driver.findElement(By.id("com.tencent.mobileqq:id/input"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        inputEl.sendKeys("测试说");

        clickEle(10, By.id("com.tencent.mobileqq:id/fun_btn"));
    }

    private void clickEle(long timeOutInSeconds, By locator) {
        WebDriverWait lianxirenWait = new WebDriverWait(driver,timeOutInSeconds);
        WebElement lianxirenEl = lianxirenWait.until(ExpectedConditions.elementToBeClickable(locator));
        lianxirenEl.click();
    }
}
