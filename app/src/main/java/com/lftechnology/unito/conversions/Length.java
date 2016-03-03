package com.lftechnology.unito.conversions;

import com.lftechnology.unito.constant.LengthConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/1/16.
 */
public class Length {
    private String to, from;
    private Double value;

    public Length (Double val, String to, String from) {
        value = val;
        this.to = to;
        this.from = from;
    }

    private Double getConstant(String from, String to) {
        Double constant = 0.0;
        switch (to) {
            case LengthConstant.NAUTICAL_MILE:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 1.0;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 1.852;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 185200.0;
                        break;
                    case LengthConstant.YARD:
                        constant = 2025.3718285214347;
                        break;
                    case  LengthConstant.INCH:
                        constant = 72913.38582677166;
                        break;
                    case LengthConstant.FEET:
                        constant = 6076.115485564304;
                        break;
                    case LengthConstant.METER:
                        constant = 1852.0;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 1852000.0;
                        break;
                    case LengthConstant.MILE:
                        constant = 1.1507794480235425;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 1852000000.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 1852000000000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 1852000000.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case LengthConstant.KILOMETER:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.5399568034557235;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 1.0;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 100000.0;
                        break;
                    case LengthConstant.YARD:
                        constant = 1093.6132983377079;
                        break;
                    case  LengthConstant.INCH:
                        constant = 39370.07874015748;
                        break;
                    case LengthConstant.FEET:
                        constant = 3280.839895013123;
                        break;
                    case LengthConstant.METER:
                        constant = 1000.0;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 1000000.0;
                        break;
                    case LengthConstant.MILE:
                        constant = 0.621371192237334;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 1000000000.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 1000000000000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 1000000000.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case LengthConstant.CENTIMETER:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.000005399568034557236;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 0.00001;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 1.0;
                        break;
                    case LengthConstant.YARD:
                        constant = 0.010936132983377077;
                        break;
                    case  LengthConstant.INCH:
                        constant = 0.3937007874015748;
                        break;
                    case LengthConstant.FEET:
                        constant = 0.03280839895013123;
                        break;
                    case LengthConstant.METER:
                        constant = 0.01;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 10.0;
                        break;
                    case LengthConstant.MILE:
                        constant = 0.00000621371192237334;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 10000.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 10000000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 10000.0;
                        break;
                    default:
                        break;
                }
                break;
            case LengthConstant.YARD:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.0004937365010799136;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 0.0009144;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 91.44;
                        break;
                    case LengthConstant.YARD:
                        constant = 1.0;
                        break;
                    case  LengthConstant.INCH:
                        constant = 36.0;
                        break;
                    case LengthConstant.FEET:
                        constant = 3.0;
                        break;
                    case LengthConstant.METER:
                        constant = 0.9144;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 914.4;
                        break;
                    case LengthConstant.MILE:
                        constant = 0.0005681818181818182;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 914400.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 914400000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 914400.0;
                        break;
                    default:
                        break;
                }
                break;
            case  LengthConstant.INCH:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.000013714902807775378;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 0.0000254;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 2.54;
                        break;
                    case LengthConstant.YARD:
                        constant = 0.027777777777777776;
                        break;
                    case  LengthConstant.INCH:
                        constant = 1.0;
                        break;
                    case LengthConstant.FEET:
                        constant = 0.08333333333333333;
                        break;
                    case LengthConstant.METER:
                        constant = 0.0254;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 25.4;
                        break;
                    case LengthConstant.MILE:
                        constant = 0.000015782828282828283;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 25400.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 25400000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 25400.0;
                        break;
                    default:
                        break;
                }
                break;
            case LengthConstant.FEET:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.00016457883369330455;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 0.0003048;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 30.48;
                        break;
                    case LengthConstant.YARD:
                        constant = 0.3333333333333333;
                        break;
                    case  LengthConstant.INCH:
                        constant = 12.0;
                        break;
                    case LengthConstant.FEET:
                        constant = 1.0;
                        break;
                    case LengthConstant.METER:
                        constant = 0.3048;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 304.8;
                        break;
                    case LengthConstant.MILE:
                        constant = 0.0001893939393939394;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 304800.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 304800000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 304800.0;
                        break;
                    default:
                        break;
                }
                break;
            case LengthConstant.METER:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.0005399568034557236;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 0.001;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 100.0;
                        break;
                    case LengthConstant.YARD:
                        constant = 1.0936132983377078;
                        break;
                    case  LengthConstant.INCH:
                        constant = 39.37007874015748;
                        break;
                    case LengthConstant.FEET:
                        constant = 3.2808398950131235;
                        break;
                    case LengthConstant.METER:
                        constant = 1.0;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 1000.0;
                        break;
                    case LengthConstant.MILE:
                        constant = 0.0006213711922373339;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 1000000.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 1000000000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 1000000.0;
                        break;
                    default:
                        break;
                }
                break;
            case LengthConstant.MILLIMETER:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.0000005399568;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 0.000001;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 0.1;
                        break;
                    case LengthConstant.YARD:
                        constant = 0.0010936132983377078;
                        break;
                    case  LengthConstant.INCH:
                        constant = 0.03937007874015748;
                        break;
                    case LengthConstant.FEET:
                        constant = 0.0032808398950131233;
                        break;
                    case LengthConstant.METER:
                        constant = 0.001;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 1.0;
                        break;
                    case LengthConstant.MILE:
                        constant = 0.0000006213712;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 1000.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 1000000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 1000.0;
                        break;
                    default:
                        break;
                }
                break;
            case LengthConstant.MILE:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.8689762419006479;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 1.609344;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 160934.4;
                        break;
                    case LengthConstant.YARD:
                        constant = 1760.0;
                        break;
                    case  LengthConstant.INCH:
                        constant = 63360.0;
                        break;
                    case LengthConstant.FEET:
                        constant = 5280.0;
                        break;
                    case LengthConstant.METER:
                        constant = 1609.344;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 1609344.0;
                        break;
                    case LengthConstant.MILE:
                        constant = 1.0;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 1609344000.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 1609344000000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 1609344000.0;
                        break;
                    default:
                        break;
                }
                break;
            case LengthConstant.MICROMETER:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.0000000005399568;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 1E9;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 0.0001;
                        break;
                    case LengthConstant.YARD:
                        constant = 0.0000010936132983377078;
                        break;
                    case  LengthConstant.INCH:
                        constant = 0.00003937007874015748;
                        break;
                    case LengthConstant.FEET:
                        constant = 0.0000032808398950131235;
                        break;
                    case LengthConstant.METER:
                        constant = 0.000001;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 0.001;
                        break;
                    case LengthConstant.MILE:
                        constant = 6.21371192237334E10;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 1.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 1000.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 1.0;
                        break;
                    default:
                        break;
                }
                break;
            case  LengthConstant.NANOMETER:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.0000000000005399568;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 1E12;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 0.0000001;
                        break;
                    case LengthConstant.YARD:
                        constant = 0.0000000010936132983377078;
                        break;
                    case  LengthConstant.INCH:
                        constant = 0.00000003937007874015748;
                        break;
                    case LengthConstant.FEET:
                        constant = 0.0000000032808398950131235;
                        break;
                    case LengthConstant.METER:
                        constant = 0.000000001;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 0.000001;
                        break;
                    case LengthConstant.MILE:
                        constant = 6.21371192237334E13;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 0.001;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 1.0;
                        break;
                    case LengthConstant.MICRON:
                        constant = 0.001;
                        break;
                    default:
                        break;
                }
                break;
            case LengthConstant.MICRON:
                switch (from) {
                    case LengthConstant.NAUTICAL_MILE:
                        constant = 0.0000000005399568;
                        break;
                    case LengthConstant.KILOMETER:
                        constant = 1E9;
                        break;
                    case LengthConstant.CENTIMETER:
                        constant = 0.0001;
                        break;
                    case LengthConstant.YARD:
                        constant = 0.0000010936132983377078;
                        break;
                    case  LengthConstant.INCH:
                        constant = 0.00003937007874015748;
                        break;
                    case LengthConstant.FEET:
                        constant = 0.0000032808398950131235;
                        break;
                    case LengthConstant.METER:
                        constant = 0.000001;
                        break;
                    case LengthConstant.MILLIMETER:
                        constant = 0.001;
                        break;
                    case LengthConstant.MILE:
                        constant = 6.21371192237334E10;
                        break;
                    case LengthConstant.MICROMETER:
                        constant = 1.0;
                        break;
                    case  LengthConstant.NANOMETER:
                        constant = 1000.0;
                        break;
                    case LengthConstant.MICRON:
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

    public double convert() {
        Double constant = getConstant(from, to);
        return value * constant;
    }


}
