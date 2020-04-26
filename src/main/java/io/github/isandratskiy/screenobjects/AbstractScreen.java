package io.github.isandratskiy.screenobjects;

import io.github.isandratskiy.core.actions.MobileAction;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.github.isandratskiy.core.driver.AndroidDriverProvider.*;

public abstract class AbstractScreen {

    private static final int WAIT_TIMEOUT = 10;

    private  WebDriverWait wait;
    protected MobileAction action;

    public AbstractScreen() {
        this.wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT);
        this.action = new MobileAction(wait);
    }

    //TODO
}
