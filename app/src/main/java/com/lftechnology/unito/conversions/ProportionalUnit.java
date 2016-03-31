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

    public Double getConstant(String from, String to) {
        Double constant;
        if (from.equals(to)) {
            constant = 1.0;
        } else {
            Double constantInTermsOfReferenceUnit = calculateConstant(from, getReferenceUnit());
            Double constantInTermsOfFinalUnit = calculateConstant(getReferenceUnit(), to);
            constant = constantInTermsOfReferenceUnit * constantInTermsOfFinalUnit;
        }
        return constant;
    }

    public abstract Double calculateConstant(String from, String to);


}
