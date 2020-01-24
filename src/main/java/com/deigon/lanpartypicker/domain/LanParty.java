package com.deigon.lanpartypicker.domain;

import com.vaadin.flow.component.html.Image;

import java.time.LocalDate;
import java.util.UUID;

public class LanParty {

    private UUID uuid;
    private String name;
    private LocalDate date;
    private Image image;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Image getImage() {
        if (this.image == null){
            Image defaultImage = new Image("icons/lan-party-logo.png", "LanParty Logo");
            defaultImage.setWidth("66px");
            defaultImage.setHeight("66px");
            return defaultImage;
        }
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Image getImageSmall() {
        Image image = getImage();
        image.setSizeUndefined();
        image.setHeight("44px");
        return image;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}