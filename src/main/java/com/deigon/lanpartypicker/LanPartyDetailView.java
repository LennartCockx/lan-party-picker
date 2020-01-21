package com.deigon.lanpartypicker;

import com.deigon.lanpartypicker.domain.LanParty;
import com.deigon.lanpartypicker.repositories.LanPartyRepository;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import java.util.UUID;

@Route("lanParty")
public class LanPartyDetailView extends AppLayout implements HasUrlParameter<String> {

    private LanParty lanParty = new LanParty();
    private LanPartyRepository repository;

    public LanPartyDetailView(LanPartyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        UUID uuid = UUID.fromString(parameter);
        lanParty = repository.getLanPartyByUUID(uuid);

        addToNavbar(lanParty.getImageSmall());

        Tab home = new Tab(lanParty.getName());
        Tab planner = new Tab("Planner");
        Tab games = new Tab("Games");

        Tabs tabs = new Tabs(home,planner,games);
        addToNavbar(tabs);
    }
}
