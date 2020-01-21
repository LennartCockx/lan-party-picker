package com.deigon.lanpartypicker.domain;

import com.vaadin.flow.component.html.Image;

import java.time.LocalDate;

public class LanParty {

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
}
