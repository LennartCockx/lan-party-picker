package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeTitle;
import com.github.appreciated.card.RippleClickableCard;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayBlock extends FullWidthDiv {
    public DayBlock(LocalDate localDate) {
        LargeTitle day = new LargeTitle(Integer.toString(localDate.getDayOfMonth()));
        SmallText month = new SmallText(localDate.format(DateTimeFormatter.ofPattern("MMM")));
        RippleClickableCard rippleClickableCard = new RippleClickableCard(day, month);
        add(rippleClickableCard);
    }
}
