package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.events.DateAddedEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DateGrid extends FullWidthDiv {

    public DateGrid(HashMap<LocalDate, Set<User>> selectedDates) {
        LocalDate now = LocalDate.now();
        VerticalLayout verticalLayout = new VerticalLayout();
        for (int i = 0; i < 4; i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            for (int j = 0; j < 7; j++) {

                LocalDate date = now.plusDays(j + 7 * i);
                Set<User> lanPartyUsers = selectedDates.get(date);
                if (lanPartyUsers==null){
                    lanPartyUsers = new HashSet<>();
                }

                DayBlock dayBlock = new DayBlock(date, lanPartyUsers.stream().map(User::getUsername).collect(Collectors.toList()));
                dayBlock.addClickListener((event -> fireEvent(new DateAddedEvent(dayBlock, false))));
                horizontalLayout.addAndExpand(dayBlock);
            }
            verticalLayout.add(horizontalLayout);
        }
        add(verticalLayout);

    }
    public Registration addDateAddedListener(ComponentEventListener<DateAddedEvent> listener) {
        return addListener(DateAddedEvent.class, listener);
    }
}
