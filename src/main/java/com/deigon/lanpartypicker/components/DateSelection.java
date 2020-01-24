package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeCenteredTitle;
import com.deigon.lanpartypicker.components.base.LargeTitle;
import com.deigon.lanpartypicker.components.base.MainContainer;
import com.vaadin.flow.component.datepicker.DatePicker;

public class DateSelection extends FullWidthDiv {
    public DateSelection() {
        add(new LargeTitle("Date Selection"));
        add(new MainContainer(new DateGrid()));
    }
}
