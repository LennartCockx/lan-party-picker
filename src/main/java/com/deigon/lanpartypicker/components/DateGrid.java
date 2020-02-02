package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.events.DateAddedEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DateGrid extends FullWidthDiv {

    public DateGrid(HashMap<LocalDate, Set<String>> selectedDates) {
        LocalDate now = LocalDate.now();
        VerticalLayout verticalLayout = new VerticalLayout();
        for (int i = 0; i < 4; i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            for (int j = 0; j < 7; j++) {

                LocalDate date = now.plusDays(j + 7 * i);
                Set<String> lanPartyUsers = selectedDates.get(date);
                if (lanPartyUsers==null){
                    lanPartyUsers = new HashSet<>();
                }

                DayBlock dayBlock = new DayBlock(date, lanPartyUsers);
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
