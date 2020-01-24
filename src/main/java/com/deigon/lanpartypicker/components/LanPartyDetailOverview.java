package com.deigon.lanpartypicker.components;

import com.github.appreciated.card.RippleClickableCard;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LanPartyDetailOverview extends VerticalLayout {
    public LanPartyDetailOverview() {
        setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);

        add(new RippleClickableCard(new H2("Test")));
    }
}
