package io.github.isandratskiy.core.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static io.github.isandratskiy.core.driver.AppiumServiceProvider.*;

@Slf4j
public class AppiumDriverProvider {

    private static final int WAIT_TIMEOUT = 10;

    private static final ThreadLocal<AndroidDriver<AndroidElement>> DRIVER = new ThreadLocal<>();

    /**
     * initialization.
     */
    public static void setupDriver() {
        log.info("[Appium] Starting to set new driver");
        val capabilities = new DesiredCapabilities();
        val dir = new File("src/test/java/resources");
        val app = new File(dir, "ApiDemos-debug.apk");

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", app.getAbsolutePath());

        DRIVER.set(new AndroidDriver<>(getInstance(), capabilities));
        log.info("[Appium] Driver is returned");
    }

    /**
     * getter.
     */
    public static AndroidDriver getDriver() {
        return DRIVER.get();
    }

    /**
     * getter for waiter.
     */
    public static WebDriverWait getDriverWait() {
        return new WebDriverWait(getDriver(), WAIT_TIMEOUT);
    }

    /**
     * finishing.
     */
    public static void quitDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            log.info("[Appium] Driver is closed");
        }
    }
}