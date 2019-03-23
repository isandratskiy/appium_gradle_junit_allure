package io.github.isandratskiy.extensions;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

import static io.github.isandratskiy.utils.AttachmentUtils.takeScreenshot;

public class AttachmentExtension implements TestWatcher {

    private AndroidDriver driver;

    public AttachmentExtension(AndroidDriver driver) {
        this.driver = driver;
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        takeScreenshot(driver);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshot(driver);
    }
}