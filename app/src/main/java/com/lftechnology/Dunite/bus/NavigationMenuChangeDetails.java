package com.lftechnology.Dunite.bus;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/23/16.
 */
public class NavigationMenuChangeDetails {
    private String selectedConversion;

    public NavigationMenuChangeDetails(String selectedConversion) {
        this.selectedConversion = selectedConversion;
    }

    public String getSelectedConversion() {
        return selectedConversion;
    }
}
