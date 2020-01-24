package com.deigon.lanpartypicker.components.base;

import com.vaadin.flow.component.html.Div;

public class LargeCenteredTitle extends Div {
    public LargeCenteredTitle(String text) {
        setText(text);
        setClassName("largeCenteredTitle");
    }
}
