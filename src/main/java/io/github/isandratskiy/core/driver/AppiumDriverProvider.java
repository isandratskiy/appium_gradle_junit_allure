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

    private static final String USERNAME = "USERNAME";
    private static final String ACCESS_KEY = "ACCESS_KEY";
    private static final String URL_MASK = format("https://%s:%s@ondemand.eu-central-1.saucelabs.com:443/wd/hub", USERNAME, ACCESS_KEY);

    private AndroidDriver<AndroidElement> driver;

    /**
     * initialization.
     */
    public void setupDriver() {
        log.info("[Appium] Starting to set new driver");
        val capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appiumVersion", "1.11.1");
        capabilities.setCapability("deviceName","Android GoogleAPI Emulator");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("platformVersion","8.1");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("app","https://github.com/isandratskiy/appium_gradle_junit_allure/raw/master/src/test/java/resources/ApiDemos-debug.apk?raw=true");

        try {
            driver = new AndroidDriver<>(new URL(URL_MASK), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        log.info("[URL] :: " + URL_MASK);
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