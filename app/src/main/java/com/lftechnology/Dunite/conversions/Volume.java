package com.lftechnology.Dunite.conversions;

import com.lftechnology.Dunite.constant.AppConstant;

/**
 * Created by Grishma Shrestha <grishmashrestha@lftechnology.com> on 3/1/16.
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
                    case AppConstant.VolumeConstant.GALLON:
                        constant = 1.0;
                        break;
                    case AppConstant.VolumeConstant.BARREL:
                        constant = 0.02380952380952;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_YARD:
                        constant = 0.004951131687243;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_METER:
                        constant = 0.003785411784;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_CENTIMETER:
                        constant = 3785.411784;
                        break;
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 3785.411784;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_FEET:
                        constant = 0.1336805555556;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.VolumeConstant.BARREL:
                switch (to) {
                    case AppConstant.VolumeConstant.GALLON:
                        constant = 1344.0;
                        break;
                    case AppConstant.VolumeConstant.BARREL:
                        constant = 1.0;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_YARD:
                        constant = 0.2079475308642;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_METER:
                        constant = 0.158987294928;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_CENTIMETER:
                        constant = 158987.294928;
                        break;
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 158987.294928;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_FEET:
                        constant = 5.614583333333;
                        break;
                    default:
                        constant = 0.0;
                        break;
                }
                break;
            case AppConstant.VolumeConstant.CUBIC_YARD:
                switch (to) {
                    case AppConstant.VolumeConstant.GALLON:
                        constant = 201.974025974;
                        break;
                    case AppConstant.VolumeConstant.BARREL:
                        constant = 4.808905380334;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_YARD:
                        constant = 1.0;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_METER:
                        constant = 0.764554857984;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_CENTIMETER:
                        constant = 764554.857984;
                        break;
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 764554.857984;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_FEET:
                        constant = 27.0;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.VolumeConstant.CUBIC_METER:
                switch (to) {
                    case AppConstant.VolumeConstant.GALLON:
                        constant = 8453.505675461;
                        break;
                    case AppConstant.VolumeConstant.BARREL:
                        constant = 6.289810770432;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_YARD:
                        constant = 1.307950619314;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_METER:
                        constant = 1.0;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_CENTIMETER:
                        constant = 1000000.0;
                        break;
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 1000000.0;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_FEET:
                        constant = 35.31466672149;
                        break;
                    default:
                        break;
                }
                break;
            case AppConstant.VolumeConstant.CUBIC_CENTIMETER:
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
                    case AppConstant.VolumeConstant.GALLON:
                        constant = 6.228835459043;
                        break;
                    case AppConstant.VolumeConstant.BARREL:
                        constant = 0.178107606679;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_YARD:
                        constant = 0.03703703703704;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_METER:
                        constant = 0.028316846592;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_CENTIMETER:
                        constant = 28316.846592;
                        break;
                    case AppConstant.VolumeConstant.MILLILITER:
                        constant = 28316.846592;
                        break;
                    case AppConstant.VolumeConstant.CUBIC_FEET:
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
