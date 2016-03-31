package com.lftechnology.unito.conversions;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/31/16.
 */
public abstract class ProportionalUnit extends Unit {

    public ProportionalUnit(Double val, String from, String to) {
        super(val, from, to);
    }

    @Override
    public Double convert() {
        Double constant = getConstant(getFrom(), getTo());
        return getValue() * constant;
    }

    public abstract Double getConstant(String from, String to);

}
