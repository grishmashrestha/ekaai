package com.lftechnology.ekaai.conversions;

/**
 * An abstract class to represent basic conversion systems where units may or may be proportionally related to each other
 */
public abstract class Unit {
    private String to;
    private String from;
    private String referenceUnit;
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

    public String getReferenceUnit() {
        return referenceUnit;
    }

    public void setReferenceUnit(String referenceUnit) {
        this.referenceUnit = referenceUnit;
    }

    public abstract Double convert();
}
