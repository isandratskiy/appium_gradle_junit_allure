package io.github.isandratskiy.tests;

import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.BaseTest;
import io.github.isandratskiy.screens.DragAndDropScreen;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.github.isandratskiy.core.NavigationRouter.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Drag and drop test")
public class DragAndDropExampleTest extends BaseTest {

    private AndroidDriver driver;
    private DragAndDropScreen dragDropPage;

    @BeforeEach
    void setup() {
        driver = driverProvider.getDriver();
        val wait = driverProvider.getWebDriverWait(driver);
        dragDropPage = new DragAndDropScreen(driver, wait);

    }

    @DisplayName("can drag and drop first element")
    @Test
    void testCanDragAndDropElement() {
        openActivity(driver, dragDropPage.ACTIVITY);
        dragDropPage.dragFirstElement();
        assertTrue(
                dragDropPage.getDraggableText().contains("drag_dot_1"),
                "Unable to drag first dot"
        );
    }

    @DisplayName("can drag and drop hidden element")
    @Test
    void testCanDragAndDropHiddenElement() {
        openActivity(driver, dragDropPage.ACTIVITY);
        dragDropPage
                .dragSecondElement()
                .dragHiddenElement();
        assertTrue(
                dragDropPage.getDraggableText().contains("drag_dot_hidden"),
                "Unable to drag hidden dot"
        );
    }
}