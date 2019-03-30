package io.github.isandratskiy.tests;

import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.BaseTest;
import io.github.isandratskiy.screens.HeadersScreen;
import io.github.isandratskiy.screens.MainScreen;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.appium.java_client.MobileBy.*;
import static io.github.isandratskiy.core.NavigationRouter.*;
import static io.github.isandratskiy.core.wrappers.ElementCondition.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Multiple assert example test")
class MultipleAssertExampleTest extends BaseTest {

    private AndroidDriver driver;
    private MainScreen mainPage;
    private HeadersScreen headers;

    @BeforeEach
    void setup() {
        driver = driverProvider.getDriver();
        val wait = driverProvider.getWebDriverWait(driver);
        mainPage = new MainScreen(driver, wait);
        headers = new HeadersScreen(driver, wait);
    }

    @DisplayName("multiple assert should failed")
    @Test
    void testMultipleAssertShouldFailed() {
        openActivity(driver, mainPage.ACTIVITY);
        mainPage.openPreference()
                .openHeaders();
        assertAll(
                "All prefs should be displayed.",
                () -> assertTrue(
                        isPresentElement(driver, headers.PREF_ONE_BUTTON),
                        "Prefs1 button is't displayed"),
                () -> assertTrue(
                        isPresentElement(driver, id("failed")), //failed assert
                        "Prefs2 button is't displayed")
        );
    }

    @DisplayName("multiple assert should passed")
    @Test
    void testMultipleAssertShouldPassed() {
        openActivity(driver, mainPage.ACTIVITY);
        mainPage.openPreference()
                .openHeaders();
        assertAll(
                "All prefs should be displayed.",
                () -> assertTrue(
                        isPresentElement(driver, headers.PREF_ONE_BUTTON),
                        "Prefs1 button is't displayed"),
                () -> assertTrue(
                        isPresentElement(driver, headers.PREF_TWO_BUTTON),
                        "Prefs2 button is't displayed"),
                () -> assertTrue(
                        isPresentElement(driver, headers.INTENT_BUTTON),
                        "Intent button is't displayed")
        );
    }
}