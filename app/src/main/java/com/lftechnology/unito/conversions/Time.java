package com.lftechnology.unito.conversions;

import com.lftechnology.unito.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/1/16.
 */
public class Time {
    private String to, from;
    private Double value;

    public Time(Double val, String from, String to) {
        value = val;
        this.to = to;
        this.from = from;
    }

    private Double getConstant(String from, String to) {
        Double constant = 0.0;
        switch (from) {
            case AppConstant.TimeConstant.SECOND:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 0.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 0.016666667;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 0.000277778;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 0.000011574;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 1.6534E-6;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 3.80265E-7;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 3.16888E-8;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 3.1688E-9;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 3.1688E-10;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 3.1688E-11;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 1000.0;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 1E6;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 1E9;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MINUTE:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 60.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 0.01666666666667;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 0.0006944444444444;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 0.00009920634920635;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 0.00002281522398251;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 0.000001902587519026;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 1.902587519026E-7;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 1.902587519026E-8;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 1.902587519026E-9;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 60000.0;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 60000000.0;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 60000000000.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.HOUR:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 3600.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 60.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 0.0416667;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 0.00595238;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 0.00136895;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 0.00011408;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 1.1408E-5;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 1.1408E-6;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 1.1408E-7;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 3600000.0;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 3.6E9;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 3.6E12;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.DAY:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 86400.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 1440.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 24.0;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 0.142857143;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 0.032876712;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 0.002739726;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 0.000273973;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 0.000027397;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 0.00000274;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 86400000.0;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 8.6E10;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 8.6E13;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.WEEK:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 604800.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 10080.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 168.0;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 7.0;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 0.230136986;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 0.019178082;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 0.001917808;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 0.000191781;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 0.000019178;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 604800000.0;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 6.048E11;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 6.048E14;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MONTH:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 2628000.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 43800.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 730.0;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 30.41667;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 4.3452;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 0.0833;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 0.008333;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 0.0008333;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 0.0000833;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 2628000000.0;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 2.628E12;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 2.628E15;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.YEAR:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 31536000.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 525600.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 8760.0;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 365.0;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 52.14285;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 12.0;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 0.1;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 0.01;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 0.001;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 3.1536E10;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 3.1536E13;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 3.1536E16;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.DECADE:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 315360000.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 5256000.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 87600.0;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 3650.0;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 521.428571;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 120.0;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 10.0;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 0.1;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 0.01;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 3.1536E11;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 3.1536E14;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 3.1536E17;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.CENTURY:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 3153600000.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 52560000.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 876000.0;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 36500.0;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 5214.28571;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 1200.0;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 100.0;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 10.0;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 0.1;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 3.1536E12;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 3.1536E15;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 3.1536E18;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MILLENNIUM:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 3.1536E10;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 525600000.0;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 8760000.0;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 365000.0;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 52142.85714;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 12000.0;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 1000.0;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 100.0;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 10.0;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 3.1536E13;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 3.1536E16;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 3.1536E19;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MILLISECOND:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 0.001;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 1.6667E-5;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 2.777E-7;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.15741E-8;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 1.65344E-9;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 3.80265E-10;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 3.1688E-11;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 3.1688E-12;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 3.1688E-13;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 3.1688E-14;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 1000.0;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 1000000.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MICROSECOND:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 1000000.0;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 1.6667E-8;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 2.7777E-10;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.15741E-11;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 1.65344E-12;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 3.80265E-13;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 3.1688E-14;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 3.1688E-15;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 3.1688E-16;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 3.1688E-17;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 0.001;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 1.0;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 1000.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.NANOSECOND:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 1E-9;
                        break;
                    case AppConstant.TimeConstant.MINUTE:
                        constant = 1.6667E-11;
                        break;
                    case AppConstant.TimeConstant.HOUR:
                        constant = 2.7777E-13;
                        break;
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.1574E-14;
                        break;
                    case AppConstant.TimeConstant.WEEK:
                        constant = 1.6534E-15;
                        break;
                    case AppConstant.TimeConstant.MONTH:
                        constant = 3.80265E-16;
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = 3.1688E-17;
                        break;
                    case AppConstant.TimeConstant.DECADE:
                        constant = 3.1688E-18;
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 3.1688E-19;
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 3.1688E-20;
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 1E-6;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 0.001;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 1.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            default:
                constant = 0.0;
                break;
        }
        return constant;
    }

    public double convert() {
        Double constant = getConstant(from, to);
        return value * constant;
    }
}
