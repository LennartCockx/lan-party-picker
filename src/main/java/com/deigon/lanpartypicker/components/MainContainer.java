package com.deigon.lanpartypicker.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class MainContainer extends Div {
    public MainContainer(Component... components) {
        super(components);
        getStyle().set("margin-left","auto");
        getStyle().set("margin-right","auto");
        getStyle().set("padding-left","16px");
        getStyle().set("padding-right","16px");
        getStyle().set("max-width","70em");
    }
}
