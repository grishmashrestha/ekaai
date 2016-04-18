package com.lftechnology.ekaai.conversions;

import com.lftechnology.ekaai.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/1/16.
 */
public class Weight extends ProportionalUnit {
    public Weight(Double val, String from, String to) {
        super(val, from, to);
        setReferenceUnit(AppConstant.WeightConstant.KILOGRAM);
    }

    @Override
    public Double calculateConstant(String from, String to) {
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
                    default:
                        break;
                }
                break;
            case AppConstant.WeightConstant.CARAT:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.0002;
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
                    default:
                        break;
                }
                break;
            case AppConstant.WeightConstant.OUNCE:
                switch (to) {
                    case AppConstant.WeightConstant.KILOGRAM:
                        constant = 0.028349523125;
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
