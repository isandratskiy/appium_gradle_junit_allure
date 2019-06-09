package io.github.isandratskiy.tests;

import io.github.isandratskiy.BaseTest;
import io.github.isandratskiy.screenobjects.screen.MainScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.appium.java_client.MobileBy.*;
import static io.github.isandratskiy.core.NavigationRouter.*;
import static io.github.isandratskiy.core.wrappers.ElementCondition.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Multiple assert example test")
class MultipleAssertExampleTest extends BaseTest {

    private MainScreen mainPage;

    @BeforeEach
    void setup() {
        mainPage = new MainScreen();
    }

    @DisplayName("multiple assert should failed")
    @Test
    void testMultipleAssertShouldFailed() {
        openActivity(mainPage.ACTIVITY);
        mainPage.openPreference()
                .openHeaders();
        assertAll(
                "All prefs should be displayed.",
                () -> assertTrue(
                        isPresentElement(AndroidUIAutomator("resourceId(\"android:id/title\").text(\"Intent\")")),
                        "Intent button is't displayed"),
                () -> assertTrue(
                        isPresentElement(AndroidUIAutomator("resourceId(\"android:id/failed_id\")")), //failed assert
                        "Failed id should be failed")
        );
    }

    @DisplayName("multiple assert should passed")
    @Test
    void testMultipleAssertShouldPassed() {
        openActivity(mainPage.ACTIVITY);
        mainPage.openPreference()
                .openHeaders();
        assertAll(
                "All prefs should be displayed.",
                () -> assertTrue(
                        isPresentElement(AndroidUIAutomator("resourceId(\"android:id/title\").text(\"Prefs 1\")")),
                        "Prefs1 button is't displayed"),
                () -> assertTrue(
                        isPresentElement(AndroidUIAutomator("resourceId(\"android:id/title\").text(\"Prefs 2\")")),
                        "Prefs2 button is't displayed")
        );
    }
}