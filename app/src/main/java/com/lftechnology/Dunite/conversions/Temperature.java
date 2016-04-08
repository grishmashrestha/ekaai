package com.lftechnology.Dunite.conversions;

import com.lftechnology.Dunite.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/1/16.
 */
public class Temperature extends Unit {

    public Temperature(Double val, String from, String to) {
        super(val, from, to);
        setReferenceUnit(AppConstant.TemperatureConstant.CELSIUS);
    }

    @Override
    public Double convert() {
        Double returnValue;
        Double value = getValue();
        String from = getFrom();
        String to = getTo();

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
