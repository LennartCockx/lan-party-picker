package com.deigon.lanpartypicker.repositories;

import com.deigon.lanpartypicker.domain.LanParty;
import com.deigon.lanpartypicker.domain.LanPartyBuilder;
import com.deigon.lanpartypicker.domain.LanPartyUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {

    private List<LanPartyUser> users;

    public UserRepository() {
        LanPartyUser lennart_cockx = new LanPartyUser("Lennart Cockx");
        LanPartyUser tim_clinckemalie = new LanPartyUser("Tim Clinckemalie");
        LanPartyUser thomas_meyers = new LanPartyUser("Thomas Meyers");

        this.users =  List.of(lennart_cockx, tim_clinckemalie, thomas_meyers);
    }

    public List<LanPartyUser> getAllUsers(){
        return this.users;
    }

    public LanPartyUser getUserByName(String name) {
        for (LanPartyUser user : this.users) {
            if (user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }
}
