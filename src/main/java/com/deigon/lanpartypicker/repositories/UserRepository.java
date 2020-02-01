package com.deigon.lanpartypicker.repositories;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository() {
        List<SimpleGrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority("USER"));
        User lennart_cockx = new User("Lennart Cockx","password", grantedAuthorities);
        User tim_clinckemalie = new User("Tim Clinckemalie","password", grantedAuthorities);
        User thomas_meyers = new User("Thomas Meyers","password", grantedAuthorities);

        this.users =  List.of(lennart_cockx, tim_clinckemalie, thomas_meyers);
    }

    public List<User> getAllUsers(){
        return this.users;
    }

    public User getUserByName(String name) {
        for (User user : this.users) {
            if (user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }
}
