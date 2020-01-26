package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;

public class UserCharm extends FullWidthDiv {
    public UserCharm(String person) {
        String[] s = person.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String firstLetter : s) {
            initials.append(firstLetter.charAt(0));
        }
        setText(initials.toString().toUpperCase());
    }
}
