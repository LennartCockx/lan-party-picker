package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.domain.LanParty;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class LanPartiesOverview extends VerticalLayout {

    public LanPartiesOverview(List<LanParty> lanParties) {
        setJustifyContentMode(JustifyContentMode.BETWEEN);
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        lanParties.forEach((lanParty -> {
            ImageWithText imageWithText = new ImageWithText(lanParty.getImage(), lanParty.getName(), lanParty.getDescription());
            FullWidthDiv lanPartyCard = new FullWidthDiv(imageWithText);
            lanPartyCard.addClickListener((event)-> this.getUI().ifPresent(ui -> ui.navigate("lanParty/"+lanParty.getUuid())));
            add(lanPartyCard);
        }));
    }
}
