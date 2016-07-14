package com.lftechnology.ekaai.conversions;

import com.lftechnology.ekaai.constant.AppConstant;

/**
 * Model representation for Time conversion system, an extension of {@link ProportionalUnit}
 */
public class Time extends ProportionalUnit {
    public Time(Double val, String from, String to) {
        super(val, from, to);
        setReferenceUnit(AppConstant.TimeConstant.DAY);
    }

    @Override
    public Double calculateConstant(String from, String to) {
        Double constant;
        switch (from) {
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
                        constant = (1.0 / 7.0);
                        break;
                    case AppConstant.TimeConstant.YEAR:
                        constant = (1.0 / 365.0);
                        break;
                    case AppConstant.TimeConstant.CENTURY:
                        constant = 1.0 / (365.0 * 100.0);
                        break;
                    case AppConstant.TimeConstant.MILLENNIUM:
                        constant = 1.0 / (365.0 * 1000.0);
                        break;
                    case AppConstant.TimeConstant.MILLISECOND:
                        constant = 86400000.0;
                        break;
                    case AppConstant.TimeConstant.MICROSECOND:
                        constant = 86400000000.0;
                        break;
                    case AppConstant.TimeConstant.NANOSECOND:
                        constant = 86400000000000.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MINUTE:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.0 / (24.0 * 60.0);
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.HOUR:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.0 / 24.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.SECOND:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.0 / (24.0 * 60.0 * 60.0);
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.WEEK:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 7.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.YEAR:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 365.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.CENTURY:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 365.0 * 100.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MILLENNIUM:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 365 * 1000.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MILLISECOND:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.0 / (24.0 * 60.0 * 60.0 * 1000.0);
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.MICROSECOND:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.0 / (24.0 * 60.0 * 60.0 * 1000000.0);
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.TimeConstant.NANOSECOND:
                switch (to) {
                    case AppConstant.TimeConstant.DAY:
                        constant = 1.0 / (24.0 * 60.0 * 60.0 * 1000000000.0);
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
