package com.deigon.lanpartypicker;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Route("")
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
public class IndexView extends AppLayout {

    public IndexView() {
        Image img = new Image("icons/lan-party-logo.png", "LanParty Logo");
        img.setHeight("44px");
        addToNavbar(img);

        Tab home = new Tab("Upcoming");
        LanParty sampleParty1 = new LanParty();
        sampleParty1.setName("Old Year Mini-LAN");
        sampleParty1.setDescription("Three people, Three games. A short LAN Party to end 2019");
        LanParty sampleParty2 = new LanParty();
        sampleParty2.setName("I-Got-A-New-Gaming-PC LAN");
        sampleParty2.setDescription("Time to play some games with this beast. Februari 2020");
        List<LanParty> lanParties = List.of(sampleParty1, sampleParty2);

        Component homePage = new LanPartiesOverview(lanParties);

        Tab about = new Tab("About");
        Div aboutPage = new Div();
        aboutPage.add(new Button("placeholder"));
        aboutPage.setVisible(false);

        Tab profile = new Tab("Profile");
        Div profilePage = new Div();
        profilePage.add(new Button("placeholder"));
        profilePage.setVisible(false);

        HashMap<Tab, Component> tabPageMapping = new HashMap<>();
        tabPageMapping.put(home,homePage);
        tabPageMapping.put(profile,profilePage);
        tabPageMapping.put(about,aboutPage);

        Tabs tabs = new Tabs(home, profile, about);
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        addToNavbar(tabs);

        Set<Component> activePage = Stream.of(homePage)
                .collect(Collectors.toSet());

        setContent(new Div(homePage,profilePage, aboutPage));

        tabs.addSelectedChangeListener((event)->{
            activePage.forEach((page)->page.setVisible(false));
            activePage.clear();
            Component component = tabPageMapping.get(event.getSelectedTab());
            component.setVisible(true);
            activePage.add(component);
        });
    }
}
