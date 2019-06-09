package io.github.isandratskiy.screenobjects;

import io.github.isandratskiy.core.actions.MobileAction;

public abstract class AbstractScreen {

    protected MobileAction action;

    public AbstractScreen() {
        action = new MobileAction();
    }

    //TODO
}
