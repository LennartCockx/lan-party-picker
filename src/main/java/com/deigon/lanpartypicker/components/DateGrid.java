package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.time.LocalDate;

public class DateGrid extends FullWidthDiv {
    public DateGrid() {
        LocalDate now = LocalDate.now();
        VerticalLayout verticalLayout = new VerticalLayout();
        for (int i = 0; i < 4; i++) {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            for (int j = 0; j < 7; j++) {
                horizontalLayout.addAndExpand(new DayBlock(now.plusDays(j+7*i)) );
            }
            verticalLayout.add(horizontalLayout);
        }
        add(verticalLayout);
    }
}
