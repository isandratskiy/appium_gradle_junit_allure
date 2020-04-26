package io.github.isandratskiy.core.driver;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

@Slf4j
public class AndroidDriverFactory {
    public static DesiredCapabilities getCapabilities() {
        log.info("[Appium] Starting to set new driver capabilities");
        val capabilities = new DesiredCapabilities();
        val dir = new File("src/test/java/resources");
        val app = new File(dir, "ApiDemos-debug.apk");

        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", app.getAbsolutePath());
        return capabilities;
    }
}