package com.autotest.at.autoUtils;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author jay
 * @date 2020/10/26 12:24
 */
public class W {

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities appCapabilities = new DesiredCapabilities();
        // 计算器
        appCapabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        WindowsDriver<WindowsElement> driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), appCapabilities);

        driver.findElementByName("七").click();
        driver.findElementByName("加").click();
        driver.findElementByName("九").click();
        driver.findElementByName("等于").click();
    }

}
