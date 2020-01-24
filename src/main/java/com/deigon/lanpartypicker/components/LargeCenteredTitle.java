package com.deigon.lanpartypicker.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class LargeCenteredTitle extends Div {
    public LargeCenteredTitle(String text) {
        setText(text);
        setClassName("largeCenteredTitle");
    }
}
