package com.lftechnology.ekaai.bus;

/**
 * A class to represent data involved when listening to page scroll while using {@link EventBus}
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