package com.deigon.lanpartypicker.domain;

import com.vaadin.flow.component.html.Image;

import java.time.LocalDate;
import java.util.UUID;

public class LanPartyBuilder {

    private LanParty lanParty;

    public LanPartyBuilder(LanParty lanParty) {
        this.lanParty = lanParty;
    }

    public static LanPartyBuilder createLanParty(){
        LanParty lanParty = new LanParty();
        lanParty.setName("Default");
        lanParty.setDescription("Default Description");
        lanParty.setUuid(UUID.randomUUID());
        return new LanPartyBuilder(lanParty);
    }

    public LanPartyBuilder withName(String name){
        this.lanParty.setName(name);
        return this;
    }

    public LanPartyBuilder withDescription(String description){
        this.lanParty.setDescription(description);
        return this;
    }

    public LanPartyBuilder withDate(LocalDate date){
        this.lanParty.setDate(date);
        return this;
    }

    public LanPartyBuilder withImage(Image image){
        this.lanParty.setImage(image);
        return this;
    }

    public LanPartyBuilder withUuid(UUID uuid){
        this.lanParty.setUuid(uuid);
        return this;
    }

    public LanParty build(){
        return this.lanParty;
    }
}
