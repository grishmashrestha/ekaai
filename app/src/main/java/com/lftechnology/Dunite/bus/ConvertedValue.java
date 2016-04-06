package com.lftechnology.Dunite.bus;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/2/16.
 */

/**
 * Is used to pass message from top fragment to bottom fragment for unit conversion, via an EventBus
 */
public class ConvertedValue {
    private String  value, from, selectedConversion;
    private int position;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSelectedConversion() {
        return selectedConversion;
    }

    public void setSelectedConversion(String selectedConversion) {
        this.selectedConversion = selectedConversion;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ConvertedValue(String value, String from, int position, String selectedConversion) {
        this.value = value;
        this.from = from;
        this.position = position;
        this .selectedConversion = selectedConversion;
    }
}
