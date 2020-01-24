package com.deigon.lanpartypicker.components.base;

import com.vaadin.flow.component.html.Div;

public class LargeTitle extends Div {
    public LargeTitle(String text) {
        setText(text);
        setClassName("largeTitle");
    }
}
