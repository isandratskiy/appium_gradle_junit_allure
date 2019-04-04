package io.github.isandratskiy;

import io.github.isandratskiy.core.driver.AppiumDriverProvider;
import io.github.isandratskiy.extensions.AppiumServiceExtension;
import io.github.isandratskiy.extensions.AttachmentExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.net.MalformedURLException;

public class BaseTest {

    protected static AppiumDriverProvider driverProvider;

    //apply this extension as class field of a test
    @RegisterExtension
    AttachmentExtension attachment = new AttachmentExtension(driverProvider.getDriver());

    @BeforeAll
    static void createDriver() throws MalformedURLException {
        driverProvider = new AppiumDriverProvider();
        setupDriver();
    }

    @AfterAll
    static void closeDriver() {
        driverProvider.quitDriver();
    }

    private static void setupDriver() throws MalformedURLException {
        driverProvider.setupDriver();
    }
}