package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeTitle;
import com.deigon.lanpartypicker.events.DateAddedEvent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DayBlock extends FullWidthDiv {
    private final HorizontalLayout horizontalLayout;
    private boolean selected;
    private LocalDate day;
    private VerticalLayout verticalLayout;

    public DayBlock(LocalDate localDate, List<String> chosen) {
        this.day = localDate;
        LargeTitle day = new LargeTitle(Integer.toString(localDate.getDayOfMonth()));
        verticalLayout = new VerticalLayout();
        chosen.forEach((person)-> verticalLayout.add(new UserCharm(person)));
        SmallText month = new SmallText(localDate.format(DateTimeFormatter.ofPattern("MMM")));

        horizontalLayout = new HorizontalLayout(day, verticalLayout);

        add(horizontalLayout, month);
        addClickListener((event -> this.toggleSelected()));
        setClassName("ripple hover");
    }

    public void updateChosen(List<String> chosen){
        horizontalLayout.remove(verticalLayout);
        verticalLayout = new VerticalLayout();
        chosen.forEach((person)-> verticalLayout.add(new UserCharm(person)));
        horizontalLayout.add(verticalLayout);
    }

    private void toggleSelected() {
        this.selected = !this.selected;
        if (selected){
            fireEvent(new DateAddedEvent(this,true));
            this.getStyle().set("background-color","gray");
            this.getStyle().set("color","white");
        } else {
            this.getStyle().remove("background-color");
            this.getStyle().set("color", "black");
        }
    }

    public LocalDate getDay() {
        return day;
    }

    public boolean isSelected() {
        return selected;
    }
}
