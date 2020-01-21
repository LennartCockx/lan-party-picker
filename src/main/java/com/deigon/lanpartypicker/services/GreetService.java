package com.deigon.lanpartypicker.services;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello anonymous user";
        } else {
            return "Hello " + name;
        }
    }

}
