package com.deigon.lanpartypicker.components.base;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class FullWidthDiv extends Div {
    public FullWidthDiv() {
        setWidthFull();
    }

    public FullWidthDiv(Component... components) {
        super(components);
        setWidthFull();
    }
}
