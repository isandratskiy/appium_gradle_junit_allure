package io.github.isandratskiy.core.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.isandratskiy.core.driver.AppiumServiceProvider.getInstance;
import static java.util.Optional.ofNullable;

@Slf4j
public class AndroidDriverProvider {
    private static final ThreadLocal<AndroidDriver<AndroidElement>> DRIVER = new ThreadLocal<>();
    private static final int TIMEOUT = 20;

    public static AndroidDriver getDriver() {
        return DRIVER.get();
    }

    public static WebDriverWait getDriverWait() {
        return new WebDriverWait(getDriver(), TIMEOUT);
    }

    public void setupDriver(DesiredCapabilities capabilities) {
        DRIVER.set(new AndroidDriver<>(getInstance(), capabilities));
        log.info("[Appium] Driver is returned");
    }

    public void tearDown() {
        ofNullable(getDriver()).ifPresent(AndroidDriver::quit);
        DRIVER.remove();
        log.info("[Appium] Driver is closed");
    }

    private static boolean isDriverPresent() {
        return ofNullable(getDriver()).isPresent();
    }
}
