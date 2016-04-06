package com.lftechnology.Dunite.bus;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/14/16.
 */
public class PageScrollPosition {
    private int position;
    private String selectedConversion;

    public PageScrollPosition(int pos, String selectedConversion) {
        this.position = pos;
        this.selectedConversion = selectedConversion;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSelectedConversion() {
        return selectedConversion;
    }

    public void setSelectedConversion(String selectedConversion) {
        this.selectedConversion = selectedConversion;
    }
}