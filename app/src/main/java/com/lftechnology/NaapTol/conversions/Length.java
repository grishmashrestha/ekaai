package com.lftechnology.NaapTol.conversions;

import com.lftechnology.NaapTol.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/1/16.
 */
public class Length extends ProportionalUnit {

    public Length(Double val, String from, String to) {
        super(val, from, to);
        setReferenceUnit(AppConstant.LengthConstant.KILOMETER);
    }

    @Override
    public Double calculateConstant(String from, String to) {
        Double constant = 0.0;
        switch (from) {
            case AppConstant.LengthConstant.NAUTICAL_MILE:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 1.852;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.KILOMETER:
                switch (to) {
                    case AppConstant.LengthConstant.NAUTICAL_MILE:
                        constant = 0.5399568034557235;
                        break;
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 1.0;
                        break;
                    case AppConstant.LengthConstant.CENTIMETER:
                        constant = 100000.0;
                        break;
                    case AppConstant.LengthConstant.YARD:
                        constant = 1093.6132983377079;
                        break;
                    case AppConstant.LengthConstant.INCH:
                        constant = 39370.07874015748;
                        break;
                    case AppConstant.LengthConstant.FEET:
                        constant = 3280.839895013123;
                        break;
                    case AppConstant.LengthConstant.METER:
                        constant = 1000.0;
                        break;
                    case AppConstant.LengthConstant.MILLIMETER:
                        constant = 1000000.0;
                        break;
                    case AppConstant.LengthConstant.MILE:
                        constant = 0.621371192237334;
                        break;
                    case AppConstant.LengthConstant.NANOMETER:
                        constant = 1000000000000.0;
                        break;
                    case AppConstant.LengthConstant.MICRON:
                        constant = 1000000000.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.LengthConstant.CENTIMETER:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 0.00001;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.YARD:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 0.0009144;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.INCH:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 0.0000254;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.FEET:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 0.0003048;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.METER:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 0.001;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.MILLIMETER:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 0.000001;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.MILE:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 1.609344;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.NANOMETER:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 0.000000000001;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.LengthConstant.MICRON:
                switch (to) {
                    case AppConstant.LengthConstant.KILOMETER:
                        constant = 0.000000001;
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
