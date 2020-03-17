package io.github.isandratskiy.core.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

@Slf4j
public class AppiumDriverProvider {

    private static final int WAIT_TIMEOUT = 10;

    private AndroidDriver<AndroidElement> driver;

    /**
     * initialization.
     */
    @SneakyThrows
    public void setupDriver() {
        log.info("[Appium] Starting to set new driver capabilities");
        val capabilities = new DesiredCapabilities();
        val dir = new File("src/test/java/resources");
        val app = new File(dir, "ApiDemos-debug.apk");

        capabilities.setCapability("browserName", "android");
        capabilities.setCapability("version", "10.0");
        capabilities.setCapability("enableVNC", false);
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", app.getAbsolutePath());

        this.driver = new AndroidDriver<>(new URL("http://0.0.0.0:4444/wd/hub"), capabilities);
    }

    /**
     * getter.
     */
    public AndroidDriver getDriver() {
        return this.driver;
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