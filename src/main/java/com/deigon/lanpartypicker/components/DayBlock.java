package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeTitle;
import com.deigon.lanpartypicker.events.DateAddedEvent;
import com.github.appreciated.card.RippleClickableCard;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class DayBlock extends FullWidthDiv {
    private boolean selected;
    private LocalDate day;
    private VerticalLayout verticalLayout;

    public DayBlock(LocalDate localDate, List<String> chosen) {
        this.day = localDate;
        LargeTitle day = new LargeTitle(Integer.toString(localDate.getDayOfMonth()));
        SmallText month = new SmallText(localDate.format(DateTimeFormatter.ofPattern("MMM")));
        verticalLayout = new VerticalLayout();
        chosen.forEach((person)-> verticalLayout.add(new UserCharm(person)));

        add(day, month, verticalLayout);
        addClickListener((event -> this.toggleSelected()));
        setClassName("ripple hover");
    }

    public void updateChosen(List<String> chosen){
        remove(verticalLayout);
        verticalLayout = new VerticalLayout();
        chosen.forEach((person)-> verticalLayout.add(new UserCharm(person)));
        add(verticalLayout);
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
