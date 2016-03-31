package com.lftechnology.unito.conversions;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/31/16.
 */
public abstract class Unit {
    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public Double getValue() {
        return value;
    }

    private String to, from;
    private Double value;

    public Unit(Double val, String from, String to) {
        this.value = val;
        this.from = from;
        this.to = to;
    }

    public double convert() {
        Double constant = getConstant(from, to);
        return value * constant;
    }

    public abstract Double getConstant(String from, String to);

}
