package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeTitle;
import com.github.appreciated.card.RippleClickableCard;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayBlock extends FullWidthDiv {
    private boolean selected;

    public DayBlock(LocalDate localDate) {
        LargeTitle day = new LargeTitle(Integer.toString(localDate.getDayOfMonth()));
        SmallText month = new SmallText(localDate.format(DateTimeFormatter.ofPattern("MMM")));
        FullWidthDiv fullWidthDiv = new FullWidthDiv(day, month);
        fullWidthDiv.addClickListener((event -> this.toggleSelected()));
        setClassName("ripple");
        add(fullWidthDiv);
    }

    private void toggleSelected() {
        this.selected = !this.selected;
        if (selected){
            this.getStyle().set("background-color","gray");
            this.getStyle().set("color","white");
        } else {
            this.getStyle().remove("background-color");
            this.getStyle().set("color", "black");
        }
    }
}
