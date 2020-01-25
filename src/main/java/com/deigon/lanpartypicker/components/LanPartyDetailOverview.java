package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeCenteredTitle;
import com.deigon.lanpartypicker.domain.LanParty;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LanPartyDetailOverview extends VerticalLayout {
    public LanPartyDetailOverview(LanParty lanParty) {
        setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);

        add(new FullWidthDiv(new LargeCenteredTitle(lanParty.getName())));
        add(new FullWidthDiv(new DateSelection()));
        add(new FullWidthDiv(new GameSelection()));

    }
}
