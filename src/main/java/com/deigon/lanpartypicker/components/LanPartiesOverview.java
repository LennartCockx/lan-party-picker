package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.domain.LanParty;
import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.content.IconItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class LanPartiesOverview extends VerticalLayout {

    public LanPartiesOverview(List<LanParty> lanParties) {
        setJustifyContentMode(JustifyContentMode.BETWEEN);
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        lanParties.forEach((lanParty -> {
            RippleClickableCard rippleClickableCard = new RippleClickableCard(new IconItem(lanParty.getImage(), lanParty.getName(), lanParty.getDescription()));
            rippleClickableCard.addClickListener((event)-> this.getUI().ifPresent(ui -> ui.navigate("lanParty/"+lanParty.getUuid())));
            add(rippleClickableCard);
        }));
    }
}
