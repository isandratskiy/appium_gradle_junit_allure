package io.github.isandratskiy.screens;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.MobileBy.*;

public class DragAndDropScreen extends BaseScreen {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    public final String ACTIVITY = ".view.DragAndDropDemo";

    public final By DRAG_DOT_ONE = id("drag_dot_1");
    public final By DRAG_DOT_TWO = id("drag_dot_2");
    public final By DRAG_DOT_THREE = id("drag_dot_3");
    public final By DRAG_DOT_HIDDEN = AndroidUIAutomator("resourceId(\"io.appium.android.apis:id/drag_dot_hidden\").enabled(true)");
    private final By DRAGGABLE_TEXT = AndroidUIAutomator("resourceId(\"io.appium.android.apis:id/drag_text\")");

    public DragAndDropScreen(AndroidDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Drag and drop element")
    public DragAndDropScreen dragAndDropElement(By fromElement, By toElement) {
        moveTo(fromElement, toElement);
        return this;
    }

    public String getDraggableText() {
        return textValue(DRAGGABLE_TEXT);
    }
}