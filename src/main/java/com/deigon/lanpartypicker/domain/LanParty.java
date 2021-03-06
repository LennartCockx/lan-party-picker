package com.deigon.lanpartypicker.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vaadin.flow.component.html.Image;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LanParty {

    private UUID uuid;
    private String name;
    private LocalDate date;
    private Image image;
    private String description;
    private HashMap<LocalDate, Set<String>> usersAvailableForDate = new HashMap<>();

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

    @JsonIgnore
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

    @JsonIgnore
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

    public void addUserForDate(LocalDate day, LanPartyUser lanPartyUser) {
        if (usersAvailableForDate.containsKey(day)){
            usersAvailableForDate.get(day).add(lanPartyUser.getFullname());
        } else {
            HashSet<String> users = new HashSet<>();
            users.add(lanPartyUser.getFullname());
            usersAvailableForDate.put(day, users);
        }
    }

    public void removeUserForDate(LocalDate day, LanPartyUser user) {
        if (usersAvailableForDate.containsKey(day)){
            usersAvailableForDate.get(day).remove(user.getFullname());
            if (usersAvailableForDate.get(day).isEmpty()){
                usersAvailableForDate.remove(day);
            }
        }
    }

    public HashMap<LocalDate, Set<String>> getUsersAvailableForDate() {
        return usersAvailableForDate;
    }

    @JsonIgnore
    public Set<String> getNamesForDate(LocalDate day) {
        Set<String> lanPartyUsers = usersAvailableForDate.get(day);
        if (lanPartyUsers ==null){
            lanPartyUsers = new HashSet<>();
        }

        return lanPartyUsers;
    }
}
