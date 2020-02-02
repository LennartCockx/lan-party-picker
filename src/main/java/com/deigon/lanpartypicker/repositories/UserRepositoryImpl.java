package com.deigon.lanpartypicker.repositories;

import com.deigon.lanpartypicker.domain.LanPartyUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<LanPartyUser> users;

    public UserRepositoryImpl() {
        List<SimpleGrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("USER"));
        LanPartyUser lennart_cockx = new LanPartyUser("Lennart Cockx","lennart","password", grantedAuthorities);
        LanPartyUser tim_clinckemalie = new LanPartyUser("Tim Clinckemalie","tim","password", grantedAuthorities);
        LanPartyUser thomas_meyers = new LanPartyUser("Thomas Meyers","thomas","password", grantedAuthorities);

        this.users =  List.of(lennart_cockx, tim_clinckemalie, thomas_meyers);
    }

    @Override
    public LanPartyUser getById(UUID id) {
        return null;
    }

    @Override
    public LanPartyUser getByUsername(String username) {
        for (LanPartyUser user : this.users) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}