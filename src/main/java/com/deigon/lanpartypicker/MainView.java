package com.deigon.lanpartypicker;

import com.deigon.lanpartypicker.components.SmallText;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */

@PWA(name = "LanParty App Starter", shortName = "My Starter Project",
        backgroundColor = "#227aef", themeColor = "#227aef")
@CssImport(value = "styles/shared-styles.css")
@CssImport(value = "styles/vaadin-text-field-styles.css")
public class MainView extends AppLayout {

    private final Tabs menu;

    public MainView() {
        menu = new Tabs();
        menu.setOrientation(Tabs.Orientation.HORIZONTAL);
        menu.add(createTab(VaadinIcon.ABACUS, "Overview", IndexView.class));

        Image img = new Image("icons/lan-party-logo.png", "LanParty Logo");
        img.setHeight("44px");
        addToNavbar(new SmallText("LAN PARTY APP"));
        addToNavbar(menu);
    }

    private static Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        RouterLink a = new RouterLink(null, viewClass);
        a.add(icon.create());
        a.add(title);
        final Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(a);
        return tab;
    }

}
