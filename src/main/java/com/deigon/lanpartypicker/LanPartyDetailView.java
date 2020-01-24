package com.deigon.lanpartypicker;

import com.deigon.lanpartypicker.components.LanPartiesOverview;
import com.deigon.lanpartypicker.components.LanPartyDetailOverview;
import com.deigon.lanpartypicker.components.MainContainer;
import com.deigon.lanpartypicker.domain.LanParty;
import com.deigon.lanpartypicker.repositories.LanPartyRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Image imageSmall = lanParty.getImageSmall();
        HorizontalLayout layout = new HorizontalLayout(imageSmall);
        layout.getStyle().set("cursor","pointer");
        layout.addClickListener((action -> this.getUI().ifPresent((screen)->screen.navigate(""))));
        addToNavbar(layout);

        Tab home = new Tab(lanParty.getName());
        Component homePage = new MainContainer(new LanPartyDetailOverview());
        Tab planner = new Tab("Planner");
        Tab games = new Tab("Games");

        HashMap<Tab, Component> tabPageMapping = new HashMap<>();
        tabPageMapping.put(home, homePage);
        tabPageMapping.put(planner,homePage);
        tabPageMapping.put(games,homePage);

        Tabs tabs = new Tabs(home,planner,games);
        addToNavbar(tabs);

        Set<Component> activePage = Stream.of(homePage).collect(Collectors.toSet());
        setContent(new Div(homePage));
        tabs.addSelectedChangeListener((trigger)->{
            activePage.forEach((page)->page.setVisible(false));
            activePage.clear();
            Component component = tabPageMapping.get(trigger.getSelectedTab());
            component.setVisible(true);
            activePage.add(component);
        });
    }
}
