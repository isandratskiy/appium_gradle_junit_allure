package io.github.isandratskiy.tests;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.BaseTest;
import io.github.isandratskiy.pages.MainPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.appium.java_client.MobileBy.*;
import static io.github.isandratskiy.core.wrappers.ElementCondition.*;
import static io.github.isandratskiy.pages.HeadersPage.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Multiple assert example")
class MultipleAssertExampleTest extends BaseTest {

    private AndroidDriver driver;
    private MainPage mainPage;
    private Activity activity;

    @BeforeEach
    void setup() {
        driver = driverProvider.getDriver();
        val wait = driverProvider.getWebDriverWait(driver);
        activity = new Activity("io.appium.android.apis", ".ApiDemos");
        mainPage = new MainPage(driver, wait);
    }

    @DisplayName("multiple assert should failed")
    @Test
    void testMultipleAssertShouldFailed() {
        driver.startActivity(activity);
        mainPage.openPreference()
                .openHeaders();
        assertAll(
                "All prefs should be displayed.",
                () -> assertTrue(
                        isPresentElement(driver, PREF_ONE_BUTTON),
                        "Prefs1 button is't displayed"),
                () -> assertTrue(
                        isPresentElement(driver, id("failed")), //failed assert
                        "Prefs2 button is't displayed")
        );
    }

    @DisplayName("multiple assert should passed")
    @Test
    void testMultipleAssertShouldPassed() {
        driver.startActivity(activity);
        mainPage.openPreference()
                .openHeaders();
        assertAll(
                "All prefs should be displayed.",
                () -> assertTrue(
                        isPresentElement(driver, PREF_ONE_BUTTON),
                        "Prefs1 button is't displayed"),
                () -> assertTrue(
                        isPresentElement(driver, PREF_TWO_BUTTON),
                        "Prefs2 button is't displayed"),
                () -> assertTrue(
                        isPresentElement(driver, INTENT_BUTTON),
                        "Intent button is't displayed")
        );
    }
}