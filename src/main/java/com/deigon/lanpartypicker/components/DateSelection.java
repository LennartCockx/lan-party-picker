package com.deigon.lanpartypicker.components;

import com.deigon.lanpartypicker.components.base.FullWidthDiv;
import com.deigon.lanpartypicker.components.base.LargeTitle;
import com.deigon.lanpartypicker.components.base.MainContainer;

public class DateSelection extends FullWidthDiv {
    public DateSelection() {
        add(new LargeTitle("Date Selection"));
        add(new MainContainer(new DateGrid()));
    }
}
