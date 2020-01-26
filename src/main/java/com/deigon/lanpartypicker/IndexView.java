package com.deigon.lanpartypicker;

import com.deigon.lanpartypicker.components.LanPartiesOverview;
import com.deigon.lanpartypicker.repositories.LanPartyRepository;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "",layout = MainView.class)
public class IndexView extends VerticalLayout {

    public IndexView(LanPartyRepository repository) {
            //todo https://vaadin.com/learn/tutorials/securing-your-app-with-spring-security/form-less

        add(new LanPartiesOverview(repository.getAllLanParties()));

        setClassName("mainContent");
    }
}
