package io.github.isandratskiy.utils;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.openqa.selenium.OutputType.BYTES;

@Slf4j
@AllArgsConstructor
public final class AttachmentUtils {

    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] saveScreenshot(final byte[] screenShot) {
        return screenShot;
    }

    public static byte[] takeScreenshot(AndroidDriver driver) {
        if (driver == null) {
            log.info("Driver for screenshot not found");
            return null;
        } else {
            return saveScreenshot(driver.getScreenshotAs(BYTES));
        }
    }
}