package io.github.isandratskiy.core.driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.net.URL;

import static io.appium.java_client.service.local.AppiumDriverLocalService.*;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;

@Slf4j
public class AppiumServiceProvider {
    private static final ThreadLocal<AppiumDriverLocalService> SERVICE = new ThreadLocal<>();

    /**
     * initialization.
     */
    public void startService() {
        log.info("[Appium] Starting Appium service");
        val builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4730)
                .withArgument(SESSION_OVERRIDE)
                .withArgument(LOG_LEVEL,"error")
                .withArgument(DEBUG_LOG_SPACING)
                .withArgument(LOG_NO_COLORS);
        SERVICE.set(buildService(builder));
        SERVICE.get().clearOutPutStreams();
        SERVICE.get().enableDefaultSlf4jLoggingOfOutputData();
        SERVICE.get().start();
        if (SERVICE.get() == null || !SERVICE.get().isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("[Appium] Appium service node is not started");
        } else {
            log.info("[Appium] Appium service is started");
        }
    }

    /**
     * finishing.
     */
    public void stopService() {
        if (SERVICE.get().isRunning()) {
            SERVICE.get().stop();
            SERVICE.remove();
            log.info("[Appium] Appium service is stopped");
        }
    }

    /**
     * get url for driver.
     */
    static URL getInstance() {
        return SERVICE.get().getUrl();
    }
}