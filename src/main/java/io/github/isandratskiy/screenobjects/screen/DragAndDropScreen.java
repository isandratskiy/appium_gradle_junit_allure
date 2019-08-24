package io.github.isandratskiy.screenobjects.screen;

import io.github.isandratskiy.screenobjects.AbstractScreen;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static io.appium.java_client.MobileBy.*;

public class DragAndDropScreen extends AbstractScreen {
    public static final String ACTIVITY = ".view.DragAndDropDemo";

    private final By DRAG_DOT_ONE = id("drag_dot_1");
    private final By DRAG_DOT_TWO = id("drag_dot_2");
    private final By DRAG_DOT_THREE = id("drag_dot_3");
    private final By DRAG_DOT_HIDDEN = AndroidUIAutomator("resourceId(\"io.appium.android.apis:id/drag_dot_hidden\").enabled(true)");
    private final By DRAGGABLE_TEXT = AndroidUIAutomator("resourceId(\"io.appium.android.apis:id/drag_text\")");

    private DragAndDropScreen dragAndDropElement(final By fromElement, final By toElement) {
        action.moveTo(fromElement, toElement);
        return this;
    }

    public String getDraggableText() {
        return action.textValue(DRAGGABLE_TEXT);
    }

    @Step("Drag and drop first element")
    public DragAndDropScreen dragFirstElement() {
        dragAndDropElement(DRAG_DOT_ONE, DRAG_DOT_TWO);
        return this;
    }

    @Step("Drag and drop second element")
    public DragAndDropScreen dragSecondElement() {
        dragAndDropElement(DRAG_DOT_TWO, DRAG_DOT_THREE);
        return this;
    }

    @Step("Drag and drop third element")
    public DragAndDropScreen dragThirdElement() {
        dragAndDropElement(DRAG_DOT_THREE, DRAG_DOT_ONE);
        return this;
    }

    @Step("Drag and drop hidden element")
    public DragAndDropScreen dragHiddenElement() {
        dragAndDropElement(DRAG_DOT_HIDDEN, DRAG_DOT_ONE);
        return this;
    }
}