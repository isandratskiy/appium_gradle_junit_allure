package io.github.isandratskiy;

import io.github.isandratskiy.extensions.AppiumServiceExtension;
import io.github.isandratskiy.extensions.AttachmentExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.github.isandratskiy.core.driver.AppiumDriverProvider.*;

//extension with appium service running
@ExtendWith({AppiumServiceExtension.class, AttachmentExtension.class})
public class BaseTest {

    @BeforeAll
    static void createDriver() {
        setupDriver();
    }

    @AfterAll
    static void closeDriver() {
        quitDriver();
    }
}