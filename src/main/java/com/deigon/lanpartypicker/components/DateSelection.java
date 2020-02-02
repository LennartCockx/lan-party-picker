package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeTitle;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

public class DateSelection extends FullWidthDiv {


    private final DateGrid dateGrid;

    public DateSelection(HashMap<LocalDate, Set<String>> selectedDates) {
        add(new LargeTitle("Date Selection"));
        dateGrid = new DateGrid(selectedDates);

        add(dateGrid);
    }

    public DateGrid getDateGrid() {
        return dateGrid;
    }
}
