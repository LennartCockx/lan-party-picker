package com.deigon.lanpartypicker;

import com.deigon.lanpartypicker.components.DayBlock;
import com.deigon.lanpartypicker.components.LanPartyDetailOverview;
import com.deigon.lanpartypicker.domain.LanParty;
import com.deigon.lanpartypicker.domain.LanPartyUser;
import com.deigon.lanpartypicker.repositories.LanPartyRepository;
import com.deigon.lanpartypicker.repositories.UserRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

@Route(value = "lanParty", layout = MainView.class)
public class LanPartyDetailView extends VerticalLayout implements HasUrlParameter<String> {

    private LanParty lanParty = new LanParty();
    private LanPartyRepository repository;

    private LanPartyDetailOverview lanPartyDetailOverview;

    public LanPartyDetailView(LanPartyRepository repository) {
        this.repository = repository;
        setClassName("mainContent");
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
        Component homePage = lanPartyDetailOverview;
        add(homePage);

        lanPartyDetailOverview.getDateSelection().getDateGrid().addDateAddedListener((dateAdded)->{
            DayBlock source = (DayBlock) dateAdded.getSource();
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (source.isSelected()){
                lanParty.addUserForDate(source.getDay(), (LanPartyUser) principal);
            } else {
                lanParty.removeUserForDate(source.getDay(), (LanPartyUser) principal);
            }
            source.updateChosen(lanParty.getNamesForDate(source.getDay()));
        });
    }
}
