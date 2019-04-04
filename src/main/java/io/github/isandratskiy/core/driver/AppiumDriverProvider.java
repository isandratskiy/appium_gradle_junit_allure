package io.github.isandratskiy.core.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

@Slf4j
public class AppiumDriverProvider {

    private static final int WAIT_TIMEOUT = 10;

    private static String USERNAME = "YOUR_ACCOUNT_USERNAME";
    private static String ACCESS_KEY = "YOUR_KEY";
    private static String HUB = format("https://%s:%s@ondemand.eu-central-1.saucelabs.com/wd/hub", USERNAME, ACCESS_KEY);

    private AndroidDriver<AndroidElement> driver;

    /**
     * initialization.
     */
    public void setupDriver() throws MalformedURLException {
        log.info("[Appium] Starting to set new driver");
        val capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Samsung Galaxy S9 WQHD GoogleAPI Emulator");
        capabilities.setCapability("version", "8.1");
        capabilities.setCapability("app", "sauce-storage:ApiDemos_debug.apk");
        capabilities.setCapability("appiumVersion", "1.11.1");

        log.info("[URL] :: " + HUB);
        driver = new AndroidDriver<>(
                new URL(HUB),
                capabilities
        );
        log.info("[Appium] Driver is returned");
    }

    /**
     * getter.
     */
    public AndroidDriver getDriver() {
        return driver;
    }

    /**
     * getter for waiter.
     */
    public WebDriverWait getWebDriverWait(AndroidDriver driver) {
        return new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    /**
     * finishing.
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            log.info("[Appium] Driver is closed");
        }
    }
}