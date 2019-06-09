package io.github.isandratskiy.tests;

import io.github.isandratskiy.BaseTest;
import io.github.isandratskiy.screenobjects.screen.DragAndDropScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.github.isandratskiy.core.NavigationRouter.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Drag and drop test")
public class DragAndDropExampleTest extends BaseTest {

    private DragAndDropScreen dragAndDropScreen;

    @BeforeEach
    void setup() {
        dragAndDropScreen = new DragAndDropScreen();

    }

    @DisplayName("can drag and drop first element")
    @Test
    void testCanDragAndDropElement() {
        openActivity(dragAndDropScreen.ACTIVITY);
        dragAndDropScreen.dragFirstElement();
        assertTrue(
                dragAndDropScreen.getDraggableText().contains("drag_dot_1"),
                "Unable to drag first dot"
        );
    }

    @DisplayName("can drag and drop hidden element")
    @Test
    void testCanDragAndDropHiddenElement() {
        openActivity(dragAndDropScreen.ACTIVITY);
        dragAndDropScreen.dragSecondElement()
                .dragHiddenElement();
        assertTrue(
                dragAndDropScreen.getDraggableText().contains("drag_dot_hidden"),
                "Unable to drag hidden dot"
        );
    }
}