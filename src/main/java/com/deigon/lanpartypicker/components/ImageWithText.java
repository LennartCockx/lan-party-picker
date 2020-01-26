package com.deigon.lanpartypicker.components;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ImageWithText extends HorizontalLayout {
    public ImageWithText(Image image, String name, String description) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setWidthFull();
        verticalLayout.add(new SmallText(name),new SmallText(description));

        setFlexGrow(1,image);
        verticalLayout.setFlexGrow(9,verticalLayout);

        add(image,verticalLayout);
    }
}
