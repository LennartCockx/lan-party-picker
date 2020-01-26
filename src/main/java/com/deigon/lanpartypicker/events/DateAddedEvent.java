package com.deigon.lanpartypicker.events;

import com.deigon.lanpartypicker.components.DayBlock;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;

import java.time.LocalDate;

public class DateAddedEvent extends ComponentEvent<Component> {
    public DateAddedEvent(Component day, boolean fromClient) {
        super(day, fromClient);
    }
}
