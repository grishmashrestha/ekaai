package com.lftechnology.ekaai.conversions;

import com.lftechnology.ekaai.constant.AppConstant;

/**
 * Model representation for Temperature conversion system
 * An extension of {@link Unit} and not a {@link ProportionalUnit} as the units are not related to each other proportionally
 */
public class Temperature extends Unit {

    public Temperature(Double val, String from, String to) {
        super(val, from, to);
        setReferenceUnit(AppConstant.TemperatureConstant.CELSIUS);
    }

    @Override
    public Double convert() {
        Double value = getValue();
        String from = getFrom();
        String to = getTo();

        if (from.equals(to)) {
            return value;
        } else {
            Double inTermsOfReferenceUnit = convertToAnotherUnit(from, getReferenceUnit(), value);
            return convertToAnotherUnit(getReferenceUnit(), to, inTermsOfReferenceUnit);
        }
    }

    public Double convertToAnotherUnit(String from, String to, Double value) {
        Double returnValue;
        switch (from) {
            case AppConstant.TemperatureConstant.CELSIUS:
                switch (to) {
                    case AppConstant.TemperatureConstant.CELSIUS:
                        returnValue = value;
                        break;
                    case AppConstant.TemperatureConstant.FAHRENHEIT:
                        returnValue = (((value * 9) / 5) + 32);
                        break;
                    case AppConstant.TemperatureConstant.KELVIN:
                        returnValue = value + 273.15;
                        break;
                    default:
                        returnValue = 0.0;
                }
                break;
            case AppConstant.TemperatureConstant.FAHRENHEIT:
                switch (to) {
                    case AppConstant.TemperatureConstant.CELSIUS:
                        returnValue = ((value - 32) * 5 / 9);
                        break;
                    default:
                        returnValue = 0.0;
                }
                break;
            case AppConstant.TemperatureConstant.KELVIN:
                switch (to) {
                    case AppConstant.TemperatureConstant.CELSIUS:
                        returnValue = (value - 273.15);
                        break;
                    default:
                        returnValue = 0.0;
                }
                break;
            default:
                returnValue = 0.0;
                break;
        }
        return returnValue;
    }
}
