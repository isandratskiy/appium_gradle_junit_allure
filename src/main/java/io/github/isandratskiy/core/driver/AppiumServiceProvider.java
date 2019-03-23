package io.github.isandratskiy.core.driver;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.net.URL;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;

@Slf4j
public class AppiumServiceProvider {

    private static AppiumDriverLocalService service;

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
        service = AppiumDriverLocalService.buildService(builder);
        service.clearOutPutStreams();
        service.enableDefaultSlf4jLoggingOfOutputData();
        service.start();
        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("[Appium] Appium service node is not started");
        } else {
            log.info("[Appium] Appium service is started");
        }
    }

    /**
     * finishing.
     */
    public void stopService() {
        if (service.isRunning()) {
            service.stop();
            log.info("[Appium] Appium service is stopped");
        }
    }

    /**
     * get url for driver.
     */
    static URL getInstance() {
        return service.getUrl();
    }
}