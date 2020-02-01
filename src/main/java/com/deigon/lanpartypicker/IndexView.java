package com.deigon.lanpartypicker;

import com.deigon.lanpartypicker.components.ImageWithText;
import com.deigon.lanpartypicker.repositories.LanPartyRepository;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "",layout = MainView.class)
public class IndexView extends VerticalLayout {

    public IndexView(LanPartyRepository repository) {
        //todo https://vaadin.com/learn/tutorials/securing-your-app-with-spring-security/form-less
        setClassName("mainContent");
        setJustifyContentMode(JustifyContentMode.BETWEEN);
        setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        repository.getAllLanParties().forEach((lanParty -> {
            ImageWithText lanPartyCard = new ImageWithText(lanParty.getImage(), lanParty.getName(), lanParty.getDescription());
            lanPartyCard.addClickListener((event)-> this.getUI().ifPresent(ui -> ui.navigate("lanParty/"+lanParty.getUuid())));
            add(lanPartyCard);
        }));
    }
}
