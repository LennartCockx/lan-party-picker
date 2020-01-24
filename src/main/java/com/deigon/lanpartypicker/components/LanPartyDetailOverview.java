package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.LargeCenteredTitle;
import com.deigon.lanpartypicker.domain.LanParty;
import com.github.appreciated.card.ClickableCard;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class LanPartyDetailOverview extends VerticalLayout {
    public LanPartyDetailOverview(LanParty lanParty) {
        setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);

        add(new ClickableCard(new LargeCenteredTitle(lanParty.getName())));
        add(new ClickableCard(new DateSelection()));
        add(new ClickableCard(new GameSelection()));

    }
}
