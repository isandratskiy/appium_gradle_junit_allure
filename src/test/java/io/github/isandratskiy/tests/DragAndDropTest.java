package io.github.isandratskiy.tests;

import io.appium.java_client.android.AndroidDriver;
import io.github.isandratskiy.BaseTest;
import io.github.isandratskiy.pages.DragAndDropPage;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.github.isandratskiy.core.NavigationRouter.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Drag and drop test")
public class DragAndDropTest extends BaseTest {

    private AndroidDriver driver;
    private DragAndDropPage dragDropPage;

    @BeforeEach
    void setup() {
        driver = driverProvider.getDriver();
        val wait = driverProvider.getWebDriverWait(driver);
        dragDropPage = new DragAndDropPage(driver, wait);

    }

    @DisplayName("can drag and drop element")
    @Test
    void testCanDragAndDropElement() {
        openActivity(driver, ".view.DragAndDropDemo");
        dragDropPage.dragAndDropElement(
                dragDropPage.DRAG_DOT_ONE,
                dragDropPage.DRAG_DOT_THREE
        );
        assertTrue(dragDropPage.getDraggableText().contains("drag_dot_1"));
    }
}
