package com.deigon.lanpartypicker.components;

import com.vaadin.flow.component.html.Div;

public class SmallText extends Div {
    public SmallText(String text) {
        setText(text);
        setClassName("smallText");
    }
}
