package io.github.isandratskiy;

import io.github.isandratskiy.core.driver.AndroidDriverFactory;
import io.github.isandratskiy.core.driver.AndroidDriverProvider;
import io.github.isandratskiy.extensions.AppiumServiceExtension;
import io.github.isandratskiy.extensions.AttachmentExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

//extension with appium service running
@ExtendWith({AppiumServiceExtension.class, AttachmentExtension.class})
public class BaseTest {
    private static AndroidDriverProvider androidDriver;

    @BeforeAll
    static void createDriver() {
        androidDriver = new AndroidDriverProvider();
        androidDriver.setupDriver(AndroidDriverFactory.getCapabilities());
    }

    @AfterAll
    static void closeDriver() {
        androidDriver.tearDown();
    }
}