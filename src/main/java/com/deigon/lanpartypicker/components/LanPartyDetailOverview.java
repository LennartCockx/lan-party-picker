package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeCenteredTitle;
import com.deigon.lanpartypicker.domain.LanParty;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@Tag("lan-party-detail-overview")
public class LanPartyDetailOverview extends VerticalLayout {

    private DateSelection dateSelection;

    public LanPartyDetailOverview(LanParty lanParty) {
        dateSelection = new DateSelection(lanParty.getUsersAvailableForDate());
        setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);

        add(new FullWidthDiv(new LargeCenteredTitle(lanParty.getName())));

        add(new FullWidthDiv(dateSelection));
        add(new FullWidthDiv(new GameSelection()));
    }

    public DateSelection getDateSelection() {
        return dateSelection;
    }
}
