package com.lftechnology.unito.conversions;

import com.lftechnology.unito.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/1/16.
 */
public class Weight extends ProportionalUnit {
    public Weight(Double val, String from, String to) {
        super(val, from, to);
    }

    @Override
    public Double getConstant(String from, String to) {
        Double constant = 0.0;
        switch (from) {
            case AppConstant.WeightConstant.KILOGRAM:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 1.0;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 2.204622621849;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 0.001;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 1000.0;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 5000.0;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 1000000.0;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 15432.35835294;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 9.80665;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 35.27396194958;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.WeightConstant.POUND:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.45359237;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 1.0;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 0.00045359237;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 453.59237;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 2267.96185;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 453592.37;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 7000.0;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 4.44822161526;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 16.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.WeightConstant.TONNE:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 1000.0;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 2204.622621849;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 1.0;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 1000000.0;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 5000000.0;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 1000000000.0;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 15432358.35294;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 9806.65;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 35273.96194958;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.WeightConstant.GRAM:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.001;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 0.002204622621849;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 0.000001;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 1.0;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 5.0;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 1000.0;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 15.43235835294;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 0.00980665;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 0.03527396194958;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.WeightConstant.CARAT:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.0002;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 0.0004409245243698;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 2E-7;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 0.2;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 1.0;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 200.0;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 3.086471670588;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 0.00196133;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 0.007054792389916;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.WeightConstant.MILLIGRAM:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.000001;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 0.000002204622621849;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 1E-9;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 0.001;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 0.005;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 1.0;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 0.01543235835294;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 0.00000980665;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 0.00003527396194958;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.WeightConstant.GRAIN:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.00006479891;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 0.0001428571428571;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 6.479891E-8;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 0.06479891;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 0.32399455;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 64.79891;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 1.0;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 0.0006354602307515;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 0.002285714285714;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.WeightConstant.NEWTON:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.1019716212978;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 0.2248089430997;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 0.0001019716212978;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 101.9716212978;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 509.858106489;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 101971.6212978;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 1573.662601698;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 1.0;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 3.596943089595;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.WeightConstant.OUNCE:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.028349523125;
                        break;
                    case AppConstant.WeightConstant.POUND:
                        constant = 0.0625;
                        break;
                    case AppConstant.WeightConstant.TONNE:
                        constant = 0.000028349523125;
                        break;
                    case AppConstant.WeightConstant.GRAM:
                        constant = 28.349523125;
                        break;
                    case AppConstant.WeightConstant.CARAT:
                        constant = 141.747615625;
                        break;
                    case AppConstant.WeightConstant.MILLIGRAM:
                        constant = 28349.523125;
                        break;
                    case AppConstant.WeightConstant.GRAIN:
                        constant = 437.5;
                        break;
                    case AppConstant.WeightConstant.NEWTON:
                        constant = 0.2780138509538;
                        break;
                    case AppConstant.WeightConstant.OUNCE:
                        constant = 1.0;
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return constant;
    }
}
