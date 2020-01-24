package com.deigon.lanpartypicker.components.base;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class FullWidthDiv extends Div {
    public FullWidthDiv() {
        getStyle().set("width","100%");
    }

    public FullWidthDiv(Component... components) {
        super(components);
        getStyle().set("width","100%");
    }
}
