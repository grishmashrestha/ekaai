package com.lftechnology.ekaai.conversions;

import com.lftechnology.ekaai.constant.AppConstant;

/**
 * Model representation for Volume conversion system, an extension of {@link ProportionalUnit}
 */
public class Volume extends ProportionalUnit {
    public Volume(Double val, String from, String to) {
        super(val, from, to);
        setReferenceUnit(AppConstant.VolumeConstant.MILLILITER);
    }

    @Override
    public Double calculateConstant(String from, String to) {
        Double constant = 0.0;
        switch (from) {
            case AppConstant.VolumeConstant.GALLON:
                switch (to) {
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 3785.411784;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.VolumeConstant.BARREL:
                switch (to) {
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 158987.294928;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.VolumeConstant.CUBIC_YARD:
                switch (to) {
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 764554.857984;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.VolumeConstant.CUBIC_METER:
                switch (to) {
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 1000000.0;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.VolumeConstant.CUBIC_CENTIMETER:
                switch (to) {
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 1.0;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.VolumeConstant.MILLILITER:
                switch (to) {
                    case AppConstant.VolumeConstant.GALLON:
                        constant = 0.0002641720523582;
                        break;
                    case AppConstant.VolumeConstant.BARREL:
                        constant = 0.00002749615603739;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_YARD:
                        constant = 0.000001307950619314;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_METER:
                        constant = 0.000001;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_CENTIMETER:
                        constant = 1.0;
                        break;
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 1.0;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_FEET:
                        constant = 0.00003531466672149;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.VolumeConstant.CUBIC_FEET:
                switch (to) {
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 28316.846592;
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
