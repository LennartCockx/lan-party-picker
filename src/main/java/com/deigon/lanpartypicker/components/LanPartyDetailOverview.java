package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.domain.LanParty;
import com.github.appreciated.card.RippleClickableCard;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LanPartyDetailOverview extends VerticalLayout {
    public LanPartyDetailOverview(LanParty lanParty) {
        setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);

        add(new RippleClickableCard(new LargeCenteredTitle(lanParty.getName())));
    }
}
