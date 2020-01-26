package com.deigon.lanpartypicker;

import com.deigon.lanpartypicker.components.DayBlock;
import com.deigon.lanpartypicker.components.LanPartyDetailOverview;
import com.deigon.lanpartypicker.components.base.MainContainer;
import com.deigon.lanpartypicker.domain.LanParty;
import com.deigon.lanpartypicker.domain.LanPartyUser;
import com.deigon.lanpartypicker.repositories.LanPartyRepository;
import com.deigon.lanpartypicker.repositories.UserRepository;
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
    private UserRepository userRepository;

    private LanPartyDetailOverview lanPartyDetailOverview;

    public LanPartyDetailView(LanPartyRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {

        UUID uuid = UUID.fromString(parameter);
        lanParty = repository.getLanPartyByUUID(uuid);
        lanPartyDetailOverview = new LanPartyDetailOverview(lanParty);
        Image imageSmall = lanParty.getImageSmall();
        HorizontalLayout layout = new HorizontalLayout(imageSmall);
        layout.getStyle().set("cursor","pointer");
        layout.addClickListener((action -> this.getUI().ifPresent((screen)->screen.navigate(""))));
        addToNavbar(layout);
        Tab home = new Tab("Overview");
        Component homePage = new MainContainer(lanPartyDetailOverview);
        Tab dates = new Tab("Date Selection");
        Tab games = new Tab("Game Selection");

        HashMap<Tab, Component> tabPageMapping = new HashMap<>();
        tabPageMapping.put(home, homePage);
        tabPageMapping.put(dates,homePage);
        tabPageMapping.put(games,homePage);

        Tabs tabs = new Tabs(home,dates,games);
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

        lanPartyDetailOverview.getDateSelection().getDateGrid().addDateAddedListener((dateAdded)->{
            DayBlock source = (DayBlock) dateAdded.getSource();
            if (source.isSelected()){
                lanParty.addUserForDate(source.getDay(), userRepository.getUserByName("Lennart Cockx"));
                source.updateChosen(lanParty.getNamesForDate(source.getDay()));
            } else {
                lanParty.removeUserForDate(source.getDay(), userRepository.getUserByName("Lennart Cockx"));
                source.updateChosen(lanParty.getNamesForDate(source.getDay()));
            }
        });
    }
}
