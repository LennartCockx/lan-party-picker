package com.deigon.lanpartypicker.domain;

import com.vaadin.flow.component.html.Image;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class LanParty {

    private UUID uuid;
    private String name;
    private LocalDate date;
    private Image image;
    private String description;
    private HashMap<LocalDate, Set<LanPartyUser>> usersAvailableForDate = new HashMap<>();

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

    public void addUserForDate(LocalDate day, LanPartyUser lanPartyUser) {
        if (usersAvailableForDate.containsKey(day)){
            usersAvailableForDate.get(day).add(lanPartyUser);
        } else {
            HashSet<LanPartyUser> users = new HashSet<>();
            users.add(lanPartyUser);
            usersAvailableForDate.put(day, users);
        }
    }

    public void removeUserForDate(LocalDate day, LanPartyUser user) {
        if (usersAvailableForDate.containsKey(day)){
            usersAvailableForDate.get(day).remove(user);
            if (usersAvailableForDate.get(day).isEmpty()){
                usersAvailableForDate.remove(day);
            }
        }
    }

    public HashMap<LocalDate, Set<LanPartyUser>> getUsersAvailableForDate() {
        return usersAvailableForDate;
    }

    public List<String> getNamesForDate(LocalDate day) {
        Set<LanPartyUser> lanPartyUsers = usersAvailableForDate.get(day);
        if (lanPartyUsers ==null){
            lanPartyUsers = new HashSet<>();
        }

        return lanPartyUsers.stream().map(LanPartyUser::getName).collect(Collectors.toList());
    }
}
