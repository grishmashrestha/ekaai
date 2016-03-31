package com.lftechnology.unito.conversions;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/31/16.
 */
public abstract class Unit {
    private String to, from;
    private Double value;

    public Unit(Double val, String from, String to) {
        this.value = val;
        this.from = from;
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public Double getValue() {
        return value;
    }

    public abstract Double convert();
}
