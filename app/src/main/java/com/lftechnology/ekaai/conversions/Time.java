package com.lftechnology.ekaai.conversions;

import com.lftechnology.ekaai.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/1/16.
 */
public class Time extends ProportionalUnit {
    public Time(Double val, String from, String to) {
        super(val, from, to);
        setReferenceUnit(AppConstant.TimeConstant.SECOND);
    }

    @Override
    public Double calculateConstant(String from, String to) {
        Double constant;
        switch (from) {
            case AppConstant.TimeConstant.SECOND:
                switch (to) {
                    case AppConstant.TimeConstant.SECOND:
                        constant = 1.0;
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
                    case AppConstant.TimeConstant.YEAR:
                        constant = 3.16888E-8;
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
}
