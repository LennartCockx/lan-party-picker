package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeTitle;
import com.deigon.lanpartypicker.domain.LanPartyUser;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

public class DateSelection extends FullWidthDiv {


    private final DateGrid dateGrid;

    public DateSelection(HashMap<LocalDate, Set<User>> selectedDates) {
        add(new LargeTitle("Date Selection"));
        dateGrid = new DateGrid(selectedDates);

        add(dateGrid);
    }

    public DateGrid getDateGrid() {
        return dateGrid;
    }
}
